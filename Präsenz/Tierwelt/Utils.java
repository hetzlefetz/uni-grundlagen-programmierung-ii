
public class Utils {

	public static void printInfo(Tier tier) {

		switch (tier.getArt().toLowerCase()) {
			case "hund": {
				Hund hund = (Hund) tier;
				System.out.print("\nUtils: " + hund.toString());
				break;
			}
			case "vogel": {
				Vogel vogel = (Vogel) tier;
				System.out.print("\nUtils: " + vogel.toString());
				break;
			}
			case "tiger": {
				Großkatze tiger = (Großkatze) tier;
				System.out.print("\nUtils: " + tiger.toString());
				break;
			}
			case "fisch": {
				Fisch fisch = (Fisch) tier;
				System.out.print("\nUtils: " + fisch.toString());
				break;
			}
			default:
				System.out.print("\nUtils: Tier nicht bekannt");
		}
	}
}
