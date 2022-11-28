class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        int i = 0, j = n-1;
        
        int maxArea = 0;
        
        while (i < j) {
            if (height[i] > height[j]) {
                maxArea = max(maxArea, height[j] * (j-i));
                j--;
            } else {
                maxArea = max(maxArea, height[i] * (j-i));
                i++;
            }
        }
        
        return maxArea;
    }
};