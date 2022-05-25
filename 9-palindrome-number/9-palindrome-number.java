class Solution {
    public boolean isPalindrome(int x) {
        int n = 0, copy = x;
        if (x < 0) return false;
        while(x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n == copy;
    }
}
