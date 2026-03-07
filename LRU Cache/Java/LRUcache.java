import java.util.HashMap;

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private DoublyLinkedList dll;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        dll.remove(node);
        dll.addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;

            dll.remove(node);
            dll.addFirst(node);

            return;
        }

        Node node = new Node(key, value);

        map.put(key, node);
        dll.addFirst(node);

        if (map.size() > capacity) {

            Node lru = dll.removeLast();
            map.remove(lru.key);
        }
    }
}