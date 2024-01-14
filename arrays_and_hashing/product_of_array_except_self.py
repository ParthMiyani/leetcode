class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        prefixNum = 1
        postfixNum = 1
        lenOfNums = len(nums)
        output = [1] * lenOfNums

        for i in range(1, lenOfNums):
            prefixNum = nums[i - 1] * prefixNum
            output[i] = prefixNum

        for i in range(lenOfNums - 2, -1, -1):
            postfixNum = nums[i + 1] * postfixNum
            output[i] = output[i] * postfixNum
        
        return output