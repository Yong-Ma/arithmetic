package bishi;

import java.util.Stack;

public class twoStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public twoStack(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    public void pushToStack2(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
    }
    //入队
    public void add(int num){
        stack1.push(num);
        pushToStack2();
    }
    //出队
    public int poll(){
        pushToStack2();
        if(size()!=0&&!stack2.isEmpty())
            return stack2.pop();
        else
            throw new RuntimeException("无元素可出队！");
    }
    //求队列长度
    public int size(){
        return stack1.size()+stack2.size();
    }
}
