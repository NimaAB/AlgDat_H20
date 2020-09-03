package uke2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class NestMinMaxIndex {


    static int [] nestMaxIndex(int [] a){
        int n = a.length;
        if(n<2){
            throw new NoSuchElementException("Tabellen må være lengere enn 2");
        }
        int m_index=0;
        int nm_index=1;
        if(a[m_index]<a[nm_index]){
            nm_index = 0;
            m_index = 1;
        }
        int max = a[m_index];
        int nestMax=a[nm_index];

        for(int i=2;i<n;++i){
            if(a[i]>nestMax){
                if(a[i]>max){
                    nm_index = m_index;
                    nestMax = max;

                    m_index = i;
                    max = a[m_index];
                }else {
                    nm_index = i;
                    nestMax = a[nm_index];
                }
            }
        }
        return new int[] {m_index,nm_index};
    }
    static int [] nestMinIndex(int [] a){
        int n = a.length;
        if(n<2){
            throw new NoSuchElementException("Tabellen må være lengere enn 2");
        }
        int min_index=0;
        int nMin_index=1;
        if(a[min_index]>a[nMin_index]){
            min_index = 1;
            nMin_index = 0;
        }
        int nestMin = a[nMin_index];
        int min=a[min_index];

        for(int i=2;i<n;++i){
            if(a[i]<nestMin){
                if(a[i]<min){
                   nMin_index = min_index;
                   nestMin = min;

                   min_index = i;
                   min = a[min_index];
                }else {
                    nMin_index = i;
                    nestMin = a[i];
                }
            }
        }
        return new int[] {min_index,nMin_index};
    }
    static int max(int ... a){
        int max_index=0;
        for(int i = 1; i<a.length; ++i){
            if (a[max_index] < a[i]){
                max_index = i;
            }
        }
        return max_index;
    }
    static int min(int ... a){
        int min_index=0;
        for(int i = 1; i<a.length; ++i){
            if (a[min_index] > a[i]){
                min_index = i;
            }
        }
        return min_index;
    }

}
