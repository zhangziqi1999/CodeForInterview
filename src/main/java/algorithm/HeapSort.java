package algorithm;

import java.util.Arrays;

public class HeapSort {
    static int heapSize = 0;

    /**
     * 注意：这个方法是在两棵子树都已经成为大顶堆的情况下才能使用
     * 所以利用这个方法建堆需要从树的倒数第二层开始依次向上
     */
    static void maxHeapify(int[] list, int index){
        // 左孩子的下标
        int left = index * 2 + 1;
        // 右孩子的下标
        int right = index * 2 + 2;
        // 保存根结点、左孩子、右孩子中的最大值的下标
        int largest;
        // 注意：下面使用左孩子、右孩子的下标都需要判断是否超出堆的范围
        // 下面就是在根结点、左孩子、右孩子找到最大值的下标
        if (left < heapSize && list[left] > list[index]){
            largest = left;
        }else{
            largest = index;
        }
        if (right < heapSize && list[right] > list[largest]){
            largest = right;
        }
        // 如果根节点已经是最大值了，此方法退出
        if (largest != index){
            // 若发现最大值居然不是根节点，则需要交换，使根节点为最大值
            int temp = list[index];
            list[index] = list[largest];
            list[largest] = temp;
            // 交换完后，与根节点交换数值的孩子所在的子树可能由于交换会不满足堆的性质，所以要进行递归调用
            maxHeapify(list, largest);
        }
    }

    static void buildMaxHeap(int[] list){
        // 建堆时需要保存堆大小
        heapSize = list.length;
        for (int i = heapSize / 2 + 1; i >= 0; --i){
            // 从倒数第二层开始建堆，因为最后一层的叶子节点没有孩子没必要再去判断了
            maxHeapify(list, i);
        }
    }

    static void heapSort(int[] list){
        // 先建堆
        buildMaxHeap(list);
        for (int i = list.length - 1; i >= 1; --i){
            // 从堆中取出根节点放在i指向的位置，因为根节点是整个堆的最大值
            // 同时将i指向的位置的值放入根节点的位置
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            // 注意：不要忘记，取出大顶堆根节点之后就要将堆大小-1
            // 因为从末尾开始放的是已经排序好的元素，不再是堆的元素了，堆处于一个逐渐减少至0的过程
            heapSize--;
            // 根节点变化之后需要再次保证满足堆的定义
            maxHeapify(list, 0);
        }
    }

    public static void main(String[] args) {
        int[] list = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }
}
