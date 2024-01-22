class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l, r = 0, len(matrix) - 1

        while l <= r:
            m = (l + r) // 2
            if matrix[m][-1] < target:
                l = m + 1
            elif matrix[m][0] > target:
                r = m - 1
            else:
                break

        if not (l <= r):
            return False
        
        cl, cr = 0, len(matrix[0]) - 1

        while cl <= cr:
            cm = (cl + cr) // 2
            if matrix[m][cm] < target:
                cl = cm + 1
            elif matrix[m][cm] > target:
                cr = cm - 1
            else:
                return True
        
        return False