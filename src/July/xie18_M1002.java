package July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 变位词组
 */
public class xie18_M1002 {
    /**
     * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串
     */
    public static void main(String[] args) {
        String[] ss = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(ss));
    }

    public static List<List<String>> groupAnagrams(String[] ss) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : ss) {
            int[] afb = new int[26];
            for (char c : s.toCharArray()) afb[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i : afb) sb.append(i);
            String k = sb.toString();
            List<String> temp = map.getOrDefault(k, new ArrayList<>());
            temp.add(s);
            map.put(k, temp);
        }
        for (String k : map.keySet()) ans.add(map.get(k));
        return ans;
    }
}
