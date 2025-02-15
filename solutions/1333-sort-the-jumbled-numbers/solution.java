class Solution {
    static class Number {
        int original;
        int mapped;

        public Number(int original, int mapped) {
            this.original = original;
            this.mapped = mapped;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "original=" + original +
                    ", mapped=" + mapped +
                    '}';
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        List<Number> numberList = new ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            StringBuilder mapped = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                mapped.append(mapping[s.charAt(i) - '0']);
            }
            numberList.add(new Number(num, Integer.parseInt(mapped.toString())));
        }

        Collections.sort(numberList, (x, y) -> x.mapped - y.mapped);
        for (int i = 0; i < numberList.size(); i++) {
            result[i] = numberList.get(i).original;
        }
        return result;
    }

}
