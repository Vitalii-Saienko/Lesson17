public class Main {

    public static void main(String[] args) {

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        TransposeMatrix.showMatrix(arr2);
        System.out.println("------");
        TransposeMatrix.transposeMatrix(arr2);
        TransposeMatrix.showMatrix(arr2);
        System.out.println("------");
        int[] array = FindMaxInRandomArray.createAndFillArray();
        FindMaxInRandomArray.finMaxAndGetIndex(array);
       // https://github.com/tel-ran-de/49-49-morning-basic-java/blob/main/src/main/java/homework/lesson17/Tasks.txt
    }


}