import java.util.Arrays;
import java.util.StringJoiner;

public class Test {

    static int[] bokstavNr(){
        int [] nummer = new int[29];
        char [] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'
                ,'Q','R','S','T','U','V','W','X','Y','Z','Æ','Ø','Å'};

        for(int i = 0;i<nummer.length;++i){
            nummer[i]= chars[i];
        }
        return nummer;
    }

    public static void main(String[] args) {
       //System.out.println(Arrays.toString(bokstavNr()));
        System.out.println(0x7fffffff);
        System.out.println(-1 & 0x7fffffff);
        System.out.println(-2&0x7fffffff);
        System.out.println(-3333&0x7fffffff);
        System.out.println(-2147483647&0x7fffffff);
        System.out.println(-2147483648&0x7fffffff);

        if((2&0x7fffffff)>=0){
            System.out.println("True = " + (2&0x7fffffff));
        }
       /* double x = 2<<2;
        System.out.println(x);*/



    }
}
