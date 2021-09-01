package August;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */

public class xie27_295 {
    /**
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {
        private PriorityQueue<Integer> qB;
        private PriorityQueue<Integer> qS;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            qB = new PriorityQueue<Integer>((a, b) -> a - b);
            qS = new PriorityQueue<Integer>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (qS.isEmpty() || num < qS.peek()) qS.add(num);
            else qB.add(num);
            if (qB.size() - qS.size() > 1) qS.add(qB.poll());
            if (qS.size() - qB.size() > 1) qB.add(qS.poll());
        }

        public double findMedian() {
            if (qB.size() == qS.size()) return (qB.peek() + qS.peek()) * 0.5;
            else return qB.size() > qS.size() ? qB.peek() : qS.peek();
        }
    }


}
