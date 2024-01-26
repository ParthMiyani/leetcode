class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l= 0
        hashset = set()
        cmax = 0

        for r in range(len(s)):
            while s[r] in hashset:
                hashset.remove(s[l])
                l += 1
            hashset.add(s[r])
            cmax = max(cmax, r - l + 1)
        
        return cmax