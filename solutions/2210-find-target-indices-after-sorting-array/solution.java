class Solution {
public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int low = findLowerBound(nums, target);
        int high = findUpperBound(nums, target);

        if (low == -1 && high == -1) {
            return result;
        }
        if (low != -1 && high - low == 0) {
            result.add(low);
            return result;
        }
        if (high - low > 0) {
            for (int i = low; i <= high; i++) {
                result.add(i);
            }
        }
        return result;
    }

    public static int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findUpperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
