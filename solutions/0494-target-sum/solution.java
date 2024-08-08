class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, HashMap<Integer, Integer>> dpMap = new HashMap<>();

        return totalWays(n - 1, nums, target, dpMap);
    }

    private int totalWays(int index, int[] nums, int target, HashMap<Integer, HashMap<Integer, Integer>> dpMap) {

        // base condition
        if (index == 0) {
            // since both ways can add up to answer
            int ways = 0;

            if (target - nums[index] == 0) {
                ways++;
            }
            if (target + nums[index] == 0) {
                ways++;
            }

            return ways;
        }

        // using dpMap since we cannot store negative index in table
        if (dpMap.containsKey(index)) {
            if (dpMap.get(index).containsKey(target)) {
                return dpMap.get(index).get(target);
            }
        }

        int addition = totalWays(index - 1, nums, target + nums[index], dpMap);
        int subtraction = totalWays(index - 1, nums, target - nums[index], dpMap);

        int totalWays = addition + subtraction;
        // Memoizing now
        HashMap<Integer, Integer> targetWayMap = new HashMap<>();
        targetWayMap.put(target, totalWays);
        dpMap.put(index, targetWayMap);
        
        return totalWays;
    }
}
