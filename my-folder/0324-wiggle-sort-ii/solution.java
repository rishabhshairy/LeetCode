class Solution {
    public void wiggleSort(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int n = arr.length - 1;
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = newArr[n--];
        }
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = newArr[n--];
        }
    }
}
