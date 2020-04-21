import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName TestClassLayout
 * @Description 查看类布局 需要引入jol包
 * @Author hou
 * @Date 2020/4/21 9:39 上午
 * @Version 1.0
 **/
public class TestClassLayout {

    /**
     *  普通object 无成员的类布局
     *  java.lang.Object object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           09 00 00 00 (00001001 00000000 00000000 00000000) (9)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
     *      12     4        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
    @Test
    public void testClassLayOut1(){
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }


    /**
     * 调用hashcode后的类布局
     * java.lang.Object object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           09 23 f7 27 (00001001 00100011 11110111 00100111) (670507785)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
     *      12     4        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
    @Test
    public void testClassLayout2(){
        Object o = new Object();
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

    class Inner{
        private int i;

        public Inner(int i) {
            this.i = i;
        }
    }

    /**
     * 含有成员变量的类布局
     * TestClassLayout$Inner object internals:
     *  OFFSET  SIZE              TYPE DESCRIPTION                               VALUE
     *       0     4                   (object header)                           09 00 00 00 (00001001 00000000 00000000 00000000) (9)
     *       4     4                   (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4                   (object header)                           c6 5d 02 f8 (11000110 01011101 00000010 11111000) (-134062650)
     *      12     4               int Inner.i                                   1
     *      16     4   TestClassLayout Inner.this$0                              (object)
     *      20     4                   (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
    @Test
    public void testClassLayout3(){
        Inner inner = new Inner(1);
        System.out.println(ClassLayout.parseInstance(inner).toPrintable());
    }

    /**
     * 锁对象之后的类布局
     * java.lang.Object object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           30 41 d3 00 (00110000 01000001 11010011 00000000) (13844784)
     *       4     4        (object header)                           00 70 00 00 (00000000 01110000 00000000 00000000) (28672)
     *       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
     *      12     4        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
    @Test
    public void testClassLayout4(){
        Object o = new Object();
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }


}