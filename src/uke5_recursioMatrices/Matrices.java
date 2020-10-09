package uke5_recursioMatrices;

public class Matrices {
    public static void main(String[] args) {
        //declaring a matrix or an 2d array:
        int [][] primes = {
                { 2, 3, 5, 7},
                {11,13,17,19},
                {23,29,31,37},
                {41,47,53,59}
        };
        int a = primes[1][2]; //it will find the element on row 1 and column 2 which is (17)
        System.out.println("using a 2d declaration:\nprimes(1,2) = "+a);
        /* it is a way of crating a 2d array, but it isn't the best efficient way of doing it.
        the bes way for that is to make it like one dimensional array.
        * */
        int [] primes1 = {/*0*/2, 3, 5, 7,/*1*/11,13,17,19,/*2*/23,29,31,37,/*3*/41,47,53,59};
        //The way of finding an element in this one dimensional array by referring to row and column numbers
        //is the following:
        int index = index(4,1,2);
        int a1=primes1[index];

        System.out.println("using a 1d array declaration:\nprimes1(1,2) = "+a1);
    }

    /**
     *
     * @param n_col number of columns of the 2d array the we have in mind.
     * @param row which row we take the element from.
     * @param col which column we take the element from.
     * @return the index of the wanted value in the 1d array.
     */
    static int index(int n_col,int row, int col){
        return row * n_col + col;
    }

}
