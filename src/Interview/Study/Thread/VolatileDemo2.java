package Interview.Study.Thread;

public class VolatileDemo2 {

    /**
     * 验证volatile不保证原子性
     * 原子性：不可分割，完整性，即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整
     * 要么同时成功，要么同时失败
     */
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 10000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, "Thread: " + String.valueOf(i)).start();
        }

        // 需要等待以上线程全部完成后，再用main线程取得最终结果值
        while (Thread.activeCount() > 2) {// 默认线程: main GC
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int type finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type finally number value: " + myData.atomicInteger);

    }
}
