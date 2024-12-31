class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            int max = nums[i];
            int min = nums[i];
            for(int j=i; j<n; j++)
            {
                max = (max<nums[j]) ? nums[j] : max;
                min = (min>nums[j]) ? nums[j] : min;
                ans = ans + max - min;
            }
        }
     return ans;
    }
}
