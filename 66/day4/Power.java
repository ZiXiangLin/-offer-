public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0) return 0;
        if(exponent == 0) return 1;
        int tick = 1;
        if(exponent < 0) {
            exponent *= -1;
            tick = 0;
        }
        double ans = base;
        while(exponent > 1) {
            ans *= base;
            exponent--;
        }
        if(tick == 0) ans = 1 / ans;
        return ans;
    }
}