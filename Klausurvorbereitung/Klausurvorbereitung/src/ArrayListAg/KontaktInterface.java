package ArrayListAg;

public interface KontaktInterface {
    String getName();

    void setName(String vorname);

    String getTelefon();

    void setTelefon(String telefon);

    default void printName() {
        System.out.println(getName() + " " + getTelefon());
    }
}