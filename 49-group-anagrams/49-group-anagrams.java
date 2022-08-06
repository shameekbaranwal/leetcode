class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            ArrayList<Integer> count = getCount(strs[i]);
            if (!map.containsKey(count)) {
                result.add(new ArrayList<>());
                map.put(count, result.size() - 1);
            }
            
            result.get(map.get(count)).add(strs[i]);
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