class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;

        if (height.length <= 1) {
            return 0;
        }

        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
