class MyHashMap {

 static final int SIZE = 1000;
    List<Node>[] nodeMap;

    public MyHashMap() {
        nodeMap = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            nodeMap[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        List<Node> bucket = getBucket(key);
        for (Node node : bucket) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }
        bucket.add(new Node(key, value));
    }

    public int get(int key) {

        List<Node> bucket = getBucket(key);
        for (Node node : bucket) {
            if (node.key == key) {
                return node.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        List<Node> bucket = getBucket(key);
        Iterator<Node> nodeIterator = bucket.iterator();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            if (node.key == key) {
                nodeIterator.remove();
                return;
            }
        }
    }

    private List<Node> getBucket(int key) {
        int index = hash(key);
        return nodeMap[index];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    static class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
