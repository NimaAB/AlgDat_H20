package uke4;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        //Max and min:
        Person [] deltakere = new Person[3];
        deltakere [0] = new Person("Nima","Bewrani");
        deltakere [1] = new Person("Nima","Abdollahi");
        deltakere [2] = new Person("Navn","Navnsen");

        System.out.println(Generic.maksGeneric(deltakere));
        System.out.println(Generic.minGeneric(deltakere));

        // Sorting:
        Integer [] arr= {};
        try {
            GenericSorting<Integer> a = new GenericSorting<>(arr);
            a.sort();
            System.out.println(Arrays.toString(arr));
        }catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }

    }
}
