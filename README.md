# AlgorithmPractice
## 练习一些算法
### 2017-6-26 埃氏筛法（SieveOfEratosthenes）
#### 算法原理
要得到自然数n以内的全部素数，必须把不大于  的所有素数的倍数剔除，剩下的就是素数。
##### 步骤
> 列出2以后的所有序列：<br>
    2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25<br>
> 标出序列中的第一个素数，也就是2，序列变成：<br>
    2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25<br>
> 将剩下序列中，划掉2的倍数，序列变成：<br>
    2 3 5 7 9 11 13 15 17 19 21 23 25<br>
> 如果现在这个序列中最大数小于最后一个标出的素数的平方，那么剩下的序列中所有的数都是素数，否则回到第二步。<br>
> 本例中，因为25大于2的平方，我们返回第二步：<br>
> 剩下的序列中第一个素数是3，将主序列中3的倍数划掉，主序列变成：<br>
    2 3 5 7 11 13 17 19 23 25<br>
> 我们得到的素数有：2，3<br>
    25仍然大于3的平方，所以我们还要返回第二步：<br>
> 现在序列中第一个素数是5，同样将序列中5的倍数划掉，主序列成了：<br>
    2 3 5 7 11 13 17 19 23<br>
    我们得到的素数有：2，3，5 。因为23小于5的平方，跳出循环。<br>
> 结论：2到25之间的素数是：2 3 5 7 11 13 17 19 23。<br>
### 2017-6-28 阿拉伯数字和中文数字的相互转换(Java实现)（NumberAndChineseUtils）
* 算法参考自《算法的乐趣》(王晓华)第四章
### 2017-10-30 寻找最长连续数组（LongestConsecutive）
* 来自LeetCode<br>
 题目的意思是从给定的无序int型数组中找出最长的连续数列
 比如[100, 4, 200, 1, 3, 2, 5]<br>
 其中最长连续数列为[1,2,3,4,5]<br>
 结果返回5<br>
 要求时间复杂度为O(n)<br>
 思路：寻找最大连续数列其实重点不在于排序，而在每个项的前后关系。<br>
      在java中将每一项插入set当中时去判断它的前后关系，从而找出最长连续数列。
### 2017-11-01 寻找最短相同度的子序列长度（FindShortestSubArray）
* 来自LeetCode<br>
 给定一非空的非负整型数组，定义其度为其任一元素出现的最大频率。<br>
 比如[1,2,3,1,4],其度为2，因为其中出现频率最高的元素为“1”，出现2次，度为2。<br>
 现在欲寻找与其度相同的最短的连续子序列，输出其子列长度。<br>
 >如[1,2,1,3,4,2],其度为2，与其度相同的连续子序列有：<br>
 >>[1,2,1],[2,1,3,4,2]
 >>则输出结果为:3
* 解题思路：其度由其最高频率元素决定，而最短相同度子序列的长度则又其最高频率元素
的最左侧出现下标和最右侧出现下标决定，所以只要找出其两侧下标，即可解决此问题。
在java中可以使用HashMap来找出其频率最大元素。
 ### 2017-11-02 寻找和等于给定K值的连续子列数量（SubarraySum）
 * 给定一个int型数组，和一个K值，要求找出和等于K的连续子序列数量。<br>
如[1,1,1],k=2<br>
返回值为2<br>
* 思路：计算出从开始元素到每个遍历元素位置之前的和，存入HashSet里面，同时计算当前位置遍历和，和K值求差，看是否有满足条件的前子序列和。<br>
 ### 2017-11-05 寻找最长字符不重复子串长度（LengthOfLongestSubstring）
 * 给定一个字符串，寻找其中最长不含重复字符的子串长度。<br>
 例:输入："pwwkew" ，最长非重复子串为："wke"，输出：3
 * 思路： 使用HashMap定义一个可移动伸缩窗口，从头开始逐个添加字符，发现重复元素则删除窗口内重复元素在内的之前元素，从重复元素位置继续添加并统计Map长度。
 
 ### 2017-11-11 寻找出现频率超过50%的数字（MaxFrequencyElement）
 * 给定一个int型正数数组，已知该数组中某元素出现的次数超过(不能等于)数组长度的1/2，找出该元素。<br>
 例：输入：[2,3,1,4,2,2,2] 输出：2
 * 思路，在java中使用HashMap可以非常简单的实现目的，现不使用HashMap实现，这里使用另一种方式：因为目标元素出现的频率超过50%，所以用一个变量记录任意元素为结果，另一个变量记录该记录元素出现的次数，比较下一个元素是否等于记录元素，相等则次数加一，不相等则减一，当记录元素次数等于0时，则记录下一个元素为结果元素，遍历完数组，则得到目标元素。
 ### 2017-11-27 添加LeetCode类，用于记录LeetCode刷题代码（LeetCode）
 * 数组 moveZeroes 283<br>
 给定一个数组nums，写一个函数，将数组内的0移动到数组末尾，并保持其他非零元素在原数组中的相对位置不变。
 比如，给定nums = [0, 1, 0, 3, 12]，调用你的函数之后，nums应该变成[1, 3, 12, 0, 0]。
 * 数组 removeElement 27<br>
 给定一个数组和一个值，原地移除数组中所有给定的值，并返回新数组的长度。
 不允许申请额外空间，确保空间复杂度为O(1)。
 数组中的元素可以被改变，不用考虑超出新长度之后的空间遗留。
 * 数组 removeDuplicates 26<br>
 给定一个有序数组，原地删除重复元素使得数组中的元素只保留一个，并且返回新长度。
 禁止申请额外空间，确保空间复杂度为O(1)。
 * 数组 removeDuplicates2 80<br>
 与数组26题条件相同，但是变更一个要求：可以允许元素最多重复2次。
 比如，给定nums = [1, 1, 1, 2, 2, 3]，
 返回length = 5， nums = [1, 1, 2, 2, 3]。同样不用考虑超出新长度之后的空间遗留。
 * 数组 twoSum 167<br>
 给定一个整形数组，并且数组内元素已经按升序排列，找出两个元素，使得它们之和与给定的数相等。
 函数应该返回找到的这两个元素的索引，并且第一个元素的索引小于等于第二个元素的索引，并且元素索引起始位置是基于1而不是基于0。
 你可以假设给定的目标数在数组中必定找得到对应的两个元素。
 * 数组 maxArea 11
 给出一个非负整数 a1, a2, ..., an,它们分别代表x轴上的一个点(i, ai)，在每个点上画高度为ai的“墙”，
 用来代表容器。选择两堵墙，使得它们和x轴围起来的容器装水容量最大。
 * 数组 sortColors 75
 给定一个数组，其中有n个元素，分别为红色、白色和蓝色，请将数组中的元素进行排序，使得颜色相同的元素排在一起，并且颜色顺序为红、白、蓝。
 我们使用整数0、1、2分别代表红、白、蓝3种颜色。