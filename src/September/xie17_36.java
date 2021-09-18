package September;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 */

public class xie17_36 {
    public static void main(String[] args) {
        /**
         * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
         * 数字1-9在每一行只能出现一次。
         * 数字1-9在每一列只能出现一次。
         * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
         * 数独部分空格内已填入了数字，空白格用'.'表示。
         * 只校验是否合法，不校验是否有解
         * */
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku1(board));

    }

    public static boolean isValidSudoku1(char[][] board) {
        int[] cell = new int[9], row = new int[9], col = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                int x = cur - '0';
                int c = (i / 3) * 3 + (j / 3);
                if ((cell[c] >> x & 1) == 1 || (row[i] >> x & 1) == 1 || (col[j] >> x & 1) == 1) return false;
                cell[c] |= 1 << x;
                row[i] |= 1 << x;
                col[j] |= 1 << x;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cell = new HashMap<>(), row = new HashMap<>(), col = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            cell.put(i, new HashSet<>());
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                int c = (i / 3) * 3 + (j / 3);
                if (cell.get(c).contains(cur) || row.get(i).contains(cur) || col.get(j).contains(cur)) {
                    return false;
                }
                cell.get(c).add(cur);
                row.get(i).add(cur);
                col.get(j).add(cur);
            }
        }
        return true;
    }
}
