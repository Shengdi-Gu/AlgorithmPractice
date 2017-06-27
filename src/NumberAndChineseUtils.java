import java.util.Calendar;

/**
 * Created by gsd on 17-6-26.
 * 阿拉伯数字和中文数字相互转换的算法设计
 */
public class NumberAndChineseUtils {
    private static final String[] CHINESE_NUM_CHAR = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CHINESE_UNIT_SESTION = {"", "万", "亿", "万亿"};
    private static final String[] CHINESE_UNIT_CHAR = {"", "十", "百", "千"};


    public static String NumberToChinese(int number) {

        //记录节权位
        int unitPos = 0;
        StringBuffer chnString = new StringBuffer("");

        boolean needZero = false;
        //分节处理
        while (number > 0) {
            StringBuffer strIns = new StringBuffer("");
            int section = number % 10000;
            if (needZero) {
                chnString.insert(0, CHINESE_NUM_CHAR[0]);
            }
            sectionToChinese(section, strIns);
            strIns.append(((section != 0) ? CHINESE_UNIT_SESTION[unitPos] : CHINESE_UNIT_SESTION[0]));
            chnString.insert(0, strIns);
            needZero = (section < 1000) && (section > 0);
            number = number / 10000;
            unitPos++;
        }
        return chnString.toString();
    }

    /*
    * 分位处理
    * */
    private static void sectionToChinese(int section, StringBuffer chnString) {
        String strIns;
        int unitPos = 0;
        boolean zero = true;
        while (section > 0) {
            int v = section % 10;
            if (v == 0) {
                if (section == 0 || !zero) {
                    zero = true;//zero作用是确保连续多个零时只补一个中文”零“
                    chnString.insert(0, CHINESE_NUM_CHAR[v]);
                }
            } else {
                zero = false;
                strIns = CHINESE_NUM_CHAR[v];
                strIns += CHINESE_UNIT_CHAR[unitPos];
                chnString.insert(0, strIns);
            }
            unitPos++;
            section = section / 10;
        }
    }

    public static int chineseToNumber(String chnNumber) {

        return 0;
    }
    private static final ChnValuePair[] CHN_VALUE_PAIRS={};

    private static class ChnValuePair {
        final String name;
        final int value;
        final boolean secUnit;

        public ChnValuePair(String name, int value, boolean secUnit) {
            this.name = name;
            this.value = value;
            this.secUnit = secUnit;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public boolean isSecUnit() {
            return secUnit;
        }
    }
}
