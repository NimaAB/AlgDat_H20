package uke2_BineryTree;

public class Intervaller {
    /**
     * begin to end intervall er lignende [begin,end>
     * med ord fra og med begin til end (men ikke inkluder end)
     */
    void print1(int begin,int end){
        for(int i = begin; i < end; ++i){
            System.out.println(i);
        }
    }

    /**
     * left to right intervall er ligninde [left,right]
     * med ord fra og med left til og med right.
     */
    void print2(int left,int right){
        for(int i = left; i <= right; ++i){
            System.out.println(i);
        }
    }
}
