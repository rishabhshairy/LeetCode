class Solution {
    public int calPoints(String[] operations) {
                Stack<Integer> points = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = points.pop();
                int sum = top + points.peek();
                points.push(top);
                points.push(sum);
            } else if (op.equals("D")) {
                int val = 2 * points.peek();
                points.push(val);
            } else if (op.equals("C")) {
                points.pop();
            } else {
                points.push(Integer.parseInt(op));
            }
        }
        return points.stream().mapToInt(i -> i).sum();
    }
}
