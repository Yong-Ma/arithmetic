package leetcode;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
class CQueue {
    private Stack<Integer> stackPre=new Stack<>();
    private Stack<Integer> stackAft=new Stack<>();
    public CQueue() {
        stackPre=new Stack<>();
        stackAft=new Stack<>();
    }

    public void appendTail(int value) {
        stackPre.push(value);
    }

    public int deleteHead() {
        if(stackAft.isEmpty()) {
            while(!stackPre.isEmpty())
                stackAft.push(stackPre.pop());
        }
        if(!stackAft.isEmpty())
            return stackAft.pop();
        else
            return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
