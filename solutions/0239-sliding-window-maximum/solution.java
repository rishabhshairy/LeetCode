class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
            Deque<Integer> maxNum = new ArrayDeque<>();
            ArrayList<Integer> answer = new ArrayList<>();
        
            int i;
            for (i = 0; i < k; i++) {
                while (!maxNum.isEmpty() && arr[i] >= arr[maxNum.peekLast()]) {
                    maxNum.removeLast();
                }
                maxNum.addLast(i);
            }

            for (; i < arr.length; i++) {
                answer.add(arr[maxNum.peek()]);

                while (!maxNum.isEmpty() && maxNum.peek() <= i - k) {
                    maxNum.removeFirst();
                }
                while (!maxNum.isEmpty() && arr[i] >= arr[maxNum.peekLast()]) {
                    maxNum.removeLast();
                }
                maxNum.addLast(i);
            }
            answer.add(arr[maxNum.peek()]);
            int[] arrAns=new int[answer.size()];
            
            for(int j=0;j<arrAns.length;j++){
             arrAns[j]=answer.get(j);    
            }
            return arrAns;  
    }
}
