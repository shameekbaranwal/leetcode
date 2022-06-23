class Solution {
    boolean[] dp;
    public boolean canJump(int[] nums) {
        int maxReached = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (maxReached < i) return false;
            maxReached = Math.max(maxReached, i + nums[i]);
        }
        return true;
    }
}