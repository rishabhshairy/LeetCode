class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sumOfDigits = findSum(nums[i]);
            map.computeIfAbsent(sumOfDigits, k -> new PriorityQueue<>((x, y) -> y - x)).offer(nums[i]);
        }

        System.out.println(map);
        int maxSum = -1;

        for (Integer key : map.keySet()) {
            int sum = 0;
            if (map.get(key).size() > 1) {
                PriorityQueue<Integer> currQueue = map.get(key);
                int index = 2;
                while (!currQueue.isEmpty() && index-- > 0) {
                    sum += currQueue.poll();
                }
                maxSum = Math.max(maxSum,sum);
            }

        }
        System.out.println(maxSum);
        return maxSum;
    }

    private int findSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
