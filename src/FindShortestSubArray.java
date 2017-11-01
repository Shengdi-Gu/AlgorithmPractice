import java.util.Collections;
import java.util.HashMap;

/**
 * Created by 46184 on 2017/11/1.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] array) {
        //用于统计每个元素出现的次数
        HashMap<Integer, Integer> count = new HashMap<>();
        //用于保存每个元素最左侧出现位置的下标
        HashMap<Integer, Integer> leftIndex = new HashMap<>();
        //用于保存每个元素最右侧出现位置的下标
        HashMap<Integer, Integer> rightIndex = new HashMap<>();

        //遍历数组，记录各元素出现频率和最左侧最右侧出现下标
        for (int i = 0; i < array.length; i++) {
            //统计频率
            count.put(array[i], count.getOrDefault(array[i], 0) + 1);
            //记录最右侧下标
            rightIndex.put(array[i], i);
            //记录最左侧下标
            leftIndex.putIfAbsent(array[i], i);
        }
        //计算数组的度，即最多元素出现的频率
        int degree = Collections.max(count.values());
        //定义最小满足条件的子序列的长度
        int length = array.length;
        //遍历所有出现过的相同元素
        for (int i : leftIndex.keySet()) {
            //当该元素出现的频率等于数组的度时，即该元素可能决定了数组的度时
            if (degree == count.get(i)) {
                //计算由该元素所就决定的最短子序列的长度
                int ilength = rightIndex.get(i) - leftIndex.get(i) + 1;
                //获取所有决定度的元素的最短序列
                length = length < ilength ? length : ilength;
            }
        }
        return length;
    }
}
