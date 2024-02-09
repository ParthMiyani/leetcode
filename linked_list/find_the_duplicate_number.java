// Source: https://leetcode.com/problems/find-the-duplicate-number/
class Solution {
    public int findDuplicate(int[] nums) {
        // floyde tortoise and hare
        // slow and fast pointers will meet at some point
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // find the start of the cycle
        // reset slow2 to 0 and move both slow and slow2 by 1
        // they will meet at the start of the cycle
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}