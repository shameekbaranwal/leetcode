class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] sCount = getCount(s);
        int[] tCount = getCount(t);
        
        for (int i = 0 ; i < 26; i++)
            if (sCount[i] != tCount[i]) return false;
        return true;
    }
    
    public int[] getCount(String s) {
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]++;
        }
        
        return count;
    }
}