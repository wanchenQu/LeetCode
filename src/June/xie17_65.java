package June;

import java.util.Arrays;

/**
 * 有效数字
 */
public class xie17_65 {
    public static void main(String[] args) {
        String[] trueList = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] falseList = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        boolean[] t = new boolean[trueList.length];
        boolean[] f = new boolean[falseList.length];
        for (int i = 0; i < trueList.length; i++) {
            t[i] = solution(trueList[i]);
        }
        for (int i = 0; i < falseList.length; i++) {
            f[i] = solution(falseList[i]);
        }
        System.out.println(Arrays.toString(t));
        System.out.println(Arrays.toString(f));

    }

    public static boolean solution(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        // 合法数字可以有e/E,如果有该字符标记该字符位置
        int eIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'e' || chars[i] == 'E') {
                if (eIndex == -1) {
                    eIndex = i;
                } else {
                    // 合法字符种只能有一个e/E
                    return false;
                }
            }
        }
        boolean result = true;
        if (eIndex != -1) {
            result &= isNum(chars, 0, eIndex - 1, false);
            result &= isNum(chars, eIndex + 1, len - 1, true);
        } else {
            result &= isNum(chars, 0, len - 1, false);
        }
        return result;
    }

    private static boolean isNum(char[] chars, int l, int r, boolean mustInteger) {
        if (l > r) {
            return false;
        }
        // 整数的第一个字符可以是+/-
        if (chars[l] == '+' || chars[l] == '-') {
            l++;
        }
        // 需要判断该数是否为小数，是否是整数
        boolean hasDot = false;
        boolean hasNum = false;
        for (int i = l; i <= r; i++) {
            if (chars[i] == '.') {
                if (mustInteger || hasDot) {
                    // 如果必须是整数，并且有小数点，返回false
                    return false;
                }
                // 如果是小数，小数点只能有一个，超过一个小数点返回false
                hasDot = true;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                hasNum = true;
            } else {
                // 非数字字符返回false
                return false;
            }
        }
        // 数字类型必须有数字
        return hasNum;
    }
}
