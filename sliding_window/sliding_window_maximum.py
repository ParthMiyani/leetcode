class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        q = collections.deque() # index
        l, r = 0, 0

        while r < len(nums):
            # remmove small number - monotonic queue
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            q.append(r)
            
            # remove left
            if l > q[0]:
                q.popleft()
            
            # condition for the first window and when to update l
            if (r + 1) >= k:
                res.append(nums[q[0]])
                l += 1
            r += 1
            
        return res