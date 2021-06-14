
public class Labyrinth {
	static char[][] laby = new char[][] { { 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', ' ', ' ', 'X', 'X', ' ', 'X', 'X', ' ' }, { 'X', 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X' },
			{ 'X', 'X', ' ', ' ', 'X', ' ', ' ', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X' },
			{ 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X', 'X' }, { 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' }, { 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	static int startReihe = 5;
	static int startSpalte = 4;

	static void printLab(char[][] labyNeu) {
		for (int m = 0; m < labyNeu.length; m++) {
			for (int n = 0; n < labyNeu[m].length; n++) {
				System.out.print(labyNeu[m][n]);
			}
			System.out.println();
		}
	}

	static void labyWeg(int i, int j, char[][] labyNeu) {
		printLab(labyNeu);
		if (i == startReihe && j == startSpalte) {
			labyNeu[i][j] = '*';
		}
		if (i == 0 || j == 0 || i == 9 || j == 9) {
			printLab(labyNeu);
			return;
		}

		else {
			if (labyNeu[i - 1][j] == ' ' || labyNeu[i + 1][j] == ' ' || labyNeu[i][j - 1] == ' '
					|| labyNeu[i][j + 1] == ' ') {

				int zähler = 0;
				int posiI = -1;
				int posiJ = -1;

				if (labyNeu[i - 1][j] == ' ') {
					zähler++;
					posiI = i - 1;
				}
				if (labyNeu[i + 1][j] == ' ') {
					zähler++;
					posiI = i + 1;
				}
				if (labyNeu[i][j - 1] == ' ') {
					zähler++;
					posiJ = j - 1;
				}
				if (labyNeu[i][j + 1] == ' ') {
					zähler++;
					posiJ = j + 1;
				}

				// Hier gehst du immer nur nach unten oder rechts
				if (zähler == 1) {
					if (posiI > -1) {
						labyNeu[posiI][j] = '*';
						labyWeg(posiI, j, labyNeu);
					} else if (posiJ > -1) {
						labyNeu[i][posiJ] = '*';
						labyWeg(i, posiJ, labyNeu);
					}
				} else if (zähler > 1) {
					int randomPosi = (int) Math.floor((Math.random() * zähler));

					int zählerPosi = 0;
					int oben = 0;
					int unten = 0;
					int links = 0;
					int rechts = 0;

					if (labyNeu[i - 1][j] == ' ') {
						zählerPosi++;
						oben = zählerPosi;
					}
					if (labyNeu[i + 1][j] == ' ') {
						zählerPosi++;
						unten = zählerPosi;
					}
					if (labyNeu[i][j - 1] == ' ') {
						zählerPosi++;
						links = zählerPosi;
					}
					if (labyNeu[i][j + 1] == ' ') {
						zählerPosi++;
						rechts = zählerPosi;
					}
					System.out.println((i - 1) + "," + (i + 1) + "," + (j - 1) + "," + (j + 1) + "," + randomPosi);
					if (oben == randomPosi) {
						labyNeu[i - 1][j] = '*';

						labyWeg(i - 1, j, labyNeu);
					} else if (unten == randomPosi) {
						labyNeu[i + 1][j] = '*';
						labyWeg(i + 1, j, labyNeu);
					} else if (links == randomPosi) {
						labyNeu[i][j - 1] = '*';
						labyWeg(i, j - 1, labyNeu);
					} else if (rechts == randomPosi) {
						labyNeu[i][j + 1] = '*';
						labyWeg(i, j + 1, labyNeu);
					}
				}

			} else {
				labyWeg(startReihe, startSpalte, laby);
			}
		}
	}

	public static void main(String[] args) {
		labyWeg(startReihe, startSpalte, laby);
	}
}
