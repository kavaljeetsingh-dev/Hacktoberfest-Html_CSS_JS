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
 * Removes all nodes with a specified value from the linked list.
 * @param {ListNode} head The head of the linked list
 * @param {number} val The value to remove from the list
 * @returns {ListNode} The head of the modified linked list
 */
export function removeElements(head, val) {
  // Create a dummy node to handle edge cases (e.g., removing the head)
  const dummy = new ListNode(0);
  dummy.next = head;

  let current = dummy;
  while (current.next) {
    if (current.next.value === val) {
      // Skip the node with the matching value
      current.next = current.next.next;
    } else {
      current = current.next;
    }
  }

  return dummy.next;
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

// ---- Example Self-Test (Runs in Browser/Node Console) ----
if (typeof window !== "undefined" || typeof process !== "undefined") {
  (function selfTest() {
    const head = new ListNode(
      1,
      new ListNode(
        2,
        new ListNode(
          6,
          new ListNode(
            3,
            new ListNode(
              4,
              new ListNode(5, new ListNode(6))
            )
          )
        )
      )
    );

    console.log("Original list:");
    printList(head);
    console.log("---");

    const valToRemove = 6;
    const newHead = removeElements(head, valToRemove);

    console.log(`After removing all nodes with value = ${valToRemove}:`);
    printList(newHead);
    console.log("---");
  })();
}
