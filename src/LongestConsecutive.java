import java.util.HashSet;

/**
 * Created by 46184 on 2017/10/31.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] array) {
        HashSet<Integer> set=new HashSet<>();
        //标记最大长度
        int maxLength=0;
        for(int i:array){
            int length=1;
            //如果set中包含此数字则不处理
            if(set.contains(i)){
                continue;
            }else {
                set.add(i);
            }
            //寻找左侧和右侧的连续长度
            int k=1;
            //左侧
            while (set.contains(i-k)){
                length++;
                k++;
            }
            k=1;
            //右侧
            while (set.contains(i+k)){
                length++;
                k++;
            }
            //记录最长连续长度
            if(length>maxLength){
                maxLength=length;
            }
        }
        return maxLength;
    }
}

