import java.util.HashMap;

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private DoublyLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        list.remove(node);
        list.addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;

            list.remove(node);
            list.addFirst(node);

        } else {

            if (map.size() == capacity) {

                Node lru = list.removeLast();
                map.remove(lru.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);

            list.addFirst(node);
        }
    }
}