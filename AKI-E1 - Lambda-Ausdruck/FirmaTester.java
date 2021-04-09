
import java.util.Arrays;



public class FirmaTester {

    /**
     * Main-Methode.
     * 
     * @param args Uebergabeparameter
     */
    public static void main(String[] args) {
        Firma kmu = new Firma(4, "Java4You");
        Angestellte ang1 = new Angestellte("Taylor", "Elisabeth", "Amrummer Strasse", "10", "Hamburg", "13353", true,
                410000f);
        kmu.addAngestellte(ang1);
        System.out.println("Sort 1");
        System.out.println("Sort By OrtPlz");
        Arrays.sort(kmu.getAllePersonen(), new OrtPlzSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Ort");
        Arrays.sort(kmu.getAllePersonen(), new OrtSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Plz");
        Arrays.sort(kmu.getAllePersonen(), new PlzSorter(true));
        kmu.alleAdressenAusgeben();
       
        Angestellte ang2 = new Angestellte("Mueller", "Mark", "Amrummer Strasse", "11", "Berlin", "13353", false,
                10000f);
        kmu.addAngestellte(ang2);
        System.out.println("Sort 2");
        System.out.println("Sort By OrtPlz");
        Arrays.sort(kmu.getAllePersonen(), new OrtPlzSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Ort");
        Arrays.sort(kmu.getAllePersonen(), new OrtSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Plz");
        Arrays.sort(kmu.getAllePersonen(), new PlzSorter(true));
        kmu.alleAdressenAusgeben();
        Kunde k1 = new Kunde("Cruise", "Tom", "Amrummer Strasse", "12", "Frankfurt", "13353", false);
        kmu.addKunde(k1);
        System.out.println("Sort 3");
        System.out.println("Sort By OrtPlz");
        Arrays.sort(kmu.getAllePersonen(), new OrtPlzSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Ort");
        Arrays.sort(kmu.getAllePersonen(), new OrtSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Plz");
        Arrays.sort(kmu.getAllePersonen(), new PlzSorter(true));
        kmu.alleAdressenAusgeben();
        Kunde k2 = new Kunde("Jolie", "Angelina", "Amrummer Strasse", "13", "Nizza", "13354", true);
        System.out.println("Sort 4");
        System.out.println("Sort By OrtPlz");
        Arrays.sort(kmu.getAllePersonen(), new OrtPlzSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Ort");
        Arrays.sort(kmu.getAllePersonen(), new OrtSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Plz");
        Arrays.sort(kmu.getAllePersonen(), new PlzSorter(true));
        kmu.alleAdressenAusgeben();
       
        Kunde k3 = new Kunde("Deneuve", "Catherine", "Amrummer Strasse", "14", "Paris", "13353", true);
        // should not be possible
        kmu.addKunde(k3);
        System.out.println("Sort 4");
        System.out.println("Sort By OrtPlz");
        Arrays.sort(kmu.getAllePersonen(), new OrtPlzSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Ort");
        Arrays.sort(kmu.getAllePersonen(), new OrtSorter(true));
        kmu.alleAdressenAusgeben();
        System.out.println("Sort By Plz");
        Arrays.sort(kmu.getAllePersonen(), new PlzSorter(true));
        kmu.alleAdressenAusgeben();
      

    }

}
