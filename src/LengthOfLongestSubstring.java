import java.util.HashMap;

/**
 * Created by 46184 on 2017/11/5.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        //转换为char型数组
        char[] chars = s.toCharArray();
        //定义保存窗口数据的set
        HashMap<Character, Integer> charMap = new HashMap<>();
        //用于统计长度
        int length = 0;
        int maxLength = 0;
        //窗口起始下标
        int startIndex = 0;

        //记录最长符合题目要求的子序列起始下标
        int maxStartIndex=0;
        for (int i = 0; i < chars.length; i++) {
            //如果不包含则进行添加操作
            if (charMap.containsKey(chars[i])) {
                //如果包含则说明出现重复字符，进行相关操作
                //确定当前长度是否为最大长度，如果是则记录
                if (length > maxLength) {
                    maxLength = length;
                    maxStartIndex=startIndex;
                }
                //获取重复键的下标
                int index = charMap.get(chars[i]);

                //删除从重复键到窗口开始位置的项
                for (int j = index; j >= startIndex; j--) {
                    charMap.remove(chars[j]);
                    length--;
                }
                //设置窗口起始位置
                startIndex = index + 1;
            }

            charMap.put(chars[i], i);
            length++;
        }
        //当遍历完成比较最后长度
        if (length > maxLength) {
            maxLength = length;
            maxStartIndex=startIndex;
        }
        StringBuffer longestSubstring=new StringBuffer();
        for(int i=0;i<maxLength;i++){
            longestSubstring.append(chars[maxStartIndex+i]);
        }
        System.out.println(longestSubstring);
        return maxLength;
    }
}
