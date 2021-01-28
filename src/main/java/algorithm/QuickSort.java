package algorithm;

import java.util.Arrays;

public class QuickSort {
    static int partition(int[] list, int left, int right){
        // 指定末尾数值为主元
        int x = list[right];
        // 指针i指向开头之前的位置
        int i = left - 1;
        // 指针j指向开头，向末尾移动
        for (int j = left; j <= right - 1; j++){
            if (list[j] <= x){
                // 若j指向的数值比主元小则开始交换i和j指向的值
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        // 交换i+1和末尾的值，这样主元就会位于正确的位置（之前主元一直在末尾的位置）
        // 即主元左侧的元素都比主元小或相等，右侧都比主元大
        int temp = list[i + 1];
        list[i + 1] = list[right];
        list[right] = temp;
        // i+1为主元的下标
        return i + 1;
    }

    static void quickSort(int[] list, int left, int right){
        if (left < right){
            // q是主元所在的下标
            int q = partition(list, left, right);
            // 根据主元位置拆分数组为两部分，依次递归排序
            quickSort(list, left, q - 1);
            quickSort(list, q + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }
}
