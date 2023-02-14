import java.util.Arrays;

public class FindMaxInRandomArray {
    /*
    Create an array of 12 random integers from the interval [-15;15].
Determine which element is the maximum in this array and
report the index of its last occurrence in the array.
     */
    public static int[] createAndFillArray(){
        int [] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*(15-(-15)+1)-15);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
    public static void finMaxAndGetIndex(int[] array){
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>=max){
                max = array[i];
                index = i;
            }
        }
        System.out.println("Max is: "+max+"\nindex of max last occurrence is: "+index);
    }
}
