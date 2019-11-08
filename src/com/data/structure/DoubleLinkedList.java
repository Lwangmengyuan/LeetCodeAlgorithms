package com.data.structure;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object obj){
            this.data = obj;
        }
    }

    public DoubleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //在链表头增加节点
    public void insertHead(Object value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            head.prev = node;
            node.next = head;
            head = node;
            size++;
        }
    }

    //在链表尾增加节点
    public void insertTail(Object obj){
        Node node = new Node(obj);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            node.prev = tail;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    //删除链表头
    public Node deleteHead(){
        Node temp = head;
        if(size > 0){
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }

    //删除链表尾
    public Node deleteTail(){
        Node temp = tail;
        if(size > 0){
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }

    //获得链表节点个数
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        if(size > 0){
            Node temp = head;
            int tempSize = size;
            if(tempSize == 1){
                System.out.print("[" + temp.data + "]");
                return;
            }
            while (tempSize > 0){
                if(temp.equals(head)){
                    System.out.print("[" + temp.data + "->");
                }else if(temp.equals(tail)){
                    System.out.print(temp.data + "]");
                }else {
                    System.out.print(temp.data + "->");
                }
                temp = temp.next;
                tempSize--;
            }
            System.out.println();
        }else{
            System.out.println("[]");
        }
    }

    public static void main(String[] args) {

    }
}
