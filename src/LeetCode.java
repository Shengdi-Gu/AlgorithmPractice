import java.util.Arrays;

/**
 * Created by 46184 on 2017/11/23.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class LeetCode {
    /**
     * 数组 283
     * 给定一个数组nums，写一个函数，将数组内的0移动到数组末尾，并保持其他非零元素在原数组中的相对位置不变。
     *比如，给定nums = [0, 1, 0, 3, 12]，调用你的函数之后，nums应该变成[1, 3, 12, 0, 0]。
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
}
