class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortVisit = new ArrayList<>();

        // keeping this array to fill from back
        int[] countArr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            countArr[i] = binarySearch(nums[i], 0, sortVisit.size(), sortVisit);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < countArr.length; i++) {
            answer.add(countArr[i]);
        }
        return answer;
    }
    
  private static int binarySearch(int currNo, int start, int end, List<Integer> sortVisit) {
        int mid = (start + end) / 2;

        if (start >= end) {
            sortVisit.add(mid, currNo);
            return mid;
        }

        if (currNo > sortVisit.get(mid)) {
            return binarySearch(currNo, mid + 1, end, sortVisit);
        } else {
            return binarySearch(currNo, start, mid, sortVisit);
        }


    }
}
