package uke2_BineryTree;

public class Turneringstre {
    public static void main(String[] args) {

        int [] a = {0, 0, 0, 0, 0, 0, 2, 9, 8, 6, 5, 3};
        int begin = 5;

        for(int i = begin; i>0; --i){
            int id = i;
            int left = 2*id;
            int right = 2*id+1;
            if(a[left]>a[right]){ //sjekker om den til venste er større enn den til høyre.
                a[id]=a[left]; //hvis ja: denne id posisjonen for tallet til venstre.
            }else{
              a[id]=a[right]; //eller er det den til høyre som er større og tar posisjonen.
            }
        }
        System.out.println(a[1]); //Til slutt blir tallet i posisjonen 1 eller id 1 det største tallet.

        int [] b = {2,9,8,6,5,3};
        int [] bUtviddet;


    }
}
