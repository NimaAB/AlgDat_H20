package eksamen_2018;

import java.util.Arrays;
import java.util.StringJoiner;

public class Oppgave_3 {
    public static void main(String[] args) {
        int [] b = {1,2,5,9,11,13,0,0,0,0};
        Mengde B = new Mengde(b,6);
        System.out.println(B);
    }

}
class Mengde{
    private int[]a;
    public Mengde(){
        this.a = new int[0];
    }
    public Mengde(int [] b, int n){
        //kode:
        this.a = new int[n];
        int i = 0;
        while(i<n){
            a[i] = b[i];
            i++;
        }
    }

    @Override
    public String toString() {
        //kode:
        StringJoiner sj = new StringJoiner(", ","[","]");
        for(int el: a){
            sj.add(""+el);
        }
        return sj.toString();
    }
}
