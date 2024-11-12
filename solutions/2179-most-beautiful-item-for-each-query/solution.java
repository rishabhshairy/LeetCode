class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
        
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        
        for (int currPrice = 0; currPrice < queries.length; currPrice++) {
            findMaxBeauty(items, queries[currPrice], currPrice, result);
        }
        return result;
    }

    public void findMaxBeauty(int[][] items, int query, int index, int[] result) {
        int left = 0;
        int right = items.length - 1;
        int currMax = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int currPrice = items[mid][0];
            if (currPrice <= query) {
                left = mid + 1;
                currMax = Math.max(currMax, items[mid][1]);
            } else {
                right = mid - 1;
            }
        }
        result[index] = currMax;
//        System.out.println(result[index]);
    }
}
