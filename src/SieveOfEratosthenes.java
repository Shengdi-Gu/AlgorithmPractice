import java.util.Arrays;

/**
 * Created by gsd on 17-6-26.
 * 算法原理：要得到自然数n以内的全部素数，必须把不大于  的所有素数的倍数剔除，剩下的就是素数。
 * 百度百科：http://baike.baidu.com/link?url=ce6vCbLEKGJOqUeThGiDJgizMK5gYrpm-v50_lQ9GEV1Kuk7Kbyb1BR4INuZYns1suVml40scz9n63MkTC7qY4onKZP-WTKr5EB_DDP60VIO3B2BONTwQeatEtKHYtfUFADa-15GdOqqY-pDTsCczTJkMpAsfXiebzI8AJ4WBvG
 */
public class SieveOfEratosthenes {
    private static boolean[] array;

    public static void getPrimeNumber(int n) {
        long time1 = System.currentTimeMillis();
        array = new boolean[n + 1];
        Arrays.fill(array, true);
        array[0] = array[1] = false;
        int count = sieve(n);
        long time2 = System.currentTimeMillis();
        System.out.println("用时：" + (time2 - time1) + "ms");
        System.out.println("质数个数：" + count);
        for (int i = 0; i < n; i++) {
            if (array[i] == true) {
                System.out.print(i + ",");
            }
        }

    }

    private static int sieve(int n) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            if (array[i]) {
                p++;
                for (int j = 2 * i; j <= n; j += i) {
                    array[j] = false;
                }
            }
        }
        return p;
    }
}
