public class Main {

    public static void main(String[] args) {

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        TransposeMatrix.showMatrix(arr2);
        System.out.println("------");
        TransposeMatrix.transposeMatrix(arr2);
        TransposeMatrix.showMatrix(arr2);
    }


}