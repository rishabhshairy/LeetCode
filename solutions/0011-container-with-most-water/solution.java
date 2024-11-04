class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int area = 0;

        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            // since we want to maximize container--> difference of walls should be minimum
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
