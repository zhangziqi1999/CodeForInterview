package algorithm;

import java.util.Arrays;

public class CountingSort {
    static int[] countingSort(int[] list, int k){
        // 初始化计数数组
        int[] temp = new int[k + 1];
        for (int j : list) {
            // 开始对list中的元素进行计数
            temp[j]++;
        }
        for (int i = 1; i < temp.length; ++i){
            // 通过计数结果可以求出数值在整个数组中的排名位置
            temp[i] += temp[i - 1];
        }
        // 保存排序结果的数组
        int[] result = new int[list.length];
        for (int i = list.length - 1; i >= 0; --i){
            // 从后往前创建新数组，保证排序的稳定性
            // 因为计数数组中保存的是相同数值的最后一名的排名(注意：相同数值依据出现的先后顺序进行排名以保证稳定性)
            // 所以这里必须要倒序创建数组
            result[temp[list[i]] - 1] = list[i];
            // 添加一个数值之后排名要记得-1
            temp[list[i]]--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] list = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] result = countingSort(list, 5);
        System.out.println(Arrays.toString(result));
    }
}
