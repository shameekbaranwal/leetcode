class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        for (int i = 0; i < nums.length-1; i++) {
            ans[0] = i;
            for (int j = i+1; j < nums.length; j++) {
                ans[1] = j;
                if (nums[ans[0]] + nums[ans[1]] == target)
                    return ans;
            }
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }
}