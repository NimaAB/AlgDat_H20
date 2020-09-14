package uke4;

public class Person implements Comparable<Person>{
    private String first_name;
    private String last_name;
    public Person(String fn, String ln){
        this.first_name=fn;
        this.last_name=ln;
    }

    @Override
    public int compareTo(Person o) {
        int lastCompare = this.last_name.compareTo(o.last_name);
        if(lastCompare==0){
            return this.first_name.compareTo(o.first_name);
        }else{
            return lastCompare;
        }
    }
}
