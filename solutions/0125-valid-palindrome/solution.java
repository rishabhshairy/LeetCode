class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer modifiedString = new StringBuffer();
        for (Character c :
                s.toCharArray()) {
            if (c.toString().matches("[a-zA-Z0-9]")) {
                modifiedString.append(c);
            }
        }

        return modifiedString.toString().toLowerCase().equals(modifiedString.reverse().toString().toLowerCase());
    }
}
