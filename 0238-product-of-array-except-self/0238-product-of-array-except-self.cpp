class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int product = 1;
        int zeroesCount = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) zeroesCount++;
            else product *= nums[i];
        }
        
        int actualProduct = zeroesCount > 0 ? 0 : product;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                nums[i] = actualProduct / nums[i];
                continue;
            }
            
            nums[i] = zeroesCount == 1 ? product : 0;
        }
        
        return nums;
    }
};