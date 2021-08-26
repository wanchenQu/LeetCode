package July;

import java.util.*;

/**
 * 点菜展示表
 */
public class xie6_1418 {
    /**
     * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
     * 其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
     * <p>
     * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
     * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
     * <p>
     * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
     */
    public static void main(String[] args) {

        /**
         * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
         * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
         * 解释：
         * 点菜展示表如下所示：
         * Table,Beef Burrito,Ceviche,Fried Chicken,Water
         * 3    ,0           ,2      ,1            ,0
         * 5    ,0           ,1      ,0            ,1
         * 10   ,1           ,0      ,0            ,0
         *
         * */
        List<List<String>> orders = new ArrayList<>();
        orders.add(new ArrayList<>(Arrays.asList(new String[]{"David", "3", "Ceviche"})));
        orders.add(new ArrayList<>(Arrays.asList(new String[]{"Corina", "10", "Beef Burrito"})));
        orders.add(new ArrayList<>(Arrays.asList(new String[]{"David", "3", "Fried Chicken"})));
        orders.add(new ArrayList<>(Arrays.asList(new String[]{"Carla", "5", "Water"})));
        orders.add(new ArrayList<>(Arrays.asList(new String[]{"Carla", "5", "Ceviche"})));
        orders.add(new ArrayList<>(Arrays.asList(new String[]{"Rous", "3", "Ceviche"})));
        List<List<String>> res = displayTable(orders);
        System.out.println(res);
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        // 菜品title
        Set<String> dishes = new HashSet<>();
        // 桌号 -> (菜品 -> 个数)
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (List<String> o : orders) {
            String p = o.get(0), table = o.get(1), dish = o.get(2);
            int tI = Integer.parseInt(table);
            dishes.add(dish);
            Map<String, Integer> temp = map.getOrDefault(tI, new HashMap<>());
            temp.put(dish, temp.getOrDefault(dish, 0) + 1);
            map.put(tI, temp);
        }

        // dishes<Set> => title<List>
        List<String> title1 = new ArrayList<>(dishes);
        Collections.sort(title1);
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(title1);
        ans.add(title);

        List<Integer> tables = new ArrayList<>(map.keySet());
        Collections.sort(tables);
        for (int i : tables) {
            Map<String, Integer> a = map.get(i);
            List<String> b = new ArrayList<>();
            b.add(i + "");
            for (String f : title1) {
                b.add(a.getOrDefault(f, 0) + "");
            }
            ans.add(b);
        }
        return ans;
    }
}
