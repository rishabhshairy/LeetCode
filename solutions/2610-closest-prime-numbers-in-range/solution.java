class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = findPrimes(right);
        int leftIndex = -1;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) >= left) {
                leftIndex = i;
                break;
            }
        }

        int mini = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        if (primes.size() <= 1 || leftIndex ==-1) {
            return result;
        }

        for (int i = leftIndex; i < primes.size() - 1; i++) {
            int p1 = primes.get(i);
            int p2 = primes.get(i + 1);
            int diff = p2 - p1;
            if (diff < mini) {
                mini = diff;
                result[0] = p1;
                result[1] = p2;
            }
        }
        return result;
    }

    private List<Integer> findPrimes(int n) {
        List<Integer> allPrimes = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            allPrimes.add(1);
        }

        allPrimes.set(0, 0);
        allPrimes.set(1, 0);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (allPrimes.get(i) == 1) {
                for (int j = i * i; j <= n; j += i) {
                    allPrimes.set(j, 0);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (allPrimes.get(i) == 1) {
                result.add(i);
            }
        }
        return result;
    }
}
