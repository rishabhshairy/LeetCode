class Solution {
    public String defangIPaddr(String address) {
        String s = address.replaceAll("\\.", "[.]");
        return s;
    }
}
