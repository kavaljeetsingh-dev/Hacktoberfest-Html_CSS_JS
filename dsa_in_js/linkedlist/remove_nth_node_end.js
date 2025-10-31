/**
 * Definition for singly-linked list.
 */
export class ListNode {
  /**
   * Creates a new ListNode.
   * @param {number} value The value of the node
   * @param {ListNode} next The reference to the next node (default is null)
   */
  constructor(value = 0, next = null) {
    this.value = value;
    this.next = next;
  }
}

/**
 * Removes the Nth node from the end of the linked list using the Two-Pass method.
 * @param {ListNode} head The head of the linked list
 * @param {number} n The position (from the end) of the node to remove
 * @returns {ListNode} The head of the modified linked list
 */
export function removeNthFromEnd(head, n) {
  // ---- First Pass: Find length of list ----
  let length = 0;
  let current = head;
  while (current) {
    length++;
    current = current.next;
  }

  // If head itself needs to be removed
  if (n === length) return head.next;

  // ---- Second Pass: Find node before the one to remove ----
  current = head;
  for (let i = 1; i < length - n; i++) {
    current = current.next;
  }

  // Remove the Nth node
  if (current.next) {
    current.next = current.next.next;
  }

  return head;
}

/**
 * Helper function to print the linked list (for testing purposes).
 * @param {ListNode} head The head of the linked list
 */
export function printList(head) {
  const values = [];
  let current = head;
  while (current) {
    values.push(current.value);
    current = current.next;
  }
  console.log(values.join(" -> "));
}

// ---- Example Self-Test (Runs only in Browser/Node Console) ----
if (typeof window !== "undefined" || typeof process !== "undefined") {
  (function selfTest() {
    const head = new ListNode(1, 
      new ListNode(2, 
        new ListNode(3, 
          new ListNode(4, 
            new ListNode(5)
          )
        )
      )
    );

    console.log("Original list:");
    printList(head);
    console.log("---");

    const n = 2;
    const modifiedHead = removeNthFromEnd(head, n);
    console.log(`After removing ${n}th node from end:`);
    printList(modifiedHead);
    console.log("---");
  })();
}
