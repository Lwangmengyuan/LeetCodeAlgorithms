package com.data.structure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
    private Object[] array;
    private int maxSize;
    private int top;

    //默认构造一个容量为10的栈
    public MyStack(){
        this.array = new Object[10];
        this.maxSize = 10;
        this.top = -1;
    }

    //带参构造栈
    public MyStack(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("栈的初始长度不能小于0");
        }
        this.maxSize = initialCapacity;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    //判断是否需要扩容，如果需要，则扩大一倍并返回true，否则返回false
    public boolean isGrow(int minCapacity){
        int oldCapacity = maxSize;
        //当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
        if(minCapacity >= oldCapacity){
            int newCapacity = 0;
            //栈容量扩大两倍（左移一位），是否大于int类型所表示的最大范围
            if((oldCapacity << 1) - Integer.MAX_VALUE > 0){
                newCapacity = Integer.MAX_VALUE;
            }else {
                newCapacity = (oldCapacity << 1);
            }
            this.maxSize = newCapacity;
            array = Arrays.copyOf(array,maxSize);
            return true;
        }else {
            return false;
        }
    }

    //压入数据
    public Object push(Object value){
        isGrow(top+1);
        array[++top] = value;
        return value;
    }

    //弹出栈顶数据
    public Object pop(){
        return array[top--];
    }

    //访问栈顶元素
    public Object peek(){
        if(top == -1){
            throw new EmptyStackException();
        }
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull(){
        return (top == maxSize-1);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push("abc");
        System.out.println(myStack.peek());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.peek());
    }
}