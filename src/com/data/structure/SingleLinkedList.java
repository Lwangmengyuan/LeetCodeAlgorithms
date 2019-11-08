package com.data.structure;

public class SingleLinkedList {
    private int size;
    private Node head;

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    //链表的每个节点
    public class Node{
        //每个节点数据
        private Object data;
        //每个节点指向下一个节点的连接
        private Node next;

        public Node(Object data){
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj){
        Node newHead = new Node(obj);
        if(size == 0){
            head = newHead;
        }else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到则返回节点node，找不到则返回null
    public Node find(Object obj){
        Node current = head;
        int tempSize = size;
        while (tempSize > 0){
            if(obj.equals(current.data)){
                return current;
            }else{
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定元素，删除成功则返回true
    public boolean delete(Object value){
        if(size == 0){
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != value){
            if(current.next == null){
                return false;
            }else{
                previous = current;
                current = current.next;
            }
        }
        //如果删除的节点是第一个节点
        if(current == head){
            head = current.next;
            size--;
        }else {
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
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
            while (tempSize > 0){
                if(node.equals(head)){
                    System.out.print("[" + node.data + "->");
                }else if(node.next == null){
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
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");
        singleLinkedList.display();
        singleLinkedList.delete("C");
        singleLinkedList.display();
        System.out.println(singleLinkedList.find("B"));
    }
}