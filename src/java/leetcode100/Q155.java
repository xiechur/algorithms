package leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Q155 {

    class MinStack {
        // 存放数据
        Stack<Integer> data;
        // 存放最小的的值的栈
        Stack<Integer> min;
        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack();
            min = new Stack();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }
        }

        public void pop() {
            if (!data.empty()) {
                int top = data.pop();
                if (top == min.peek()) {
                    min.pop();
                }
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }
            throw new RuntimeException("栈空");
        }

        public int getMin() {
            if (!min.isEmpty()) {
                return min.peek();
            }
            throw new RuntimeException("栈空");
        }
    }

}
