class RandomizedSet {

    Random random;
    Map<Integer, Integer> map;
    List<Integer> copySet;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        copySet = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, copySet.size());
        copySet.add(val);
        return true;
    }

    /**
     * Here we will shift the elements
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int currIndex = map.get(val);
        int lastIndex = copySet.size() - 1;

        // we need to swap last to current index so to re-adjust
        if (currIndex != lastIndex) {
            int lastVal = copySet.get(lastIndex);
            copySet.set(currIndex, lastVal);
            map.put(lastVal, currIndex);
        }

        copySet.remove(lastIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int next = random.nextInt(copySet.size());
        return copySet.get(next);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
