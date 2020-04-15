import base.HashMap8;
import entity.FakeHash;
import org.junit.Test;

import java.util.*;

public class TestHashMap8 {

    /**
     * 测试代码是否可以正常编译
     */
    @Test
    public void test1() {
        System.out.println("Hello World");
    }

    /**
     * 测试当初始化HashMap时，初始容量不设置为2的整数次幂会发生什么?
     */
    @Test
    public void test2() {
        int[] ints = {0};
        for (int anInt : ints) {
            System.out.println("current initialCapacity is " + anInt);
            new HashMap8<>(anInt);
            System.out.println();
        }
    }

    /**
     * 测试ConcurrentModificationException
     */
    @Test
    public void test3() {
        HashMap8<Integer, Integer> hashMap8 = new HashMap8<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
        }};

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap8.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            hashMap8.remove(2);
        }
    }

    /**
     * 测试返回值覆盖
     */
    @Test
    public void test4() {
        HashMap8<Integer, Integer> hashMap8 = new HashMap8<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
        }};

        System.out.println(hashMap8.put(1, 3));
        System.out.println(hashMap8.put(3, 3));
    }

    /**
     * 测试HashMap1.8新特性
     */
    @Test
    public void test5() {
        Map<Integer, String> map = new HashMap8<>();
        map.put(1, "jack");
        map.put(2, "tom");
        map.put(3, "wawa");

        String value = map.getOrDefault(4, "null");
        System.out.println(value);  // null
        //如果不用默认方法，自己就要写if...else判断了
//        String s = map.get(5);
//        if (s == null) {
//
//        } else {
//
//        }

        //put方法：如果key存在时，就替换值为新的值
        String v1 = map.put(3, "haha");
        System.out.println(v1);

        //putIfAbsent方法:如果key存在就不替换值，如果key不存在就新存入
        String v = map.putIfAbsent(3, "wangwang");
        System.out.println(v);
        map.forEach((key, va) -> System.out.println(key + "->" + va));
//        1->jack
//        2->tom
//        3->haha

        //remove方法:根据key和value都匹配时，才会真正删除
        map.remove(1, "vince");
        System.out.println(map.remove(1, "vince")); // false

        //replace(key,V,V)
        map.replace(1, "vince");        //直接替换成vince
        map.replace(1, "vince", "lala");//将vince替换成lala

        //compute方法：计算指定键的映射及其当前映射的值（如果没有当前映射， null ）
        map.compute(1, (k, va) -> va + "2"); //这里compute传入的是BiFunction方法，该BiFunction方法需要传入两个参数，所以lambda表达式需要两个参数
        map.forEach((key, val) -> System.out.println(key + "->" + val));
        /**
         1->lala2
         2->tom
         3->haha
         */

        //computeIfAbsent方法：如果key=4的值为空，才进行后面的计算
        map.computeIfAbsent(4, (k) -> k + "3"); //这里computeIfAbsent传入的是Function方法，该Function方法需要传入一个参数，所以lambda表达式需要一个参数
        //这里：k+"3"  就是  apply(T t)的方法的具体实现，因为接口里没有实现apply方法，所以这里是自定义要实现apply的方法
        map.forEach((key, val) -> System.out.println(key + "->" + val));
        /**
         1->lala2
         2->tom
         3->haha
         4->43
         */

        //computeIfPresent方法：如果key=4的值不为空，才进行后面的计算
        map.computeIfPresent(4, (k, v3) -> v3 + "pp");
        map.forEach((key, val) -> System.out.println(key + "->" + val));
        /**
         1->lala2
         2->tom
         3->haha
         4->43pp
         */

        //merge方法：合并
        map.merge(1, "1", String::concat);
        map.merge(8, "888", String::concat);
        map.forEach((key, val) -> System.out.println(key + "->" + val));
//        1->lala21
//        2->tom
//        3->haha
//        4->43pp
//        8->888
    }

    public <K, V> void printRedBlackTree(HashMap8.TreeNode<K, V> treeNode){
        System.out.println("---------------RedBlackTree----------------------------");
        printNode(treeNode, 0);
        System.out.println("---------------RedBlackTree----------------------------");
    }

    private <K,V> void printNode(HashMap8.TreeNode<K,V> root, int level) {
        if (root == null) {
            System.out.print(String.join("", Collections.nCopies( level, "\t")));
            System.out.println("NIL");
        } else {
            printNode(root.getRight(), level + 1);
            System.out.print(String.join("", Collections.nCopies( level, "\t")));
            if (root.isRed()) {
                System.out.printf("%d\n", root.getKey().hashCode());

            } else
                System.out.printf("(%d)\n", root.getKey().hashCode());
            printNode(root.getLeft(), level + 1);
        }
    }

    public void printNode(HashMap8.Node node){
        System.out.print(node.getValue());
        if (node.getNext() != null) {
            System.out.print("->");
            printNode(node.getNext());
        }
    }

    public <K, V> void printMap(HashMap8<K, V> map){
        System.out.println("---------------Map----------------------------");
        for (int i = 0; i < map.table.length; i++) {
            HashMap8.Node<K, V> node = map.table[i];
            if(node != null) {
                System.out.print("当前元素下标为：" + i + " ,值为：" + node.getValue());
                if (node instanceof HashMap8.TreeNode) {
                    System.out.println(" ,数据类型为红黑树");
                    printRedBlackTree((HashMap8.TreeNode<K, V>) node);
                } else {
                    System.out.println(" ,数据类型为单链表");
                    printNode(node);
                    System.out.println();
                }
            }
        }
        System.out.println("---------------Map----------------------------");
        System.out.println();
    }


    @Test
    public void test6(){
        HashMap8<FakeHash, Integer> map = new HashMap8<>();
        List<FakeHash> list = new ArrayList<>();
        FakeHash fakeHash;
        for (int i = 0; i < 65; i++) {
            fakeHash = new FakeHash(i);
            list.add(fakeHash);
            map.put(fakeHash, i);
            printMap(map);
        }

        // 将list打乱顺序 模拟随机删除
        Collections.shuffle(list);
        for (FakeHash hash : list) {
            System.out.println(String.format("移除【%d】hashCode=【%d】", hash.getValue(), hash.hashCode()));
            map.remove(hash);
            printMap(map);
        }
    }
}
