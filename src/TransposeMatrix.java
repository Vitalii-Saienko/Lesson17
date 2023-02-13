public class TransposeMatrix {
    /*
    Write a program to transpose
    a given square matrix without using an additional array.
     */
    public static void transposeMatrix(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }
    public static void showMatrix(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
