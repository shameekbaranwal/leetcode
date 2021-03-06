class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[idx] != 0) {
                nums[i] = idx;
                count[idx]--;
                continue;
            }
            idx++; i--;
        }
    }
}