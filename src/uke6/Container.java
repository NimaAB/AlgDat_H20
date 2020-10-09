package uke6;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public interface Container<E> extends Iterable<E> {
    Iterator<E> iterator();
    Iterator<E> iterator(int index);


    default boolean removeIf(Predicate<? super E> p)  // betingelsesfjerning
    {
        Objects.requireNonNull(p);                       // kaster unntak

        boolean fjernet = false;
        for (Iterator<E> i = iterator(); i.hasNext(); )  // løkke
        {
            if (p.test(i.next()))                          // betingelsen
            {
                i.remove();                                  // fjerner
                fjernet = true;                              // minst en fjerning
            }
        }
        return fjernet;
    }

}
