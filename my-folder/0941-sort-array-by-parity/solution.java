class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>0;i--){
            if(nums[i]%2==0){
                int j=i-1;
                while(j>=0){
                    if(nums[j]%2!=0){
                        int temp=nums[j];
                        nums[j]=nums[i];
                        nums[i]=temp;
                    }
                    j--;
                }
            }
        }
        return nums;
    }
}
