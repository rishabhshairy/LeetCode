class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        // if (nums.length == 1) {
        //     return new boolean[] { true };
        // }
        
        int n = queries.length;
        boolean[] result = new boolean[n];
        int[] prefix = new int[nums.length];
        prefix[0] = 0;

        // calculate violative index
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        int index = 0;

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            result[index++] = prefix[end] - prefix[start] == 0;
        }
        return result;
    }
}
