class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> powers = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int i = 1;

        while (i < bound) {
            int j = 1;
            while (j < bound) {
                if (i + j <= bound) {
                    System.out.println(i + j);
                    powers.add(i + j);
                }
                j *= y;
                if (y == 1) {
                    break;
                }
            }
            i *= x;
            if (x == 1) {
                break;
            }
        }

        ans.addAll(powers);
        return ans;
    }
}
