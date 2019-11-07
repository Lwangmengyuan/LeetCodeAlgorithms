package com.data.structure;

public class MyQueue {
    private Object[] array;
    private int maxSize;
    private int front;
    private int rear;
    //队列中实际元素个数
    private int nItems;

    public MyQueue(int size){
        this.maxSize = size;
        array = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //队列中新增数据
    public void insert(Object value){
        if(isFull()){
            System.out.println("队列已满，插入失败！！！");
        }else{
            //如果队列尾部指向顶了，那么循环回来执行队列第一个元素
            if(rear == maxSize-1){
                rear = -1;
            }
            //队尾指针加1，然后在队尾处插入新数据
            array[++rear] = value;
            nItems++;
        }
    }

    //移除数据
    public Object remove(){
        Object removeValue = null;
        if(!isEmpty()){
            removeValue = array[front];
            array[front] = null;
            front++;
            if(front == maxSize){
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }

    //查看队头数据
    public Object peekFront(){
        return array[front];
    }

    //查看队尾数据
    public Object peekRear(){
        return array[rear];
    }

    //判断队列是否满了
    public boolean isFull(){
        return (nItems == maxSize);
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return (nItems == 0);
    }

    //返回队列大小
    public int getSize(){
        return nItems;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        System.out.println(myQueue.peekFront());
        System.out.println(myQueue.peekRear());
        myQueue.remove();
        System.out.println(myQueue.peekFront());
        System.out.println(myQueue.peekRear());
        myQueue.insert(4);
        myQueue.insert(5);
        System.out.println(myQueue.peekFront());
        System.out.println(myQueue.peekRear());
    }
}
