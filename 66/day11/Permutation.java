import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str == null || str.length() == 0) return ans;
        helper(str.toCharArray(), 0, ans);
        Collections.sort(ans);
        return ans;
    }
    public void helper(char[] chars, int start, ArrayList<String> ans) {
        if(start == chars.length - 1) {
            ans.add(String.valueOf(chars));
            return;
        }
        Set<Character> charSet = new HashSet<Character>();
        for(int i = start; i < chars.length; i++) {
            if(i == start || !charSet.contains(chars[i])) {
                charSet.add(chars[i]);
                swap(chars, start, i);
                helper(chars, start + 1, ans);
                swap(chars, start, i);
            }
        }
    }
    public void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
}