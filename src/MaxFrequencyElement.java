/**
 * Created by 46184 on 2017/11/11.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */
public class MaxFrequencyElement {
    public static int maxFrequencyElement(int[] array) {
        int result=array[0],time=0;
        for (int i = 0; i < array.length - 1; i++) {
            if (time==0) {
                //次数等于0则修改结果元素
                result=array[i];
                time++;
            }else {
                if(result==array[i+1]){
                    time++;
                }else {
                    time--;
                }
            }

        }
        return result;
    }
}
