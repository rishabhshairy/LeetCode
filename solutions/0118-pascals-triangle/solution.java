class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> numList = new ArrayList<>();
            List<Integer> prevList = null;
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    numList.add(1);
                } else {
                    prevList = triangle.get(i - 1);
                    numList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            triangle.add(numList);
        }
        return triangle;
    }
}
