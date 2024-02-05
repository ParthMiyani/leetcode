class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t) or t == "":
            return ""
        
        countT = Counter(t)
        window = {}
        have, need = 0, len(t)
        res, resL = [-1, -1], float("infinity")
        l = 0

        for r in range(len(s)):
            window[s[r]] = 1 + window.get(s[r], 0)

            if s[r] in countT and window[s[r]] <= countT[s[r]]:
                have += 1
            
            while have == need:
                #update our result
                if (r - l + 1) < resL:
                    res = [l, r]
                    resL = r - l + 1
                    print(res)

                # pop from left
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                    print(have)
                l += 1

        l, r = res
        return s[l: r + 1] if resL != float("infinity") else ""