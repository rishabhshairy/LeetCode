class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalPoint = 0;
        int window = cardPoints.length - k;
        for (int points : cardPoints) {
            totalPoint += points;
        }

        if (window == 0) {
            return totalPoint;
        }

        int left = 0;
        int right = 0;

        int sum = 0, maxi = 0;

        while (right < cardPoints.length) {
            sum += cardPoints[right];

            if (right - left + 1 == window) {
                maxi = Math.max(maxi, totalPoint - sum);
                sum -= cardPoints[left++];
                right++;
            }
            if (right - left + 1 < window) {
                right++;
            }
        }
        return maxi;
    }
}
