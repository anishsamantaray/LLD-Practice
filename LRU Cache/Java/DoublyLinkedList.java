class DoublyLinkedList {

    Node head;
    Node tail;

    DoublyLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Add node right after head (Most Recently Used)
 public void addFirst(Node node) {

    Node tempNext = head.next;

    head.next = node;
    node.prev = head;

    node.next = tempNext;
    tempNext.prev = node;
}

    // Remove any node
    public void remove(Node node) {

        Node tempPrev = node.prev;
        Node tempNext = node.next;

        prev.next = tempNext;
        next.prev = tempPrev;
    }

    // Remove least recently used node
    public Node removeLast() {

        if (tail.prev == head) {
            return null;
        }

        Node lru = tail.prev;
        remove(lru);
        return lru;
    }
}