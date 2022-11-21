class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> triplets;
        
        if (nums.size() < 3) return triplets;
    
        for (int i = 0; i < nums.size(); i++) {
            if ((i > 0 && nums[i] == nums[i-1])) continue;
            if (nums[i] > 0) break;
                
            int targetSum = -nums[i];
            
            // two-pointer approach for two sum from i+1 to end.
            int start = i + 1;
            int end = nums.size() - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                
                if (sum > targetSum) {
                    end--;
                    continue;
                }
                
                if (sum < targetSum || 
                    (nums[start] == nums[start - 1] && start > i + 1)) {
                    start++;
                    continue;
                }
                
                triplets.push_back({ nums[i], nums[start], nums[end] });
                start++;
                end--;
            }
        }
        
        return triplets;
    }
    
};