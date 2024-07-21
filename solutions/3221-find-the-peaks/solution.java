class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        if (mountain.length == 3) {
            if (mountain[1] > mountain[0] && mountain[1] > mountain[2]) {
                return List.of(1);
            } else {
                return new ArrayList<>();
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }
}
