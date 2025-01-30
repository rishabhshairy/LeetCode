class Solution {
    public int majorityElement(int[] nums) {
        int majEle = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count++;
                majEle = nums[i];
            } else if(majEle == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==majEle){
                count++;
            }
        }

        return count > nums.length/2 ? majEle : -1;
    }
}
