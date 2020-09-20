package uke5;

public class TowerOfHanois {
    public static void main(String[] args) {
        hanois('A','B','C',2);

    }
    static void hanois(char a,char b,char c,int brikkenr){
        if(brikkenr ==0){
            return;
        }
        // flytt a -> b:
        hanois(a,c,b,brikkenr-1);
        //flytt a -> c:
        System.out.println(brikkenr+": ("+a+"->"+c+")");
        //flytt b -> c:
        hanois(b,a,c,brikkenr-1);
    }
}
