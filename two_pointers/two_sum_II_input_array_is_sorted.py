class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        numset = set(numbers)

        for i, n in enumerate(numbers):
            if (target - n) in numset:
                secondI = numbers.index(target - n)
                if (i + 1 == secondI + 1):
                    return (i + 1, numbers.index(target - n, secondI + 1) + 1)
                else:
                    return (i + 1, numbers.index(target - n) + 1)
        
        l, r = 0, len(numbers) - 1

        while l < r:
            curSum = numbers[l] + numbers[r]

            if curSum > target:
                r -= 1
            elif curSum < target:
                l += 1
            else:
                return [l + 1, r + 1]
