package June;

/**
 * Excel表列名称
 */
public class xie29_168 {
    public static void main(String[] args) {
        int col = 701;
        System.out.println(convertToTitle(col));
    }

    public static String convertToTitle(int col) {
        StringBuffer sb = new StringBuffer();
        while (col > 0) {
            col--;
            sb.append((char) (col % 26 + 'A'));
            col = col / 26;
        }
        return sb.reverse().toString();
    }
}
