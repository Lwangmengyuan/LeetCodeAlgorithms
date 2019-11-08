package com.data.structure;

public class SingleLinkListStack {
    private SingleLinkedList link;

    public SingleLinkListStack(){
        link = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj){
        link.addHead(obj);
    }

    //移除栈顶元素
    public Object pop(){
        Object obj = link.deleteHead();
        return obj;
    }

    //判断是否为空
    public boolean isEmpty(){
        return link.isEmpty();
    }

    //打印栈内元素信息
    public void display(){
        link.display();
    }

    public static void main(String[] args) {
        SingleLinkListStack singleLinkListStack = new SingleLinkListStack();
        singleLinkListStack.push("a");
        singleLinkListStack.push("b");
        singleLinkListStack.push("c");
        singleLinkListStack.push("d");
        singleLinkListStack.display();
        singleLinkListStack.pop();
        singleLinkListStack.display();
    }
}
