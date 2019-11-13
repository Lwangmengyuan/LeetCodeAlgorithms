package com.data.structure;

public class DoubleHash {
    //每个数据项信息
    private DataItem[] hashArray;
    private int arraySize;
    private int itemNum;
    private DataItem nonItem;

    public DoubleHash(){
        arraySize = 13;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    //判断数组是否存储满了
    public boolean isFull(){
        return (itemNum == arraySize);
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return (itemNum == 0);
    }

    //打印数组内容
    public void display(){
        System.out.println("Table:");
        for(int i = 0; i < arraySize; i++){
            if(hashArray[i] != null){
                System.out.println(hashArray[i].getKey() + " ");
            }else{
                System.out.println("**");
            }
        }
    }

    //通过哈希函数转换得到数组下标
    public int hashFunction1(int key){
        return key%arraySize;
    }

    public int hashFunction2(int key){
        return 5 - key%5;
    }

    //插入数据项
    public void insert(DataItem item){
        if(isFull()){
            //扩展哈希表
            System.out.println("哈希表已满，重新哈希化...");
            extendHashTable();
        }
        int key = item.getKey();
        int hashValue = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1){
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
        itemNum++;
    }

    //重新哈希化
    private void extendHashTable() {
        int num = arraySize;
        itemNum = 0;
        arraySize *= 2;
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];
        for(int i = 0; i < num; i++){
            insert(oldHashArray[i]);
        }
    }

    //删除数据项
    public DataItem delete(int key){
        if(isEmpty()){
            System.out.println("哈希表为空");
            return null;
        }
        int hashValue = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while (hashArray[hashValue] != null){
            if(hashArray[hashValue].getKey() == key){
                DataItem temp = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                itemNum--;
                return temp;
            }
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        return null;
    }

    //查找数据项
    public DataItem fing(int key){
        int hashValue = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while (hashArray[hashValue] != null){
            if(hashArray[hashValue].getKey() == key){
                return hashArray[hashValue];
            }
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        return null;
    }

    public static class DataItem{
        private int data;

        public DataItem(int iData){
            this.data = iData;
        }

        public int getKey(){
            return data;
        }
    }


}