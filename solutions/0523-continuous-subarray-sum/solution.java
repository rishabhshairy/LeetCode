class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modMap = new HashMap<Integer, Integer>();
        int prefixMod = 0;
        modMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;
            if (modMap.containsKey(prefixMod)) {
                if (i - modMap.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                modMap.put(prefixMod, i);
            }

        }
        return false;
    }
}
