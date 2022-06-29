class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] found = new boolean[s.length()+1];
        found[0] = true;
        
        for (int i = 0; i < s.length(); ++i) {
            if (!found[i])
                continue;
            
            for (String word : dict) {
                int end = i + word.length();
                if (end > s.length() || found[end])
                    continue;
                
                if (s.substring(i, end).equals(word))
                    found[end] = true;
            }
        }
        
        return found[s.length()];
    }
}