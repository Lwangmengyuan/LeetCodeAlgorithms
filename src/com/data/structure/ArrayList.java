package com.data.structure;

public class ArrayList {
    private int[] intArray;
    //数组实际有效长度
    private int effectiveLength;
    //数组定义的最大长度
    private int maxLength;

    //默认构造一个长度为50的数组
    public ArrayList() {
        effectiveLength = 0;
        maxLength = 50;
        intArray = new int[maxLength];
    }

    //构造函数，初始化一个长度为length的数组
    public ArrayList(int length) {
        effectiveLength = 0;
        maxLength = length;
        intArray = new int[maxLength];
    }

    //获取数组有效长度
    public int getLength() {
        return effectiveLength;
    }

    //遍历并显示元素
    public void traversingElements() {
        for (int i = 0; i < effectiveLength; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    //添加元素，添加成功返回true，添加元素超过范围返回false
    public boolean addElement(int value) {
        if (effectiveLength == maxLength) {
            return false;
        } else {
            intArray[effectiveLength] = value;
            effectiveLength++;
        }
        return true;
    }

    //根据下表获取元素，下标在有效范围内，正常返回对应元素；下标超出数组下标有效值，提示访问下标越界
    public int getElement(int key) {
        if (key < 0 || key > effectiveLength) {
            System.out.println("访问下标越界");
        }
        return intArray[key];
    }

    //查找元素，如果元素存在则返回下标值，如果元素不存在则返回-1
    public int findElement(int value) {
        int i;
        for (i = 0; i < effectiveLength; i++) {
            if (intArray[i] == value) {
                break;
            }
        }
        if(i == effectiveLength){
            return -1;
        }
        return i;
    }

    //删除元素，如果要删除的元素不存在，直接返回false；否则返回true
    public boolean deleteElement(int value){
        int result = findElement(value);
        if(result == -1){
            return false;
        }else{
            if(result == effectiveLength-1){
                effectiveLength--;
            }else{
                for(int i = result ; i < effectiveLength ; i++){
                    intArray[i] = intArray[i+1];
                }
                effectiveLength--;
            }
            return true;
        }
    }

    //修改数据，修改成功返回true，修改失败返回false
    public boolean modifyElement(int oldValue,int newValue){
        int result = findElement(oldValue);
        if(result == -1){
            System.out.println("需要修改的数据不存在");
            return false;
        }else{
            intArray[result] = newValue;
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayList myarray = new ArrayList(4);
        myarray.addElement(1);
        myarray.addElement(2);
        myarray.addElement(3);
        myarray.addElement(4);
        myarray.traversingElements();
        System.out.println(myarray.getElement(0));
        myarray.deleteElement(4);
        myarray.modifyElement(3,33);
        myarray.traversingElements();
    }
}