class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int nSum = (n*(n+1))/2;
        
        int arrSum=IntStream.of(nums).sum();
        
        return nSum-arrSum;
    }
}
