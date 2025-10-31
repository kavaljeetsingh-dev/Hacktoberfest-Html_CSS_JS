/**
 * LRU Cache implementation with TTL (Time-to-Live) optimization.
 * Uses:
 * - Doubly Linked List for O(1) LRU operations.
 * - Min-Heap for efficiently tracking and removing expired keys.
 */

/**
 * Doubly Linked List Node
 */
class Node {
  constructor(key, value, expiryTime = null) {
    this.key = key;
    this.value = value;
    this.expiryTime = expiryTime; // Used for TTL
    this.prev = null;
    this.next = null;
  }
}

/**
 * Min-Heap implementation for TTL expiration tracking
 */
class MinHeap {
  constructor() {
    this.heap = [];
  }

  // Insert node with expiryTime
  push(node) {
    this.heap.push(node);
    this._bubbleUp(this.heap.length - 1);
  }

  // Remove and return node with smallest expiryTime
  pop() {
    if (this.heap.length === 0) return null;
    const root = this.heap[0];
    const end = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = end;
      this._sinkDown(0);
    }
    return root;
  }

  peek() {
    return this.heap[0] || null;
  }

  _bubbleUp(index) {
    const element = this.heap[index];
    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      const parent = this.heap[parentIndex];
      if (element.expiryTime >= parent.expiryTime) break;
      this.heap[parentIndex] = element;
      this.heap[index] = parent;
      index = parentIndex;
    }
  }

  _sinkDown(index) {
    const length = this.heap.length;
    const element = this.heap[index];
    while (true) {
      let leftIndex = 2 * index + 1;
      let rightIndex = 2 * index + 2;
      let swap = null;

      if (leftIndex < length) {
        const left = this.heap[leftIndex];
        if (left.expiryTime < element.expiryTime) swap = leftIndex;
      }
      if (rightIndex < length) {
        const right = this.heap[rightIndex];
        if (
          (swap === null && right.expiryTime < element.expiryTime) ||
          (swap !== null && right.expiryTime < this.heap[swap].expiryTime)
        ) {
          swap = rightIndex;
        }
      }
      if (swap === null) break;
      this.heap[index] = this.heap[swap];
      this.heap[swap] = element;
      index = swap;
    }
  }
}

/**
 * LRU Cache with TTL
 */
export class LRUCache {
  /**
   * @param {number} capacity Maximum number of items the cache can hold
   * @param {number} ttl Time-to-live in milliseconds for each cache entry
   */
  constructor(capacity, ttl = 0) {
    this.capacity = capacity;
    this.ttl = ttl;
    this.map = new Map();
    this.head = new Node(0, 0); // Dummy head
    this.tail = new Node(0, 0); // Dummy tail
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.minHeap = new MinHeap(); // For TTL tracking
  }

  /**
   * Get value from cache (returns null if expired or not found)
   */
  get(key) {
    this._evictExpired();
    if (!this.map.has(key)) return null;

    const node = this.map.get(key);
    if (node.expiryTime && Date.now() > node.expiryTime) {
      this._removeNode(node);
      this.map.delete(key);
      return null;
    }

    this._moveToHead(node);
    return node.value;
  }

  /**
   * Put a key-value pair into cache
   */
  put(key, value) {
    this._evictExpired();

    if (this.map.has(key)) {
      const node = this.map.get(key);
      node.value = value;
      node.expiryTime = this.ttl ? Date.now() + this.ttl : null;
      this._moveToHead(node);
      this.minHeap.push(node);
    } else {
      if (this.map.size >= this.capacity) {
        const lru = this.tail.prev;
        this._removeNode(lru);
        this.map.delete(lru.key);
      }

      const newNode = new Node(key, value, this.ttl ? Date.now() + this.ttl : null);
      this.map.set(key, newNode);
      this._addNode(newNode);
      this.minHeap.push(newNode);
    }
  }

  /**
   * Internal function: move node to head (most recently used)
   */
  _moveToHead(node) {
    this._removeNode(node);
    this._addNode(node);
  }

  _addNode(node) {
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next.prev = node;
    this.head.next = node;
  }

  _removeNode(node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  /**
   * Remove expired entries using min-heap
   */
  _evictExpired() {
    while (this.minHeap.peek() && this.minHeap.peek().expiryTime <= Date.now()) {
      const expiredNode = this.minHeap.pop();
      if (this.map.has(expiredNode.key) && this.map.get(expiredNode.key).expiryTime <= Date.now()) {
        this._removeNode(expiredNode);
        this.map.delete(expiredNode.key);
      }
    }
  }
}

/**
 * Example usage (for testing)
 */
if (typeof window !== "undefined" || typeof process !== "undefined") {
  (function selfTest() {
    const cache = new LRUCache(3, 2000); // capacity 3, TTL 2s

    cache.put(1, "A");
    cache.put(2, "B");
    cache.put(3, "C");

    console.log("Initial cache: should contain 1:A, 2:B, 3:C");
    console.log(cache.get(1)); // Access 1 -> most recently used

    cache.put(4, "D"); // Evicts least recently used (2)

    console.log("After adding 4:D, cache should evict 2");
    console.log(cache.get(2)); // null

    setTimeout(() => {
      console.log("After 2.5s (TTL expired):");
      console.log(cache.get(1)); // null (expired)
    }, 2500);
  })();
}
