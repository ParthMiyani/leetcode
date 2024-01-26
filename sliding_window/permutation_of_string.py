from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # s1count, s2count = [0] * 26, [0] * 26

        # if len(s1) > len(s2):
        #     return False

        # for i in range(len(s1)):
        #     s1count[ord(s1[i]) - ord('a')] += 1
        #     s2count[ord(s2[i]) - ord('a')] += 1

        # if s1count == s2count:
        #     return True

        # l = len(s1)
        # for r in range(len(s1), len(s2)):
        #     s2count[ord(s2[r]) - ord('a')] += 1 # add r
        #     s2count[ord(s2[r-l]) - ord('a')] -= 1 # remove l
            
        #     if s1count == s2count:
        #         return True

        # return False

        # or

        count=Counter(s1)
        curr=Counter(s2[0:len(s1)])
        l = 0

        if count == curr:
            return True
        
        for r in range(len(s1), len(s2)):
            curr[s2[r]] = curr.get(s2[r],0) + 1
            curr[s2[l]] -= 1
            
            if count==curr:
                return True

            l += 1
        
        return False