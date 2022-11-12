class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        
        for (int i = 0; i < strs.size(); i++) {
            string count = getCount(strs[i]);
            map[count].push_back(strs[i]);
        }
        
        vector<vector<string>> result;
        
        for (auto pair : map) 
            result.push_back(pair.second);
        
        return result;
    }
    
    string getCount(string str) {
        vector<int> arr(26);
        
        for (int i = 0; i < str.length(); i++) 
            arr[str[i] - 'a']++;
        
        string key = "";
        for (int i = 0; i < 26; i++)
            key.append(to_string(arr[i]) + " ");
        
        return key;
    }
};