package algorithm;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] list){
        for (int i = 1; i < list.length; i++) {
            // 保存当前值
            int temp = list[i];
            // 指针
            int j = i;
            while (j > 0 && temp < list[j - 1]) {
                // 向前遍历，若比当前值大，一律将此位置的数值向后移一位
                list[j] = list[j - 1];
                j--;
            }
            if (j != i) {
                // j指针指向的位置就是当前值应该插入的位置
                list[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {5, 2, 4, 6, 1, 3};
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
