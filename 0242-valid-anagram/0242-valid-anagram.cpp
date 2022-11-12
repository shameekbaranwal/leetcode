class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> maps(26);
        vector<int> mapt(26);
        
        if (s.length() != t.length()) return false;
        
        for (int i = 0; i < s.length(); i++) {
            int vs = (s[i] - 'a');
            int vt = (t[i] - 'a');

            maps[vs]++;
            mapt[vt]++;
        }
        
        cout << maps[0] << " "<< mapt[0] << endl; 
        
        for (int i = 0; i < 26; i++) 
            if (maps[i] != mapt[i]) return false;
        
        return true;
    }
};