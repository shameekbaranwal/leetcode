class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        
        vector<int> maxLeft(n), maxRight(n);
        maxLeft[0] = 0;
        maxRight[n-1] = 0;
        
        for(int i = 1; i < n; i++) {
            maxLeft[i] = max(maxLeft[i-1], height[i-1]);
            maxRight[n-1-i] = max(maxRight[n-i], height[n-i]); 
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int water = min(maxLeft[i], maxRight[i]) - height[i];
            result += max(water, 0);
        }
        
        return result;
    }
};