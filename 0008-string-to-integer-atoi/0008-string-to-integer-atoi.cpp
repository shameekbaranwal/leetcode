class Solution {
public:
    int myAtoi(string s) {
        int sign = 1;
        bool step = true;
        
        double num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            
            if (c == ' ') {
                if (step) continue;
                break;
            }
            
            if (c == '-') {
                if (step) {
                    step = false;
                    sign = -1;
                    continue;
                }
                break;
            }
            
            if (c == '+') {
                if (step) {
                    step = false;
                    continue;
                }
                break;
            }
            
            if (c >= '0' && c <= '9') {
                step = false;
                int digit = (int) (c - '0');
                num = num * 10 + digit;
                continue;
            }
            
            break;
        }
        
        num = num * sign;
        
        if (num > INT_MAX) num = INT_MAX;
        if (num < INT_MIN) num = INT_MIN;
        
        return (int) num;
    }
};