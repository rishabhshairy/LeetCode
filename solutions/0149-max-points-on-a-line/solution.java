class Solution {
    public int maxPoints(int[][] arr) {

        // Write your code here.
        if (arr.length <= 2) {
            return arr.length;
        }

        int ans = 0;
        int inf = 999999;

        // approach here is to calculate the slope of all the point wrt each other

        for (int i = 0; i < arr.length; i++) {
            Map<Double, Integer> slopeMap = new HashMap<>();
            System.out.println("i=" + i);
            for (int j = i + 1; j < arr.length; j++) {
                double slope = 0;

                // check if co-ordinates are not on 0
                if (arr[j][0] - arr[i][0] != 0) {
                    slope = (arr[j][1] - arr[i][1]) / (double) (arr[j][0] - arr[i][0]);
                } else {
                    slope = inf;
                }

                // to avpid multiple key conflict in map
                if (slope == -0.0) {
                    slope = 0.0;
                }

                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                ans = Math.max(ans, slopeMap.get(slope));

            }
            System.out.println(slopeMap);
        }
        System.out.println(ans + 1);
        return ans + 1;
    }
}
