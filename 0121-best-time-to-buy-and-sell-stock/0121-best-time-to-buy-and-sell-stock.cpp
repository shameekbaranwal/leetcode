class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // simply keep track of the minimum value till ith position, and subtract the current value with that minimum value to get the max profit till current position.
        int minTillNow = prices[0];
        int maxProfit = 0;
        
        for (int price : prices) {
            maxProfit = max(maxProfit, price - minTillNow);
            minTillNow = min(minTillNow, price);
        }
        
        return maxProfit;
    }
};