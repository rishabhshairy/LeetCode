class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int maxIndex = 0;
        boolean isIncreasing = false;
        boolean isdecreasing = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isIncreasing = true;
                continue;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                maxIndex = i;
                break;
            }
        }
        for (int i = maxIndex; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isdecreasing = true;
                continue;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                isdecreasing = false;
                break;
            }
        }
        return isIncreasing && isdecreasing;
    }
}
