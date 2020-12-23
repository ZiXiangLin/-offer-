
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        // 个位 每10出现一次，最后一个区间0无
        // n/10 + n % 10 == 0 ? 0 : 1;
        // 十位  (n/100)*10 + 0(n%100<10)/10(>19)/n%100-10+1
        // 百位  (n/1000)*100 + 0(n%1000<100)/100(>199)/n%1000-100+1
        if(n < 0) return 0;
        int ans = 0;
        for(int i = 1; i <= n; i*=10) {
            int diviver = i * 10;
            ans += (n / diviver) * i + Math.min(Math.max(n%diviver - i + 1, 0), i);
        }
        return ans;
    }
}