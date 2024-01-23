class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # for [4,5,6,7,0,1,2] left part = [4,5,6,,7] and right part = [0,1,2]
        
        l, r = 0, len(nums) - 1

        while l <= r:
            m = l + (r - l) // 2
            if nums[m] == target:
                return m
            
            # left part
            if nums[l] <= nums[m]:
                if target > nums[m] or target < nums[l]:
                    l = m + 1
                else:
                    r = m - 1
            # right part
            else:
                if target < nums[m] or target > nums[r]:
                    r = m - 1
                else:
                    l = m + 1

        return -1