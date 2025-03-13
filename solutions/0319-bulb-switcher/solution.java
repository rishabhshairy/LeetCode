class Solution {
    public int bulbSwitch(int n) {
        if(n>99998){
            return (int)Math.sqrt(n);
        }
        int[] bulb = new int[n + 1];
        Arrays.fill(bulb, 1);

        // 2nd round
        for (int j = 1; j <= n; j++) {
            if (j % 2 == 0) {
                bulb[j] = 0;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    bulb[j] = bulb[j] == 0 ? 1 : 0;
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (bulb[i] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
