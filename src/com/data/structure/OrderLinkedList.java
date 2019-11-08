package com.data.structure;

public class OrderLinkedList {
    private Node head;

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public OrderLinkedList(){
        head = null;
    }

    //插入节点，并按从小到大的顺序进行排序
    public void insert(int value){
        Node node = new Node(value);
        Node previous = null;
        Node current = head;
        if(current != null && value > current.data){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            head = node;
            head.next = current;
        }else{
            previous.next = node;
            node.next = current;
        }
    }

    //删除头节点
    public void deleteHead(){
        head = head.next;
    }

    //显示全部节点
    public void display(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
