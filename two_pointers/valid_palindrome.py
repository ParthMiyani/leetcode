class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ""
        for c in s:
            if c.isalpha() or c.isdigit():
                newStr += c.lower()
            
        return (newStr == newStr[::-1])