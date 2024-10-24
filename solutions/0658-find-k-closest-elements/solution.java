class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = findLowerBound(arr, x);
        int right = left + 1;
//        System.out.println(arr[left]);
        List<Integer> result = new ArrayList<>();

        while (k > 0 && left >= 0 && right < arr.length) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
            k--;
        }

        // add left out elements
        while (k > 0 && left >= 0) {
            result.add(arr[left--]);
            k--;
        }

        while (k > 0 && right < arr.length) {
            result.add(arr[right++]);
            k--;
        }

        Collections.sort(result);
//        System.out.print(result);
        return result;
    }

    private int findLowerBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
