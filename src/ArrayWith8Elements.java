import java.util.Arrays;

public class ArrayWith8Elements {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]
 Выведите массив на экран в строку
 Замените каждый элемент с нечётным индексом на ноль
 Снова выведете массив на экран на отдельной строке
     */

    public static int[] createAndFillArray(){
        int [] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*(10)+1);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
    public static int[] changeElementWithNotEvenIndex(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i%2!=0){
                array[i]=0;
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
