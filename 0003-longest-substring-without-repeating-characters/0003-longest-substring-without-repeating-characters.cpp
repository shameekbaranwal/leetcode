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
            if (!travelling) {
                // since travelling is stopped because of a repeating char
                // trace ahead with backward pointer to look for 
                // the earlier occurrence of the repeating letter
                char curr = s[i++];
                // if this isn't the repeating letter, it's not in largest
                // consecutive unique sequence anymore
                if (look_for != curr) {
                    set.erase(curr);
                    continue;
                }
                // when first occurrence found, start travelling again.
                j++;
                travelling = true;
                continue;
            }
            // make the forward pointer travel ahead
            // as long as consecutive letters are unique
            char c = s[j];
            int sz = set.size();
            set.insert(c);
            // if the letter was not unique, stop travelling.
            if (set.size() == sz) {
                travelling = false;
                look_for = c;
                continue;
            }
            // if letter was unique, keep track of max length and
            // keep travelling ahead
            j++;
            max_length = max(max_length, (int) set.size());
            continue;
            
        }
        
        return max_length;
    }
};