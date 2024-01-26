class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1
        maxP = 0

        while r < len(prices):
            if prices[l] < prices[r]:
                profit = prices[r] - prices[l]
                maxP = max(maxP, profit)
            else:
                l = r
            r += 1

        return maxP
        
        # cp = prices[0]
        # p = 0
        # for i in prices:
        #     if i < cp:
        #         cp = i
        #     elif p < i-cp :
        #         p = i - cp
        # return p
        
        