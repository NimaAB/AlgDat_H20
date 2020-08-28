package uke2;

public class NestStørst {

    static int nestStørst1(int[] a){
        //finner det minste tallet mellom to første elementene i arrayet, og sier at det er den nest største:
        int nestStørst = min(a[0],a[1]);
        //finner maks tall mellom de to elementene:
        int maksimum = max(a[0],a[1]);

        //loopen gjennom resterende elementer i arrayet.
        // loopen begynner fra index 2, pga. jeg har sjekket 0 og 1 i starten:
        for(int i=2;i<a.length;++i){
            //sjekker om tallet i index (i) er større enn nest størst tallet mitt fra starten:
            if(a[i]>nestStørst){
                //Hvis det er større så sjekker jeg om det er større en min maksimum:
                if(a[i]>maksimum){
                    //Hvis ja: så blir nest største tallet mitt forrige maksimum:
                    nestStørst = maksimum;
                    // Og masimum blir tallet i posisjonen (i):
                    maksimum = a[i];
                }else{
                    //Hvis det tallet i posisjonen (i) er ikke større enn min maksimum så
                    //blir nest største tallet det tallet med en gang.
                    nestStørst = a[i];
                }
            }
        }
        return nestStørst;
    }

    static int min(int ... a){
        int minimum = a[0];
        for(int i = 1; i<a.length;++i){
            if(a[i]<minimum){
                minimum = a[i];
            }
        }
        return minimum;
    }

    static int max(int ... a){
        int maksimum = a[0];
        for(int i = 1; i<a.length;++i){
            if(a[i]>maksimum){
                maksimum = a[i];
            }
        }
        return maksimum;
    }

}
