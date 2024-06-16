class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        else:
            s=str(x)
            s=s[::-1]
            s=int(s)
            return s==x;
