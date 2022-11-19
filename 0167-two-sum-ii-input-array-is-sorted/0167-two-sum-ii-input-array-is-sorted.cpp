class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        // two-pointer approach
        
        int start = 0;
        int end = numbers.size() - 1;
        
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) {
                end--;
                continue;
            }
            if (sum < target) {
                start++;
                continue;
            }
            break;
        }
        
        vector<int> result;
        result.push_back(start+1);
        result.push_back(end+1);
        return result;
    }
};