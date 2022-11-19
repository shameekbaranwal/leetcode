class Solution {
public:
    bool isPalindrome(string s) {
        int len = s.length();
        
        int start = 0, end = len - 1;
        
        while (start < end) {
            while (!isalnum(s[start]) && start < end) start++;
            while (!isalnum(s[end]) && start < end) end--;
            
            if (tolower(s[start++]) != tolower(s[end--])) return false;
        }
        
        return true;
    }
};