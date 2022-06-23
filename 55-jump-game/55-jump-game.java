class Solution {
    boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        // the array contains whether or not it is possible to 
        // reach the last index from that position
        // filling it from the right would make the whole op
        // run in linear time.
        dp[nums.length - 1] = true;
        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0)
                dp[i] = false;
            int max = Math.min(nums[i], nums.length - i - 1);
            for(int j = max; j > 0; j--) {
                if (dp[i + j])
                    dp[i] = true;
            }
        }
        
        return dp[0];
    }
}