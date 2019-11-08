package com.data.structure;

public class LinearDetectHashTable {
    //DataItem类，表示每个数据项信息
    private DataItem[] array;
    //数组的初始大小
    private int arraySize;
    //数组实际存储的数据量
    private int itemNum;
    //用于删除数据项
    private DataItem nonItem;

    private static class DataItem{
        private int iData;
        public DataItem(int iData){
            this.iData = iData;
        }

        public int getKey(){
            return iData;
        }
    }

    public LinearDetectHashTable(int arraySize){
        this.arraySize = arraySize;
        array = new DataItem[arraySize];
        //删除的数据项下标为-1
        nonItem = new DataItem(-1);
    }

    //判断数组是否已存储满
    public boolean isFull(){
        return (itemNum == arraySize);
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return (itemNum == 0);
    }

    //打印数组内容
    public void display(){
        System.out.println("HashTable:");
        for(int j = 0; j < arraySize; j++){
            if(array[j] != null){
                System.out.print(array[j].getKey() + " ");
            }else{
                System.out.print("** ");
            }
        }
    }

    //通过哈希函数转换得到数组下标
    public int hashFunction(int key){
        return key%arraySize;
    }

    /**
     *数组有固定的大小，而且不能扩展，所以扩展哈希表只能另外创建一个更大的数组，然后把旧数组中的数据插到新的数组中。
     *但是哈希表是根据数组大小计算给定数据的位置的，所以这些数据项不能再放在新数组中和老数组相同的位置上。
     *因此不能直接拷贝，需要按顺序遍历老数组，并使用insert方法向新数组中插入每个数据项。
     *这个过程叫做重新哈希化。这是一个耗时的过程，但如果数组要进行扩展，这个过程是必须的。
     */
    public void extendHashTable(){
        int num = arraySize;
        //重新计数，因为下面要把原来的数据转移到新扩张的数组中
        itemNum = 0;
        //数组大小翻倍
        arraySize *= 2;
        DataItem[] oldArray = array;
        array = new DataItem[arraySize];
        for(int i = 0; i < num; i++){
            insert(oldArray[i]);
        }
    }

    //插入数据项
    public void insert(DataItem item){
        if(isFull()){
            //扩展哈希表
            System.out.println("哈希表已满，重新哈希化...");
            extendHashTable();
        }
        int key = item.getKey();
        int hashValue = hashFunction(key);
        while (array[hashValue] != null && array[hashValue].getKey() != -1){
            ++hashValue;
            hashValue %= arraySize;
        }
        array[hashValue] = item;
        itemNum++;
    }

    //删除数据项
    public DataItem delete(int key){
        if(isEmpty()){
            System.out.println("Hash Table is Empty!");
            return null;
        }
        int hashValue = hashFunction(key);
        while (array[hashValue] != null){
            if(array[hashValue].getKey() == key){
                DataItem temp = array[hashValue];
                array[hashValue] = nonItem;
                itemNum--;
                return temp;
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

    //查找数据项
    public DataItem find(int key){
        int hashValue = hashFunction(key);
        while (array[hashValue] != null){
            if(array[hashValue].getKey() == key){
                return array[hashValue];
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

    public static void main(String[] args) {
        DataItem data1 = new DataItem(1);
        DataItem data2 = new DataItem(2);
        DataItem data3 = new DataItem(3);
        DataItem data4 = new DataItem(4);
        DataItem data5 = new DataItem(5);

        LinearDetectHashTable linearDetectHashTable = new LinearDetectHashTable(3);
        linearDetectHashTable.insert(data1);
        linearDetectHashTable.insert(data2);
        linearDetectHashTable.insert(data3);
        System.out.println(linearDetectHashTable.find(1));
        System.out.println(linearDetectHashTable.find(2));
        System.out.println(linearDetectHashTable.find(3));
        linearDetectHashTable.insert(data4);
        linearDetectHashTable.insert(data5);
        linearDetectHashTable.delete(3);
        System.out.println(linearDetectHashTable.find(1));
        System.out.println(linearDetectHashTable.find(2));
        System.out.println(linearDetectHashTable.find(3));
        System.out.println(linearDetectHashTable.find(4));
        System.out.println(linearDetectHashTable.find(5));
    }
}
