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

    public static void selectSort(int[] arr, Context context) {
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
        Toast.makeText(context, Arrays.toString(arr), Toast.LENGTH_LONG).show();

    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr, Context context) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //开始插入操作
            arr[j + 1] = temp;
        }
        Log.e("插入排序：", Arrays.toString(arr));
        Toast.makeText(context, Arrays.toString(arr), Toast.LENGTH_LONG).show();

    }


    /**
     * 折半查找-递归实现
     *
     * @param arr  数组
     * @param key  查找位置
     * @param low  最小索引
     * @param high 最大索引
     */
    public static void halfSearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            Log.e("折半", "查找错误");
        }
        int mid = (low + high) / 2;
        if (key < arr[mid]) {
            halfSearch(arr, key, low, mid - 1);
        } else if (key > arr[mid]) {
            halfSearch(arr, key, mid + 1, high);
        } else {
            Log.e("折半", mid + "");
        }
    }

    /**
     * 折半查找——迭代实现
     *
     * @param arr 数组
     * @param key 查找位置
     */
    public static void halfSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        if (key < arr[low] || key > arr[high] || low > high) {
            Log.e("折半", "查找结束");
            return;
        }
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                Log.e("折半", mid + "");
                return;
            }
        }

    }

    /**
     * 树查找
     *
     * @param arr
     */
    public static void treeSearch(int[] arr, Context context) {
        Log.e("插入排序：", Arrays.toString(arr));
        Toast.makeText(context, Arrays.toString(arr), Toast.LENGTH_LONG).show();
    }

    /**
     * hash查找
     *
     * @param arr
     */
    static int hashLength = 7;
    static int[] hashTable;

    public static void hashSearch(int[] arr, int searchData) {
        hashTable = new int[hashLength];
        //创建哈希表
        for (int i = 0; i < arr.length; i++) {
            insert(hashTable, arr[i]);
        }
        Log.e("展示哈希表中的数据：", display(hashTable));
        int result = search(hashTable, searchData);
        Log.e("哈希查找", result + "");
    }

    public static void insert(int[] hashTable, int data) {
        //哈希函数，除留余数法
        int hashAddress = hash(hashTable, data);
        Log.e("冲突前的hashAddress：", hashAddress + "");

        while (hashTable[hashAddress] != 0) {
//            Log.e("hashAddress-while：", hashAddress + "");
            hashAddress = (++hashAddress) % hashTable.length;
            Log.e("冲突后的hashAddress：", hashAddress + "");
        }

        hashTable[hashAddress] = data;
        Log.e("最终的处理后的：", hashAddress + "");
        Log.e("hashTable：", Arrays.toString(hashTable));

    }

    /**
     * 方法：展示哈希表
     */
    public static String display(int[] hashTable) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : hashTable) {
            stringBuffer = stringBuffer.append(i + " ");
        }
        return String.valueOf(stringBuffer);
    }

    /**
     * 方法：哈希表查找
     */
    public static int search(int[] hashTable, int data) {
        // 哈希函数，除留余数法
        int hashAddress = hash(hashTable, data);

        while (hashTable[hashAddress] != data) {
            // 利用 开放定址法 解决冲突
            hashAddress = (++hashAddress) % hashTable.length;
            // 查找到开放单元 或者 循环回到原点，表示查找失败
            if (hashTable[hashAddress] == 0 || hashAddress == hash(hashTable, data)) {
                return -1;
            }
        }
        // 查找成功，返回下标
        return hashAddress;
    }

    /**
     * 方法：构建哈希函数（除留余数法）
     *
     * @param hashTable
     * @param data
     * @return
     */
    public static int hash(int[] hashTable, int data) {
        return data % hashTable.length;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void fastSort(int[] arr, int startIndex, int endIndex, Context context) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        Log.e("快速排序-填坑法", "第一次递归结束" + Arrays.toString(arr));

        // 用分治法递归数列的两部分
        fastSort(arr, startIndex, pivotIndex - 1, context);
        fastSort(arr, pivotIndex + 1, endIndex, context);
        Log.e("快速排序-填坑法", Arrays.toString(arr));
        Toast.makeText(context, Arrays.toString(arr), Toast.LENGTH_LONG).show();

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
