class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int[][] indexNum = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            indexNum[i][0] = i; // storing index
            indexNum[i][1] = nums[i]; // storing number
        }

        Arrays.sort(indexNum, Comparator.comparingInt(i -> i[1]));


        // For duplicate element
        if (nums.length == 2 && (nums[0] + nums[1] == target)) {
            return new int[]{0, 1};
        }

        int pLeft = 0;
        int pRight = nums.length - 1;

        while (pLeft < pRight) {
            int sum = indexNum[pLeft][1] + indexNum[pRight][1];
            System.out.println(sum);
            if (sum > target) {
                pRight--;
            } else if (sum < target) {
                pLeft++;
            } else if (sum == target) {
                ans[0] = indexNum[pLeft][0];
                ans[1] = indexNum[pRight][0];
                break;
            }
        }

        return ans;
    }
}
