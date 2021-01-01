public class Solution {
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if(length == 0) return str;
        n = n % length;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for(int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for(int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}