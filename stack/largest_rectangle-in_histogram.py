class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [] # pair (index, height)
        maxArea=0

        for i, h in enumerate(heights):
            start = i
            while stack and h < stack[-1][1]:
                stackI, stackH = stack.pop()
                maxArea = max(maxArea, stackH * (i - stackI))
                start = stackI
            stack.append([start, h])
            
        for i, h in stack:
            maxArea = max(maxArea, h * (len(heights) - i))
        
        return maxArea