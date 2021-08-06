package sort;

/**
 * 选择排序算法实现，从小到大对数组排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] arr={4,6,3,6,8,4,3};
        sort(arr);
        for(int a:arr)
            System.out.println(a);
    }
    public static void sort(int [] arr) {
        int length=arr.length;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j<length;j++) {
                if(arr[j]<arr[i]) {
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }

}
