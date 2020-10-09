package hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class Hashing {
    //for bedringer:
    //1) metoden skal ikke være static og skal være overridet fra Object klassen, men det har jeg ikke
    //fått til enda.
    //2)
    public static int hashCode(int a,int size) {
        return a%size;
    }

    public static void main(String[] args) {
        int [] a ={17,19,12,10,13,11,14};
        int [] b = new int[10];
        for (int j : a) {
            //finner plass for element j i a med metoden hashCode,
            int h = hashCode(j, b.length);
            b[h] = j;
        }
        System.out.println(Arrays.toString(b));
        //returnerer posisjonen til tallet 14 i b med O(1) kompleksitet:
        int search_14 = hashCode(14,b.length);
        System.out.println("14 is at index: "+search_14);

        ArrayList<String> l = new ArrayList<>();
        l.add("Nima");
        l.add(0,"Bewrani");

    }
}
