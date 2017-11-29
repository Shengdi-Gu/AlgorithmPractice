import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
        int left = 0, right = height.length - 1;
        int mostWater = 0;
        while (left < right) {
            int water = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
            if (water > mostWater) {
                mostWater = water;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return mostWater;
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
                    start=i;
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
                        while (start + 1 < sChars.length && (!tSet.contains(sChars[++start]) || !(map.get(sChars[start]) != null && map.get(sChars[start]) == start)))
                            ;
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
}
