import java.util.HashSet;

/**
 * Created by 46184 on 2017/11/2.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class SubarraySum {
    public static int subarraySum(int[] array,int k){
        HashSet<Integer> perSum=new HashSet<>();
        int sum=0;
        int count=0;
        perSum.add(sum);
        for(int i:array){
            if(perSum.contains(i+sum-k)){
                count++;
            }
            sum+=i;
            perSum.add(sum);
        }
        return count;
    }
}
