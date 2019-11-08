package com.data.structure;

public class DoublePointLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private Object data;
        private Node next;

        public Node(Object obj){
            this.data = obj;
        }
    }

    public DoublePointLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //链表头新增节点
    public void addHead(Object value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            node.next = head;
            head = node;
            size++;
        }
    }

    //链表尾新增节点
    public void addTail(Object value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            tail.next = node;
            tail = node;
            size++;
        }
    }

    //删除头部节点，成功则返回true，失败则返回false
    public boolean deleteHead(){
        if(size == 0){
            return false;
        }
        if(head.next == null){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
        size--;
        return true;
    }

    //判断是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //获取链表节点个数
    public int getSize(){
        return size;
    }

    //显示节点信息
    public void display(){
        if(size > 0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){
                System.out.println("[" + node.data + "]");
                return;
            }
            while(tempSize > 0){
                if(node.equals(head)){
                    System.out.print("[" + node.data + "->");
                }else if(node.equals(tail)){
                    System.out.print(node.data + "]");
                }else{
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{
            System.out.println("[]");
        }
    }

    public static void main(String[] args) {
        DoublePointLinkedList doublePointLinkedList = new DoublePointLinkedList();
        doublePointLinkedList.addHead(1);
        doublePointLinkedList.addHead(2);
        doublePointLinkedList.addHead(3);
        doublePointLinkedList.addTail(4);
        doublePointLinkedList.addTail(5);
        doublePointLinkedList.display();
        doublePointLinkedList.deleteHead();
        doublePointLinkedList.display();
    }
}
