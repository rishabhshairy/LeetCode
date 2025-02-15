class Solution {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        String s = String.valueOf(x);
        if(s.charAt(0)=='0'){
            return false;
        }

        int left=0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
