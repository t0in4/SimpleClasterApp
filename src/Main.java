import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    static double sumOfList(ArrayList<Integer> massive, int size) {
        double sum = 0;
        for (int i = 0; i < massive.size(); i++) {
            sum += massive.get(i);
        }
        System.out.println(sum / size);


        return sum / size;

    }

    public static void main(String[] args) {
        int[] myArray = {2, 3, 4, 10, 11, 12, 20, 25, 30};
        int cluster = 2;
        Random random = new Random();
        // two random mean values - start
        double m1 = random.nextInt(30 - 1 + 1) ; // if bound greater than 30 calculation at many cases produce NaN
        double m2 = random.nextInt(30 - 1 + 1) ;
        // two random mean values - end

        // two mean values, same as in video - start
        /*double m1 = 3;
        double m2 = 18;*/
        // two mean values, same as in video - end;
        System.out.println("1. m1 = " + m1);
        System.out.println("1. m2 = " + m2);
        System.out.println();

        ArrayList<Integer> massive1 = new ArrayList<>();
        ArrayList<Integer> massive2 = new ArrayList<>();
        for (int i = 0; i < myArray.length; i++) {
            if (Math.abs(myArray[i] - m1) < Math.abs(myArray[i] - m2)) {
                massive1.add(myArray[i]);
            } else {
                massive2.add(myArray[i]);
            }
        }
        boolean position = true;
        double check = 0;
        while (position) {
            m1 = sumOfList(massive1, massive1.size());
            m2 = sumOfList(massive2, massive2.size());
            massive1.clear();
            massive2.clear();
            for (int i = 0; i < myArray.length; i++) {
                if (Math.abs(myArray[i] - m1) < Math.abs(myArray[i] - m2)) {
                    massive1.add(myArray[i]);
                } else {
                    massive2.add(myArray[i]);
                }
            }
            System.out.println(m1);
            System.out.println(m2);
            System.out.println(massive1);
            System.out.println(massive2);
            if ((int) check == (int) m1) {
                position = false;
            }
            check = m1;
        }
    }
}