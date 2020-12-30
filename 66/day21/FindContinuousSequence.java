import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        int plow = 1, phigh = 2;
        while(phigh > plow) {
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur == sum) {
                ArrayList<Integer> elem = new ArrayList<>();
                for(int i = plow; i <= phigh; i++) {
                    elem.add(i);
                }
                ans.add(elem);
                plow++;
            }else if(cur < sum) {
                phigh++;
            }else {
                plow++;
            }
        }
        return ans;
    }
}