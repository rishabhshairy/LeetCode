class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstSum = 0;
        int secondSum = 0;
        int targetSum = 0;

        for (char c :
                firstWord.toCharArray()) {
            int num = Math.abs(97 - (int) c);
            firstSum = (firstSum * 10) + num;

        }
        for (char c :
                secondWord.toCharArray()) {
            int num = Math.abs(97 - (int) c);
            secondSum = (secondSum * 10) + num;

        }
        for (char c :
                targetWord.toCharArray()) {
            int num = Math.abs(97 - (int) c);
            targetSum = (targetSum * 10) + num;

        }
        return (firstSum + secondSum) == targetSum;
    }
}
