class Solution {
    public int[] finalPrices(int[] prices) {
        int[] p = new int[prices.length];
        p[prices.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            p[i] = prices[i];
            int j = i + 1;
            while(j < prices.length) {
                if (prices[j] <= prices[i])
                    break;
                j++;
            }
            if (j < prices.length)
                p[i] -= prices[j];
        }
        return p;
    }
}