class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int mod = (prefixSum % 2);
            if (mod == 1) {
                // count even prefix sum
                count = (count + map.getOrDefault(0, 0)) % MOD;
            } else if (mod == 0) {
                count = (count + map.getOrDefault(1, 0)) % MOD;
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}
