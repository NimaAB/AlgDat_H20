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
    private int[] a;
    public Mengde(){
        this.a = new int[0];
    }
    public Mengde(int [] b, int n){
        //kode:
        if(n>b.length || n<0){
            throw new IllegalArgumentException("n should be = (0,b.length]");
        }
        for(int i = 1; i<n; i++){
            if(b[i]<=b[i-1]){
                String msg = (b[i]<b[i-1]) ? "usortert mengde" : "Duplikater i megden";
                throw new IllegalArgumentException(msg);
            }
        }
        a = Arrays.copyOf(b,n);
    }

    @Override
    public String toString() {
        //kode:
        if(a.length==0){
            return "[]";
        }
        StringJoiner sj = new StringJoiner(", ","[","]");
        for(int el: a){
            sj.add(""+el);
        }
        return sj.toString();
        //alternativ: return Arrays.toString(a);
    }
}
