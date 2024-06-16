class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ind_list=[]
        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                if nums[i]+nums[j]==target:
                    ind_list.append(i)
                    ind_list.append(j)
                    break
        return ind_list
