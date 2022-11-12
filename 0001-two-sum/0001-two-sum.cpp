class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            int val = target - nums[i];
            if (map.find(val) != map.end()) {
                return {i, map[val]};
            }
            
            map[nums[i]] = i;
        }
        
        return {0, 0};
    }
};