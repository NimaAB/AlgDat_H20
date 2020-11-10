package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashing {
    //for bedringer:
    //1) metoden skal ikke være static og skal være overridet fra Object klassen, men det har jeg ikke
    //fått til enda. (Kassen skal ha sin egen hashcode metode override_t! (f.eks.: Person() Class ))
    //2)


    public static int hashCode(String data) {
        int hash = 0;
        for (int i = data.length() - 1; i >= 0; --i) {
            char last_char = data.charAt(i);
            hash = (hash + last_char) * 13;
        }
        hash = hash & 0x7fffffff;
        //if the hash is negative it will make it( = 2147483647 - hash)
        //else the hash is positive, then it will be the same.
        return hash;
    }

    public static int hashIndex(int hashCode, int size) {
        return hashCode % size;
    }

    public static void main(String[] args) {
        String[] data = {"Name", "Age", "Fact", "Feelings", "OsloMet", "Society", "Expectations", "...So On"};
        int size = 10;
        ArrayList<LinkedList<String>> hashMap = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            hashMap.add(new LinkedList<>());
        }
        for (String str : data) {
            int hashCode = hashCode(str);
            int index = hashIndex(hashCode, size);
            hashMap.get(index).addFirst(str);
        }

        int i = 0;
        for (LinkedList<String> list : hashMap) {
            System.out.printf("at index: %d we have: %s\n", i, list.toString());
            ++i;
        }

        String output = "" +
                "at index: 0 we have: []\n" +
                "at index: 1 we have: [Expectations, Name]\n" +
                "at index: 2 we have: [Fact]\n" +
                "at index: 3 we have: []\n" +
                "at index: 4 we have: []\n" +
                "at index: 5 we have: []\n" +
                "at index: 6 we have: [Society]\n" +
                "at index: 7 we have: [OsloMet, Feelings]\n" +
                "at index: 8 we have: []\n" +
                "at index: 9 we have: [...So On, Age]\n";
    }
}
