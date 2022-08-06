class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, ArrayList<Integer>> map = new HashMap<>();
            
        for (int i = 0; i < strs.length; i++) {
            ArrayList<Integer> count = getCount(strs[i]);
            if (!map.containsKey(count)) 
                map.put(count, new ArrayList<Integer>());
        
            map.get(count).add(i);
        }
        
        List<List<String>> result = new ArrayList<>(); 
        for (ArrayList<Integer> matching : map.values()) {
            List<String> l = new ArrayList<>();
            for (int i : matching)
                l.add(strs[i]);
            result.add(l);
        }
        
        return result;
    }
    
    public ArrayList<Integer> getCount(String s) {
        ArrayList<Integer> count = new ArrayList<Integer>();
        for (int i = 0; i < 26; i++)
            count.add(0);
        
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            count.set(ch, count.get(ch) + 1);
        }
        return count;
    }
}