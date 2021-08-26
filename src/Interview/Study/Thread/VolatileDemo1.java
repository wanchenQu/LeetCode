package Interview.Study.Thread;

import java.util.concurrent.TimeUnit;

/**
 * 验证volatile的可见性, 能够及时通知其他线程主内存中变量有修改。添加volatile可以保证原子性
 */
public class VolatileDemo1 {
    public static void main(String[] args) {
        //main是一切方法的运行入口
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in value: " + myData.number);
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        // main线程
        while (myData.number == 0) {
            // main线程一直等待循环，直到number值不为0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission over! value: " + myData.number);
    }
}
