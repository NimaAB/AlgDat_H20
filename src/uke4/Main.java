package uke4;

public class Main {
    public static void main(String[] args) {
        Person [] deltakere = new Person[3];
        deltakere [0] = new Person("Nima","Bewrani");
        deltakere [1] = new Person("Namam","Bewrani");
        deltakere [2] = new Person("Hazhir","Abdollahi");

        System.out.println(Generic.maksGeneric(deltakere));
        System.out.println(Generic.minGeneric(deltakere));

    }
}
