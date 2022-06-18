class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                break;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (nums[mid] != target) mid = low;
        return mid;
    }
}