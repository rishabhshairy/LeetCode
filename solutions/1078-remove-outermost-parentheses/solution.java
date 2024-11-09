class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder sb = new StringBuilder();

        for(Character ch: s.toCharArray()) {
            if (ch =='('){
                // append open bracket only when its enountered 2nd time 
                if(count!=0){
                    sb.append(ch);
                }
                count++;
            } else {
                // close the primitive
                count--;
                if (count!=0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
