import java.util.*;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        ArrayList<Character> disabled = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if( !map.containsKey(c) && !disabled.contains(c)) {
                // the first time
                map.put(c, i);
            }
            else if( map.containsKey(c) && !disabled.contains(c)) {
                // the second time
                map.remove(c);
                disabled.add(c);
            }
        }
        if(map.size() == 0) return -1;
        Iterator iter = map.entrySet().iterator();
        int ans = Integer.MAX_VALUE;
        while(iter.hasNext()) {
            Map.Entry e = (Map.Entry) iter.next();
            ans = Math.min(ans, (int)e.getValue());
        }
        return ans;
    }
}