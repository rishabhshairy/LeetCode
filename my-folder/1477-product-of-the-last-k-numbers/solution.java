class ProductOfNumbers {
    ArrayList<Integer> nums;
    public ProductOfNumbers() {
        nums = new ArrayList<>();
        nums.add(1);
    }

    public void add(int num) {
        if (num > 0) {
            nums.add(nums.get(nums.size() - 1) * num);
        } else {
            nums = new ArrayList<>();
            nums.add(1);
        }
    }

    public int getProduct(int k) {
        int n = nums.size();
        return k < n ? nums.get(n - 1) / nums.get(n - k -1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
