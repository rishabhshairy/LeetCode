class Solution {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i=nums.length-1;
        while(i>=0){
            if(nums[i]==val){
                for( int j=i;j<nums.length-1;j++){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
                
            }
            i--;

        }
        int length=0;
        for(int k=0;k<nums.length;k++){
            if(nums[k]==val){
                break;
            }
            length++;
        }
        return length;
    }
}
