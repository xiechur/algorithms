package sort;

public class InsertSort {
    public InsertSort(){

    }
//
//
//
//    /***
//     *直接插入排序
//     * O（n^2）
//     * 最好情况有序：O（n）
//     *
//     */
//    public static   void insertSort(int[] o,int low ,int high){
//        for(int i = low + 1; i <= high; i ++){
//            if (compareTo(o[i],o[i-1]) < 0){
//                int temp =o[i];
//
//                o[i] = o[i-1];
//                int j = i-2;
//                for (;j >=low && compareTo(temp,o[j])<0;j--){//记录后移
//                    o[j+1] = o[j];
//                }
//                o[j+1] = temp;
//            }
//        }
//    }
//    /**
//     *折半插入
//     * 相比直接插入
//     * 减少比较次数
//     * 移动次数不变
//     */
//    public static  void binInsertSort(int[] o,int low,int high){
//        for (int i = low + 1; i <= high;i++){
//            int temp = o[i];
//            int h1 = i- 1;
//            int lo = low;
//            while (lo <= high ){
//                int mid = (lo + h1)/2;
//                if (compareTo(temp,o[mid]) < 0){
//                    h1 = mid - 1;
//                }else {
//                    lo = mid + 1;
//                }
//            }
//            for (int j = i - 1;j > h1;j--){
//                o[j+1] = o[j];//移动元素 向后
//            }
//            o[h1+1] = temp;
//        }
//    }
//
//    /**
//     * 希尔排序
//     *
//     */
//    public static void shellSort(int []ints,int low,int high,int[] delta){
//        for (int l = 0;l < delta.length; l++){
//            shellInsertSort(ints,low,high,delta[l]);//一趟步长  delta[l] 的直接插入
//        }
//    }
//    public  void shellInsertSort(int[] ints,int low,int high,int deltaL){
//       for (int i = (low + deltaL); i <= high; i++){
//            if (compareTo(ints[i],ints[i - deltaL]) < 0){
//                int temp = ints[i];
//                int j = i - deltaL;
//                for (;j >= low && compareTo(temp,ints[j]) < 0;j = j - deltaL){
//                    ints[j - deltaL] = ints[j];
//                }
//                ints[j + deltaL] = temp;
//           }
//       }
//    }



    /***
     *直接插入排序
     * O（n^2）
     * 最好情况有序：O（n）
     *
     */
    public static void insertSort(int[] o,int low ,int high){
        for(int i = low + 1; i <= high; i ++){
            if (o[i] < o[i-1]){
                int temp =o[i];
                o[i] = o[i-1];
                int j = i-2;
                for (;j >=low && temp<o[j];j--){//记录后移
                    o[j+1] = o[j];
                }
                o[j+1] = temp;
            }
        }
    }
    /**
     *折半插入
     * 相比直接插入
     * 减少比较次数
     * 移动次数不变
     */
    public static void binInsertSort(int[] o,int low,int high){
        for (int i = low + 1; i <= high;i++){
            int temp = o[i];
            int h1 = i- 1;
            int lo = low;
            while (lo <= h1 ){
                int mid = (lo + h1)/2;
                if (temp < o[mid]){
                    h1 = mid - 1;
                }else {
                    lo = mid + 1;
                }
            }
            for (int j = i - 1;j > h1;j--){
                o[j+1] = o[j];//移动元素 向后
            }
            o[h1+1] = temp;
        }
    }

    /**
     * 希尔排序
     *
     */
    public static void shellSort(int []ints,int low,int high,int[] delta){
        for (int l = 0;l < delta.length; l++){
            shellInsertSort(ints,low,high,delta[l]);//一趟步长  delta[l] 的直接插入
        }
    }
    public static void shellInsertSort(int[] ints,int low,int high,int deltaL){
        for (int i = (low + deltaL); i <= high; i++){
            if (ints[i]<ints[i - deltaL]){
                int temp = ints[i];
                int j = i - deltaL;
                for (;j >= low && temp < ints[j];j = j - deltaL){
                    ints[j + deltaL] = ints[j];
                }
                ints[j + deltaL] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = {8,3,5,7,2,4,9,0,1,6};
        insertSort(a,0,9);

//        binInsertSort(a,0,9);

//        int []l = {5,3,1};
//        shellSort(a,0,9,l);

        for (int i = 0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

}