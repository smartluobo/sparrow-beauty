package com.chaomeis.sparrowbeauty.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtil {
    public static String formatStr1 = "#,##0.00";
    /**
     * 涉及小数位的保留小数位
     */
    public static final int DECIMAL_DOTLENG2 = 2;

    /**
     * 保留len位小数（四舍五入）
     * @param bigDecimal
     * @param len
     * @return
     */
    public static BigDecimal scale(BigDecimal bigDecimal, int len) {
        if (bigDecimal != null) {
            return bigDecimal.setScale(len, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

    /**
     * 提供精确的除法运算方法div，四舍五入
     * @param value1 被除数
     * @param value2 除数
     * @return 两个参数的商
     */
    public static BigDecimal div(BigDecimal value1,BigDecimal value2) {
        return value1.divide(value2, DECIMAL_DOTLENG2 ,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 将数字转换为#,####,####,#### 格式的数字
     * @param amt
     * @return
     */
    public static String formatAmtMegabytes(BigDecimal amt, String formatStr) {
        DecimalFormat df1 = new DecimalFormat(formatStr);
        return df1.format(amt);
    }

    public static void main(String[] args) {
        BigDecimal aa = new BigDecimal("80");
        BigDecimal ratio = new BigDecimal("0.88");
        aa = aa.multiply(ratio);
        System.out.println(aa);
    }
}
