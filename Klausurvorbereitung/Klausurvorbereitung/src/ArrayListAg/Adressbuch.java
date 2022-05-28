package ArrayListAg;

import java.util.ArrayList;

public class Adressbuch {

    ArrayList<Kontakt> list;

    public Adressbuch() {
        list = new ArrayList<Kontakt>();

    }

    // Kontakt zur ArrayList addressBook hinzufügen
    public void add(String name, String number) {
        list.add(new Kontakt(name, number));
    }

    public void rem(String name, String number) {
        for (var i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getName() == name && list.get(i).getTelefon() == number) {
                list.remove(i);
            }
        }
    }

    public void sortByName() {
        for (var c : list) {
            c.printName();
        }
        list.sort((v1, v2) -> -1 * v1.getName().compareTo(v2.getName()));
        var foo = list.stream().filter(x -> x.getName() == "Jannika").toArray();
        for (var c : foo) {
            ((Kontakt) c).printName();
        }

        var res = new ArrayList<Kontakt>();
        for (var c : list) {
            if (c.getName() == "Jannika") {
                res.add(c);
                c.printName();
            }
        }

    }

    // In addressBook den Name oldName durch den Namen newName ersetzen
    // und die Anzahl der veränderten Kontakte zurückgeben
    public int changeAll(String oldName, String newName) {
        var numberChanged = 0;
        for (Kontakt k : list) {
            if (k.getName() == oldName) {
                k.setName(newName);
                numberChanged++;
            }
        }
        return numberChanged;
    }

    public static void main(String[] args) {
        var ab = new Adressbuch();
        ab.add("Jannika", "0621 45041237");
        ab.add("Denny", "040-45041235");
        ab.add("Benjamin", "030-45041234");
        ab.add("Diana", "030 45041236");
        ab.add("Denny", "040 1235");

        // System.out.println(ab.changeAll("Denny", "Pommes"));
        ab.rem("Denny", "040-45041235");
        ab.sortByName();
    }
}
