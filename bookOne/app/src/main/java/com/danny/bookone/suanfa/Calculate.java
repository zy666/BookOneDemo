package com.danny.bookone.suanfa;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

public class Calculate {

    public static void maoPao(int[] maoPaoArray, int position, Context context) {
        //5,9,2,8,7,6,4
        for (int i = 0; i < maoPaoArray.length - 1; i++) {
            int temp;
            Log.e("冒泡", "第" + (i + 1) + "遍======开始======");
            for (int j = 0; j < maoPaoArray.length - 1 - i; j++) {
                if (maoPaoArray[j] > maoPaoArray[j + 1]) {
                    temp = maoPaoArray[j];
                    maoPaoArray[j] = maoPaoArray[j + 1];
                    maoPaoArray[j + 1] = temp;
                }
                Log.e("冒泡", "第" + (i + 1) + "遍" + "第" + (j + 1) + "次循环" + Arrays.toString(maoPaoArray));
            }
            Log.e("冒泡", "第" + (i + 1) + "遍======结束======" + "结果：" + Arrays.toString(maoPaoArray));
        }
        Toast.makeText(context, Arrays.toString(maoPaoArray), Toast.LENGTH_LONG).show();
    }

    public static void maoPaoYouhua(int[] maoPaoArray, int position, Context context) {
        //5,9,2,8,7,6,4
        int temp;
        boolean flag;//是否交换的标志
        for (int i = 0; i < maoPaoArray.length - 1; i++) {
            flag = false;
            Log.e("冒泡", "第" + (i + 1) + "遍======开始======");
            for (int j = 0; j < maoPaoArray.length - 1 - i; j++) {
                if (maoPaoArray[j] > maoPaoArray[j + 1]) {
                    temp = maoPaoArray[j];
                    maoPaoArray[j] = maoPaoArray[j + 1];
                    maoPaoArray[j + 1] = temp;
                    flag = true;
                }
                Log.e("冒泡", "第" + (i + 1) + "遍" + "第" + (j + 1) + "次循环" + Arrays.toString(maoPaoArray));
            }
            Log.e("冒泡", "第" + (i + 1) + "遍======结束======" + "结果：" + Arrays.toString(maoPaoArray));
            if (!flag) break;
        }
        Toast.makeText(context, Arrays.toString(maoPaoArray), Toast.LENGTH_LONG).show();

    }

    public static void finalMaoPao(int[] maoPaoArray, int position, Context context) {
        int temp = 0;
        int tempPosition = 0;
        int len = maoPaoArray.length - 1;
        boolean flag;
        for (int i = 0; i < maoPaoArray.length - 1; i++) {
            flag = false;
            Log.e("冒泡", "第" + (i + 1) + "遍======开始======");
            for (int j = 0; j < len; j++) {
                if (maoPaoArray[j] > maoPaoArray[j + 1]) {
                    temp = maoPaoArray[j];
                    maoPaoArray[j] = maoPaoArray[j + 1];
                    maoPaoArray[j + 1] = temp;
                    flag = true;
                    tempPosition = j;
                }
                Log.e("冒泡", "第" + (i + 1) + "遍" + "第" + (j + 1) + "次循环" + Arrays.toString(maoPaoArray));
            }
            len = tempPosition;
            Log.e("冒泡", "第" + (i + 1) + "遍======结束======" + "结果：" + Arrays.toString(maoPaoArray));
            if (!flag) break;
        }
        Toast.makeText(context, Arrays.toString(maoPaoArray), Toast.LENGTH_LONG).show();


    }

    public static void selectSort(int[] arr, int length) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
            Log.e("选择排序", Arrays.toString(arr));
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                Log.e("插入排序", "第一次插入j的坐标:" + j);
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
            Log.e("插入排序", "第一次插入结束" + Arrays.toString(arr));
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void fastSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        Log.e("快速排序-填坑法", "第一次递归结束" + Arrays.toString(arr));

        // 用分治法递归数列的两部分
        fastSort(arr, startIndex, pivotIndex - 1);
        fastSort(arr, pivotIndex + 1, endIndex);
        Log.e("快速排序-填坑法", Arrays.toString(arr));
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;
        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
                Log.e("快速排序-填坑法", "右侧" + Arrays.toString(arr));

            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
                Log.e("快速排序-填坑法", "左侧" + Arrays.toString(arr));
            }
        }
        arr[index] = pivot;
        return index;
    }


}
