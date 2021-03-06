import java.math.BigInteger;
import java.util.*;

/**
 * Created by 46184 on 2017/11/23.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class LeetCode {
    /**
     * 数组 283
     * 给定一个数组nums，写一个函数，将数组内的0移动到数组末尾，并保持其他非零元素在原数组中的相对位置不变。
     * 比如，给定nums = [0, 1, 0, 3, 12]，调用你的函数之后，nums应该变成[1, 3, 12, 0, 0]。
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    /**
     * 数组 27
     * 给定一个数组和一个值，原地移除数组中所有给定的值，并返回新数组的长度。
     * 不允许申请额外空间，确保空间复杂度为O(1)。
     * 数组中的元素可以被改变，不用考虑超出新长度之后的空间遗留。
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    /**
     * 数组 26
     * 给定一个有序数组，原地删除重复元素使得数组中的元素只保留一个，并且返回新长度。
     * 禁止申请额外空间，确保空间复杂度为O(1)。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    /**
     * 数组 80
     * 与数组26题条件相同，但是变更一个要求：可以允许元素最多重复2次。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[j] != nums[i]) {
                nums[j++] = nums[i];
            } else {
                if (nums[j] == nums[++i]) {

                    if (nums[j] != nums[j + 1]) {
                        nums[j + 1] = nums[j];
                    }
                    j++;
                    while (i < nums.length && nums[j] == nums[i]) {
                        i++;
                    }
                }
                if (i < nums.length) {
                    nums[++j] = nums[i];
                    i--;
                }

            }
        }
        System.out.println(Arrays.toString(nums));
        return ++j;
    }

    /**
     * 数组167
     * 给定一个整形数组，并且数组内元素已经按升序排列，找出两个元素，使得它们之和与给定的数相等。
     * 函数应该返回找到的这两个元素的索引，并且第一个元素的索引小于等于第二个元素的索引，并且元素索引起始位置是基于1而不是基于0。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum;
        int[] result = new int[2];
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = ++left;
                result[1] = ++right;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    /**
     * 数组 11
     * 给出一个非负整数 a1, a2, ..., an,它们分别代表x轴上的一个点(i, ai)，在每个点上画高度为ai的“墙”，
     * 用来代表容器。选择两堵墙，使得它们和x轴围起来的容器装水容量最大。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = 0;
        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                result = Math.max(result, (rightIndex - leftIndex) * height[leftIndex]);
                leftIndex++;
            } else {
                result = Math.max(result, (rightIndex - leftIndex) * height[rightIndex]);
                rightIndex--;
            }
        }
        return result;
    }

    /**
     * 数组 75
     * 给定一个数组，其中有n个元素，分别为红色、白色和蓝色，请将数组中的元素进行排序，使得颜色相同的元素排在一起，并且颜色顺序为红、白、蓝。
     * 我们使用整数0、1、2分别代表红、白、蓝3种颜色。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[position] == 0) {
                int temp = nums[left];
                nums[left] = nums[position];
                nums[position] = temp;

                left++;
                position++;
            } else if (nums[position] == 2) {
                int temp = nums[right];
                nums[right] = nums[position];
                nums[position] = temp;

                right--;
            } else {
                position++;
            }
        }
    }

    /**
     * 数组 215
     * 在一个无序数组中找到第k大的元素。注意这里的第k大是指在排序顺序中第k大的元素，而不是第k个不同的元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int left, int right, int k) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        int point = nums[right];
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= point) {
                swap(nums, index++, i);
            }
        }
        swap(nums, index, right);
        if (index == k) {
            return nums[index];
        } else if (index < k) {
            return findKthLargest(nums, index + 1, right, k);
        } else {
            return findKthLargest(nums, left, index - 1, k);
        }
    }

    /**
     * 数组 209
     * 给定一个整形数组和一个数组s，找出数组中最短的一个连续子数组，使得连续子数组中的元素之和sum>=s。
     * 返回这个最短连续子数组。
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int length = 0;
        int minLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            length++;
            sum += nums[i];
            if (sum >= s) {
                while (sum >= s) {
                    sum -= nums[i - length + 1];
                    length--;
                }
                if (minLength > length + 1) {
                    minLength = length + 1;
                }
            }
        }
        if (length == nums.length && sum < s) {
            return 0;
        }
        return minLength;
    }

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
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
        int maxStartIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            //如果不包含则进行添加操作
            if (charMap.containsKey(chars[i])) {
                //如果包含则说明出现重复字符，进行相关操作
                //确定当前长度是否为最大长度，如果是则记录
                if (length > maxLength) {
                    maxLength = length;
                    maxStartIndex = startIndex;
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
            maxStartIndex = startIndex;
        }
        StringBuffer longestSubstring = new StringBuffer();
        for (int i = 0; i < maxLength; i++) {
            longestSubstring.append(chars[maxStartIndex + i]);
        }
        System.out.println(longestSubstring);
        return maxLength;
    }

    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length < tChars.length) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        HashSet<Character> tSet = new HashSet<>();
        for (Character c : tChars) {
            tSet.add(c);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end;
        int minStart = 0;
        int length = s.length();
        for (int i = 0; i < sChars.length; i++) {
            if (tSet.contains(sChars[i])) {
                if (map.size() == 0) {
                    map.put(sChars[i], i);
                    start = i;
                    minStart = i;
                }
                if (map.size() == 1 && map.containsKey(sChars[i]) && map.get(sChars[i]) != i) {
                    map.put(sChars[i], i);
                    start = i;
                    minStart = i;
                }
                if (map.size() <= tSet.size()) {
                    map.put(sChars[i], i);
                    if (map.size() == tSet.size()) {
                        end = i;
                        if (end >= start) {
                            length = end - start + 1;
                        }

                    }
                }
                if (map.size() == tSet.size()) {
                    map.put(sChars[i], i);
                    if (sChars[start] == sChars[i]) {
                        end = i;
                        while (start + 1 < sChars.length && (!tSet.contains(sChars[++start])
                                || !(map.get(sChars[start]) != null && map.get(sChars[start]) == start))) ;
                        if (end >= start && length > end - start + 1) {
                            length = end - start + 1;
                            minStart = start;
                        }
                    }
                }
            }
        }
        if (map.size() < tSet.size()) {
            return "";
        }
        return s.substring(minStart, minStart + length);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    public int threeSumClosest(int[] nums, int target) {
//
//        return 0;
//    }

    /**
     * 22. Generate Parentheses
     * 给定n，有n个左括号和n个又括号，输出他们所有可能的正确的排列方式
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    /**
     * 20. Valid Parentheses
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || !stack.pop().equals('(')) {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || !stack.pop().equals('[')) {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.isEmpty() || !stack.pop().equals('{')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * 24. Swap Nodes in Pairs
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode lastNode = null;
        ListNode preNode = null;
        ListNode mh = head;
        while (node != null && node.next != null) {
            if (preNode == null) {
                mh = node.next;
            }
            //last指向第二个节点
            lastNode = node.next;
            //交换两个节点
            node.next = lastNode.next;
            lastNode.next = node;
            //将前链重新连接到前一个节点
            if (preNode != null) {
                preNode.next = lastNode;
            }
            //前节点指向第二个节点，为下次循环准备
            preNode = node;
            //指向下一次循环的起点
            node = node.next;
        }
        return mh;
    }

    /**
     * 用于组装链表
     *
     * @param arr
     * @return
     */
    public static ListNode linkPairs(int[] arr) {
        ListNode pre = null;
        ListNode head = null;

        for (int i : arr) {
            ListNode node = new ListNode(i);
            if (pre != null) {
                pre.next = node;
                pre = node;
            } else {
                pre = node;
                head = node;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 4. Median of Two Sorted Arrays
     * 两个有序数列计算中位数，偶数位则计算平均值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] num = new int[length1 + length2];
        int index1 = 0;
        int index2 = 0;
        boolean isEven = num.length % 2 == 0;

        for (int i = 0; i < length1 + length2; i++) {
            if ((index1 >= length1 ? Integer.MAX_VALUE : nums1[index1]) < (index2 >= length2 ? Integer.MAX_VALUE : nums2[index2])) {
                num[i] = nums1[index1++];
            } else {
                num[i] = nums2[index2++];
            }
            if (i == num.length / 2) {
                if (isEven) {
                    return (num[i] + num[i - 1]) / 2.0;
                } else {
                    return num[i];
                }
            }
        }
        return 0.0;
    }

    /**
     * 5. Longest Palindromic Substring
     * 找出最长的回文字符串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] result = new int[]{0, 0};
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                int[] r = palindromeIndex(chars, i, false);
                if (r[1] - r[0] > result[1] - result[0]) {
                    result = r;
                }
            }
            if (i + 1 < chars.length && chars[i - 1] == chars[i + 1]) {
                int[] r = palindromeIndex(chars, i, true);
                if (r[1] - r[0] > result[1] - result[0]) {
                    result = r;
                }
            }

        }
        return s.substring(result[0], result[1] + 1);
    }

    private static int[] palindromeIndex(char[] chars, int index, boolean isCenter) {
        int left = index - 1;
        int right = isCenter ? index + 1 : index;
        while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
            left--;
            right++;
        }
        return new int[]{left, right};
    }

    /**
     * 6. ZigZag Conversion
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 1 || s.length() < numRows) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < chars.length; i++) {
            int row = getRow(i, numRows);
            if (sbs[row] == null) {
                sbs[row] = new StringBuffer();
            }
            sbs[row].append(s.charAt(i));
        }
        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }

    private static int getRow(int index, int rows) {
        int cycLength = 2 * rows - 2;
        int r = index % cycLength;
        int result;
        if (r < rows) {
            result = r;
        } else {
            result = cycLength - r;
        }
        return result;
    }

    /**
     * 7. Reverse Integer
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long x2 = (long) x;
        long x1 = x2 < 0 ? -x2 : x2;
        long result = 0;
        while (x1 != 0) {
            result = result * 10 + x1 % 10;
            x1 = x1 / 10;
        }
        if (result >= Integer.MAX_VALUE) return 0;
        return (int) (x < 0 ? -result : result);
    }

    /**
     * 8. String to Integer (atoi)
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0 || (str.charAt(0) != '-' && str.charAt(0) != '+' && (str.charAt(0) < '0' || str.charAt(0) > '9'))) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(0) == '-' || str.charAt(0) == '+' || (str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
                    list.add(str.charAt(0));
                } else {
                    return 0;
                }
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                list.add(str.charAt(i));
            } else {
                break;
            }
        }

        Iterator<Character> iterator = list.iterator();
        if (list.get(0) == '-' || list.get(0) == '+') {
            iterator.next();
        }
        while (iterator.hasNext()) {
            Character c = iterator.next();
            if (c == '0')
                iterator.remove();
            else
                break;
        }
        if (list.size() == 0) return 0;

        if (list.size() == 1 && (list.get(0) < '0' || list.get(0) > '9')) {
            return 0;
        }
        int flag = (list.get(0) == '-') ? -1 : 1;

        StringBuffer stringBuffer = new StringBuffer();
        list.forEach(character -> {
            if (character >= '0' && character <= '9') {
                stringBuffer.append(character);
            }
        });
        String resultString = stringBuffer.toString();


        if (resultString.length() > (Integer.MAX_VALUE + "").length() || (resultString.length() == (Integer.MAX_VALUE + "").length() && resultString.compareTo(Integer.MAX_VALUE + "") > 0)) {
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return flag * Integer.valueOf(resultString);
    }

    /**
     * 9. Palindrome Number
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = x + "";
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 12. Integer to Roman
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        while (num > 0) {
            int maxCloseNumer = getMaxCloseNumber(num);
            stringBuffer.append(getRomanNumber(maxCloseNumer));
            num -= maxCloseNumer;
        }
        return stringBuffer.toString();
    }

    private static String getRomanNumber(int num) {
        switch (num) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }

    private static int getMaxCloseNumber(int num) {
        if (num >= 1000) {
            return 1000;
        } else if (num >= 900) {
            return 900;
        } else if (num >= 500) {
            return 500;
        } else if (num >= 400) {
            return 400;
        } else if (num >= 100) {
            return 100;
        } else if (num >= 90) {
            return 90;
        } else if (num >= 50) {
            return 50;
        } else if (num >= 40) {
            return 40;
        } else if (num >= 10) {
            return 10;
        } else if (num >= 9) {
            return 9;
        } else if (num >= 5) {
            return 5;
        } else if (num >= 4) {
            return 4;
        } else if (num >= 1) {
            return 1;
        }
        return 0;
    }

    /**
     * 13. Roman to Integer
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IX", 9);
        map.put("IV", 4);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int result = 0;
        while (s.length() > 0) {

            if (s.charAt(0) == 'I' || s.charAt(0) == 'X' || s.charAt(0) == 'C') {
                if (s.length() >= 2 && map.get(s.substring(0, 2)) != null) {
                    result += map.get(s.substring(0, 2));
                    s = s.substring(2);
                } else {
                    Integer integer = map.get(s.substring(0, 1));
                    result += integer;
                    s = s.substring(1);
                }

            } else {
                Integer integer = map.get(s.substring(0, 1));
                result += integer;
                s = s.substring(1);
            }
        }
        return result;
    }

    /**
     * 14. Longest Common Prefix
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = 0;
            for (int k = 0; k < strs.length; k++) {
                if (k == 0) {
                    c = strs[0].charAt(i);
                } else if (strs[k].length() <= i || strs[k].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 19. Remove Nth Node From End of List
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }

        if (n == 0) {
            return null;
        } else if (n == listNodes.size()) {
            return listNodes.size() == 1 ? null : listNodes.get(1);
        } else {
            listNodes.get(listNodes.size() - n - 1).next = listNodes.size() > (listNodes.size() - n + 1) ? listNodes.get(listNodes.size() - n + 1) : null;
        }

        return listNodes.get(0);
    }

    /**
     * 17. Letter Combinations of a Phone Number
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        char[][] chars = new char[8][4];
        chars[0] = new char[]{'a', 'b', 'c'};
        chars[1] = new char[]{'d', 'e', 'f'};
        chars[2] = new char[]{'g', 'h', 'i'};
        chars[3] = new char[]{'j', 'k', 'l'};
        chars[4] = new char[]{'m', 'n', 'o'};
        chars[5] = new char[]{'p', 'q', 'r', 's'};
        chars[6] = new char[]{'t', 'u', 'v'};
        chars[7] = new char[]{'w', 'x', 'y', 'z'};

        Map<Character, char[]> map = new HashMap<>();
        map.put('2', chars[0]);
        map.put('3', chars[1]);
        map.put('4', chars[2]);
        map.put('5', chars[3]);
        map.put('6', chars[4]);
        map.put('7', chars[5]);
        map.put('8', chars[6]);
        map.put('9', chars[7]);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            addList(map.get(digits.charAt(i)), list);
        }
        return list;
    }

    private static void addList(char[] chars, List<String> list) {

        if (list.size() == 0) {
            for (int i = 0; i < chars.length; i++) {
                list.add(chars[i] + "");
            }
        } else {
            int size = list.size();
            for (int i = 0; i < chars.length; i++) {
                for (int k = 0; k < size; k++) {
                    if (i == chars.length - 1) {
                        list.set(k, list.get(k) + chars[i]);
                    } else {
                        list.add(list.get(k) + chars[i]);
                    }
                }
            }
        }

    }
}