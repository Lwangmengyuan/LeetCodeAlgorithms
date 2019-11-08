package com.data.structure;

public class PriorityQueue {
    private int maxSize;
    private int[] array;
    private int nItems;

    public PriorityQueue(int size){
        this.maxSize = size;
        array = new int[maxSize];
        nItems = 0;
    }

    //插入数据
    public void insert(int value){
        int j;
        if(nItems == 0){
            array[nItems++] = value;
        }
        else{
            j = nItems - 1;
            //插入排序法，按照从大到小顺序排列
            while (j >= 0 && value > array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = value;
            nItems++;
        }
    }

    //移除数据，由于已经按照大小排序，移除数据指针向下移动
    //被移除的位置由于是int类型的，不能设置为null，所以暂时设置为-1
    public int remove(){
        int value = array[nItems-1];
        array[nItems-1] = -1;
        nItems--;
        return value;
    }

    //查看优先级最高的元素
    public int peekMin(){
        return array[nItems-1];
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return (nItems == 0);
    }

    //判断队列是否已满
    public boolean isFull(){
        return (nItems == maxSize);
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(2);
        priorityQueue.insert(8);
        priorityQueue.insert(5);
        System.out.println(priorityQueue.peekMin());
    }
}
