class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        double m1 = -1, m2 = -1;
        int i = 0, j = 0, count = 0;
        int n=a.length;
        int m=b.length;
        

        if ((m + n) % 2 != 0) {
            for (count = 0; count <= (m + n) / 2; count++) {
                if (i != n && j != m) {
                     m1 = (a[i] > b[j]) ? b[j++] : a[i++];
                } else if (i < n) {
                    m1 = a[i++];
                } else {
                    m1 = b[j++];
                }
            }
            return m1;
        } else {
            for (count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                   m1 = (a[i] > b[j]) ? b[j++] : a[i++];
                } else if (i < n) {
                    m1 = a[i++];
                } else {
                    m1 = b[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}
