import java.sql.SQLOutput;

public class Battlefield {
    public void PrintBattlefield (int[][] yourBattlefield, int[][] shelledBattlefield) {
        String letters = ("    A  B  C  D  E  F  G  H  I  J                A  B  C  D  E  F  G  H  I  J");
        System.out.println(letters);
        for (int i = 0; i < 10; i++) {
            if ((i + 1) != 10) {
                System.out.print((i + 1) + "  |");
            } else {
                System.out.print((i + 1) + " |");
            }
            for (int j = 0; j < yourBattlefield[i].length; j++) {
                if (yourBattlefield[i][j] == 0) {
                    System.out.print(" " + " |");
                } else if (yourBattlefield[i][j] == 1) {
                    System.out.print("A" + " |");
                } else if (yourBattlefield[i][j] == 2) {
                    System.out.print("*" + " |");
                } else if (yourBattlefield[i][j] == 3) {
                    System.out.print("D" + " |");
                } else if (yourBattlefield[i][j] == 4) {
                    System.out.print("#" + " |");
                }
            }
            if ((i + 1) != 10) {
                System.out.print("          " + (i + 1) + "  |");
            } else {
                System.out.print("          " + (i + 1) + " |");
            }
            for (int j = 0; j < shelledBattlefield[i].length; j++) {
                if (shelledBattlefield[i][j] == 0 || shelledBattlefield[i][j] == 1) {
                    System.out.print(" " + " |");
                } else if (shelledBattlefield[i][j] == 2) {
                    System.out.print("*" + " |");
                } else if (shelledBattlefield[i][j] == 3) {
                    System.out.print("D" + " |");
                } else if (shelledBattlefield[i][j] == 4) {
                    System.out.print("#" + " |");
                }
            }
            System.out.println();
        }
    }
}
