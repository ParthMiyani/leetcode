class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        total = len(A) + len(B)
        half = total // 2

        if len(B) < len(A):
            A, B = B, A

        l, r = 0, len(A) - 1
        while True:
            Amid = l + (r - l) // 2
            Bmid = half - Amid - 2 # -2 because index

            Aleft = A[Amid] if Amid >= 0 else float("-infinity")
            Aright = A[Amid + 1] if (Amid + 1) < len(A) else float("infinity")
            Bleft = B[Bmid] if Bmid >= 0 else float("-infinity")
            Bright = B[Bmid + 1] if (Bmid + 1) < len(B) else float("infinity")
            
            # partition is correct
            if Aleft <= Bright and Bleft <= Aright:
                # odd
                if total % 2:
                    return min(Aright, Bright)
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            elif Aleft > Bright:
                r = Amid - 1
            else:
                l = Amid + 1
