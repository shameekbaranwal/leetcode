class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        // make a hashset with the array
        // every consecutive sequence in the array STARTS with a number, and we can find the starting element of all these sequences by looking for a number that doesn't have a corresponding number-1 element in the set.
        // once we have a list of all the starting elements of all possible sequences, we just go through every one of them and count the number of consecutive elements present in the set.
        
        // make a hashset
        unordered_set<int> set(nums.begin(), nums.end());
                
        int maxValue = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (set.find(nums[i] - 1) == set.end()) {
                int value = nums[i];
                int size = 0;
                
                while (set.find(value) != set.end()) {
                    size++;
                    value++;
                }
                
                maxValue = max(maxValue, size);
            }
        }
        
        return maxValue;
    }
};