
public class Tierwelt {

	public Tierwelt() {

		Tier hund = new Hund("Hund", 3, false, "bellt", "Freddy");
		Tier vogel = new Vogel("Vogel", 5, false, "piept", "Lili");
		Tier fisch = new Fisch("Fisch", 10, false, "blubbert");
		Tier tiger = new Großkatze("Tiger", 4, true, "br�llt");

		// Hund hund = new Hund("hund", -3, false, "bellt", "Freddy");
		// Vogel vogel = new Vogel("vogel", 5, false, "piep", "Lili");
		// Fisch fisch = new Fisch("fisch", 10, false, "blubbert");
		// Tiger tiger = new Tiger("tiger", 4, true, "br�llt");

		System.out.println();

		// System.out.println(hund.toString());
		// System.out.println(vogel.toString());
		// System.out.println(fisch.toString());
		// System.out.println(tiger.toString());

		// 1. M�glichkeit Array: Deklaration
		// Tier[] aTier = new Tier[4];
		//
		// // Initialisierung
		// aTier[0] = hund;
		// aTier[1] = vogel;
		// aTier[2] = fisch;
		// aTier[3] = tiger;

		// 2. M�glichkeit Array: Deklaration und Initialisierung
		Tier[] aTier = { hund, vogel, fisch, tiger };

		// // 1. M�glichkeit: Array durchlaufen
		// for(int i = 0; i < aTier.length; i++)
		// System.out.println(aTier[i].toString());

		// 2. M�glichkeit: Array durchlaufen
		for (Tier tier : aTier) {
			System.out.println(tier.toString());
		}

		// Beispiel statische Methode
		Utils.printInfo(hund);
		Utils.printInfo(vogel);
		Utils.printInfo(fisch);
		Utils.printInfo(tiger);
	}

	public static void main(String[] args) {
		new Tierwelt();
	}

}
