package July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于时间的键值存储
 */
public class xie10_981 {
    Map<String, List<Node>> map = new HashMap<>();

    public void set(String k, String v, int t) {
        List<Node> list = map.getOrDefault(k, new ArrayList<>());
        list.add(new Node(k, v, t));
        map.put(k, list);
    }

    public String get(String k, int t) {
        List<Node> list = map.getOrDefault(k, new ArrayList<>());
        if (list.isEmpty()) return "";
        int n = list.size();
        // 找到第一个小于等于时间戳的v
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = (l + r + 1) >>> 1;
            if (list.get(m).t > t) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return list.get(r).t <= t ? list.get(r).v : "";
    }

    class Node {
        String k, v;
        int t;

        Node(String _k, String _v, int _t) {
            k = _k;
            v = _v;
            t = _t;
        }
    }

}
