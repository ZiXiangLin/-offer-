class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // value = 0: current substring doesnt contain key
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 0);
        }
        for(int cur1 = 0, cur2 = 0; cur1 < s.length(); cur1++) {
            for(; cur2 < s.length(); cur2++) {
                if(map.get(s.charAt(cur2)) == 1) break;
                else map.put(s.charAt(cur2), 1);
            }
            ans = Math.max(ans, cur2 - cur1);
            map.put(s.charAt(cur1), 0);
        }
        return ans;
    }
}