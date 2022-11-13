class Solution {
public:
    static bool comparator(pair<int, int> &a, pair<int, int> &b) {
        return a.second > b.second;
    }
    
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        
        for (int i = 0; i < nums.size(); i++)
            map[nums[i]]++;
        
        vector<pair<int, int>> pairs(map.begin(), map.end());
        
        sort(pairs.begin(), pairs.end(), comparator);
        
        vector<int> result(k);
        for (int i = 0; i < k; i++) {
            result[i] = pairs[i].first;
        }
        
        return result;
    }
};