class ProductOfNumbers {

    List<Integer> prefixProducts;
    int len;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
        this.len = 0;
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
            this.len = 0;
        } else {
            prefixProducts.add(num * prefixProducts.get(this.len));
            this.len++;
        }
    }

    public int getProduct(int k) {
        if (k > this.len){
            return 0;
        }
        return prefixProducts.get(this.len) / this.prefixProducts.get(this.len - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
