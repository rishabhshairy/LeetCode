class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        for (int citation : citations) {
            papers[Math.min(citation, n)]++;
        }

        // finding H-Index
        int h = n;
        int s = papers[n];
        while (h > s) {
            h--;
            s += papers[h];
        }
        return h;
    }
}
