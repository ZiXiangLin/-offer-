public class Solution {
    public String ReverseSentence(String str) {
        String[] part = str.split(" ");
        if(part.length == 0) return str;
        StringBuilder sb = new StringBuilder();
        for(int i = part.length - 1; i >= 0; i--) {
            sb.append(part[i]);
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}