import java.util.HashMap;

/**
 * Created by 46184 on 2017/11/5.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlength = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                maxlength = Math.max(maxlength, right - left);
                //取max，因为某些字符串map.get会取到letf之前的值
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
        }
        return Math.max(maxlength, right - left);
    }
}
