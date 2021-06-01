public class Kontakt {

    public static enum KontaktTyp {
        privat, geschaeftlich
    }

    private String id;
    private KontaktTyp typ;
    private String nachname;
    private String vorname;
    private String strasse;
    private String plz;
    private String ort;
    private String land;

    public Kontakt(String pId, KontaktTyp pTyp, String pNachname,
            String pVorname, String pStrasse, String pPlz, String pOrt,
            String pLand) {
        setId(pId);
        setTyp(pTyp);
        setNachname(pNachname);
        setVorname(pVorname);
        setStrasse(pStrasse);
        setPlz(pPlz);
        setOrt(pOrt);
        setLand(pLand);
    }

    public Kontakt(KontaktTyp pTyp, String pNachname, String pVorname,
            String pStrasse, String pPlz, String pOrt, String pLand) {

        this(null, pTyp, pNachname, pVorname, pStrasse, pPlz, pOrt, pLand);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KontaktTyp getTyp() {
        return typ;
    }

    public void setTyp(KontaktTyp typ) {
        this.typ = typ;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String name) {
        this.nachname = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
	@Override
    public String toString() {
	return ("(" + id + ", " + typ.toString() + ", " + vorname + ", "
	        + nachname + ", " + strasse + ", " + plz + ", " + ort + ", "
	        + land + ")");
    }
}
