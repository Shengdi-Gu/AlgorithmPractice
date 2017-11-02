
public class Main {

    public static void main(String[] args) {
        //埃氏筛法,求0-n之间的质数
        //SieveOfEratosthenes.getPrimeNumber(1000);

        //阿拉伯数字转中文数字
        //System.out.println(NumberAndChineseUtils.NumberToChinese(1223456));
        //中文转阿拉伯数字
        //System.out.println(NumberAndChineseUtils.chineseToNumber("一百二十二万三千四百五十六"));
//        int[] array = {100, 4, 200, 1, 3, 2, 5};
//        System.out.println(LongestConsecutive.longestConsecutive(array));
//        int[] array={1,2,2,3,1,4,2};
//        System.out.println(FindShortestSubArray.findShortestSubArray(array));
        int[] array={1,2,3};
        int k=6;
        System.out.println(SubarraySum.subarraySum(array,k));

    }
}
