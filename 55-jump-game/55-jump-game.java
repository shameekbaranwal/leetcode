class Solution {
    boolean[] dp;
    public boolean canJump(int[] nums) {
        int maxReached = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (maxReached < i) return false;
            if (nums[i] + i > maxReached)
                maxReached = nums[i] + i;
        }
        
        if (maxReached >= nums.length - 1)
            return true;
        return false;
    }
}