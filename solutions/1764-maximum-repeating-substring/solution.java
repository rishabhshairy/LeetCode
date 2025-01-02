class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;

        String add = word;
        while (sequence.contains(add)) {
            count++;
            add += word;
        }
        System.out.println(count);
        return count;
    }
}
