class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> triplets;
        
        if (nums.size() < 3) return triplets;
    
        for (int i = 0; i < nums.size(); i++) {
            // no repeated elements in the triplet
            // so first number shouldn't be a repeated occurrence
            if ((i > 0 && nums[i] == nums[i-1])) continue;
            // numbers are sorted, so if reached a positive number, no more triplets exist
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
                
                // squashed two separate if conditions into one because they both do the same thing. first one is obvious, part of normal two sum. for the second condition:
                // the SECOND number of the triplet can be the same as first occurrence (hence the `start > i+1`), but otherwise the second number can't be a repeated occurrence (hence the nums[start] == nums[start - 1])
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