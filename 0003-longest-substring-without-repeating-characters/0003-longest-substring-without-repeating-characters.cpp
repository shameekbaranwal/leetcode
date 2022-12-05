class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i = 0, j = 1, len = s.size();
        if (len < 2) return len;
        unordered_set<char> set;
        set.insert(s[0]);
        int max_length = 1;
        bool travelling = true;
        char look_for;
        
        while (j < len || !travelling) {
            // cout << s[i] << " " << s[j] << endl;
            if (travelling) {
                char c = s[j];
                int sz = set.size();
                set.insert(c);
                if (set.size() == sz) {
                    travelling = false;
                    look_for = c;
                    continue;
                }
                j++;
                max_length = max(max_length, (int) set.size());
                continue;
            }
            char curr = s[i++];
            // cout << "hello" << endl;
            
            if (look_for == curr) {
                j++;
                travelling = true;
            }
            else
                set.erase(curr);
            
        }
        
        return max_length;
    }
};