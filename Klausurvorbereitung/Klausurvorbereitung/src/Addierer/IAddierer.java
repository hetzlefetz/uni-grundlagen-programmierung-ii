package Addierer;

public interface IAddierer {
    /**
     * Die Methode berechnet die Summe der geparsten Zahlen. Die Summe wird
     * zurückgegeben. Im Falle eines Fehlers wird eine Ausnahme
     * NumberFormatException geworfen und 0 zurückgegeben.
     * 
     * @param number1 1. Zahl
     * @param number2 2. Zahl
     * @return Summe der zwei Zalhen beim erfolgreichen Parsen, sonst 0
     **/
    int rechnen(String number1, String number2);

}
