package com.data.structure;

public class SortingAlgorithm {
    //数组打印
    public void display(int[] array){
        for(int i =0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //冒泡排序
    public int[] bubbleSort(int[] array){
        //控制总共进行多少轮循环
        for(int i = 1; i < array.length; i++){
            boolean flag = true;
            //两两相邻元素比较，如果左边比右边大，就交换位置
            for(int j = 0; j < array.length-i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            System.out.print("第"+i+"轮排序结果为：");
            display(array);
        }
        return array;
    }

    //选择排序
    public int[] selectSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            int min = i;
            //找到最小值下标
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            //将找到的最小值和i所在位置进行交换
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            System.out.print("第"+(i+1)+"轮排序结果为：");
            display(array);
        }
        return array;
    }

    //插入排序
    public int[] insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            for(int j = i-1; j > 0; j--){
                if(array[j] > temp){
                    array[j+1] = array[j];
                }
                else{
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        SortingAlgorithm sa = new SortingAlgorithm();
        int[] input = {4,2,8,9,5,7,6,1,3};
//        int[] result = sa.bubbleSort(input);
//        int[] result = sa.selectSort(input);
        int[] result = sa.insertSort(input);
        sa.display(result);
    }
}