class AllOne {

    TreeMap<String, Integer> map;
    TreeSet<Pair> set;

    public AllOne() {
        map = new TreeMap<>();
        set = new TreeSet<>((x, y) -> x.value.equals(y.value) ? y.key.compareTo(x.key) : x.value - y.value);
    }

    public void inc(String key) {
        int x = map.getOrDefault(key, 0);
        set.remove(new Pair(x, key));
        map.put(key, x + 1);
        set.add(new Pair(x + 1, key));
    }

    public void dec(String key) {
        int x = map.get(key);
        set.remove(new Pair(x, key));
        if (x == 1) {
            map.remove(key);
            return;
        } else {
            map.put(key, map.get(key) - 1);
            set.add(new Pair(x - 1, key));
        }
    }

    public String getMaxKey() {
        if (map.isEmpty()) {
            return "";
        }
        return set.last().key;
    }

    public String getMinKey() {
        if (map.isEmpty()) {
            return "";
        }
        return set.first().key;
    }

    static class Pair {
        Integer value;
        String key;

        public Pair(Integer value, String key) {
            this.value = value;
            this.key = key;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
