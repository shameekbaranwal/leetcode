class Solution {
public:
    int trap(vector<int>& height) {
        // minimum of the max height in the left subarray and the max height in the right subarray gives the max amount of water you can store in a location. this value minus the actual height at that position gives the actual amount of water you can store there. 
        int n = height.size();
        vector<int> maxLeft(n), maxRight(n);
        maxLeft[0] = 0;
        maxRight[n-1] = 0;
        
        for (int i = 1; i < n; i++) 
            maxLeft[i] = max(maxLeft[i-1], height[i-1]);
        
        for (int i = n-2; i >= 0; i--) 
            maxRight[i] = max(maxRight[i+1], height[i+1]);
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int water = min(maxLeft[i], maxRight[i]) - height[i];
            water = max(water, 0);
            result += water;
            // cout << maxLeft[i] << " " << maxRight[i] << endl;
        }
        
        return result;
    }
};