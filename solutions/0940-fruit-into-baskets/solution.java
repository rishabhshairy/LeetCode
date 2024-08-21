class Solution {
    public int totalFruit(int[] fruits) {
                Map<Integer, Integer> countMap = new HashMap<>();

        int l = 0, r = 0, maxLen = 0;
        while (r < fruits.length) {
            countMap.put(fruits[r], countMap.getOrDefault(fruits[r], 0) + 1);
            if (countMap.size() > 2) {
                countMap.put(fruits[l], countMap.get(fruits[l]) - 1);
                if (countMap.get(fruits[l]) == 0) {
                    countMap.remove(fruits[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
