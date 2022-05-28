package ArrayListAg;

public class Kontakt implements KontaktInterface {
    private String vorname;
    private String telefon;

    public Kontakt(String vorname, String telefon) {
        this.vorname = vorname;
        this.telefon = telefon;
    }

    @Override
    public String getName() {
        return vorname;
    }

    @Override
    public void setName(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String getTelefon() {
        return telefon;
    }

    @Override
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    // public void printKontakt() {
    // System.out.println(this.vorname + " + " + this.telefon);
    // }

}
