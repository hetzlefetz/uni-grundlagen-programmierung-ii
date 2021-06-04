/**
 * Main
 */
public class Main {

    static final int LAB_SIZE = 10;
    static final int STARTX = Math.floorDiv(LAB_SIZE, 2);
    static final int STARTY = Math.floorDiv(LAB_SIZE, 2);

    static final char[][] LAB_1 = new char[][] { { 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

    static final char[][] LAB_2 = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', ' ', 'X', ' ', ' ', 'X', 'X', 'X', 'X' },
            { ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X' }, };

    static char[][] labyrinth = null;

    static char[][] makeLabyrinth(int size) {
        var result = new char[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (Math.random() > 0.5) {
                    result[x][y] = 'X';
                } else {
                    result[x][y] = ' ';
                }
            }
        }
        if (result[STARTX][STARTY] == 'X') {
            // at least ha a valid start
            return makeLabyrinth(size);
        }
        return result;

    }

    static void printLab(char[][] labyrinth) {
        var sb = new StringBuilder();
        for (int y = 0; y < labyrinth.length; y++) {
            sb.append(new String(labyrinth[y]));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    static boolean traverse(Integer currentX, Integer currentY, char[][] labyrinth) {
        if (currentX == null && currentY == null) {
            currentX = STARTX;
            currentY = STARTY;
        }
        if (currentX >= LAB_SIZE || currentY >= LAB_SIZE)
            return false;// out of bounds

        if (labyrinth[currentX][currentY] == 'X' || labyrinth[currentX][currentY] == '*')
            return false; // ran into a wall

        labyrinth[currentX][currentY] = '*';

        if (currentX == 0 || currentX == LAB_SIZE)
            return true; // reached left or right exit
        if (currentY == 0 || currentY == LAB_SIZE)
            return true; // reached top or bottom exit

        return traverse(currentX - 1, currentY, labyrinth) || traverse(currentX + 1, currentY, labyrinth)
                || traverse(currentX, currentY - 1, labyrinth) || traverse(currentX, currentY + 1, labyrinth);

    }

    public static void main(String[] args) {

        var lab = makeLabyrinth(LAB_SIZE);
        System.out.println("Is random traversable: " + traverse(null, null, lab));
        printLab(lab);
        System.out.println("Is Lab1 traversable: " + traverse(null, null, LAB_1));
        printLab(LAB_1);
        System.out.println("Is Lab2 traversable: " + traverse(null, null, LAB_2));
        printLab(LAB_2);

    }
}