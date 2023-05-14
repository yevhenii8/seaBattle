import java.awt.font.FontRenderContext;

public class SetShip {
    Battlefield bf = new Battlefield();
    public void ChoiceShipType (boolean[] ships) {
        System.out.println("Which ship do you want to place?");
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == false) {
                switch (i) {
                    case 0:
                        System.out.println("1 - battleship");
                        break;
                    case 1:
                        System.out.println("2 - Cruiser");
                        break;
                    case 2:
                        System.out.println("3 - Destroyer");
                        break;
                    case 3:
                        System.out.println("4 - Torpedo boat");
                        break;
                }
            }
        }
    }
    public boolean CheckShipType (int shipType , boolean[] ships) {
        if ((shipType > 4 || shipType < 1) || (ships[shipType - 1] == true)) {
            System.out.println("Wrong ShipType");
            return false;
        }
        return true;
    }

    public boolean CheckShipSide (int shipSide) {
        if (shipSide > 2 || shipSide < 1) {
            System.out.println("Wrong ShipSide");
            return false;
        }
        return true;
    }

    public boolean CheckCoordinates (int[][] yourBattlefield, int shipType,int shipSide, int number, int letter) {
        if (shipSide == 0) {
            if ((number > 9 || number < 0 || letter > 9 || letter < 0)) {
                System.out.println("Wrong coordinates");
                return false;
            }
            for (int i = (number - 1); i <= (number + 1); i++) {
                for (int j = (letter - 1); j <= (letter + 1); j++) {
                    if (i > 9 || i < 0 || j > 9 || j < 0) {

                    } else if ((yourBattlefield[i][j] == 1) && (i != number || j != letter)) {
                        System.out.println("Wrong coordinates");
                        return false;
                    }
                }
            }
        }
        if (shipSide == 1) {
            if ((number + (4 - shipType) > 9 || number < 0 || letter > 9 || letter < 0)) {
                System.out.println("Wrong coordinates");
                return false;
            }
            for (int i = (number - 1); i <= (number + (5 - shipType)); i++) {
                for (int j = (letter - 1); j <= (letter + 1); j++) {
                    if (i > 9 || i < 0 || j > 9 || j < 0) {

                    } else if ((yourBattlefield[i][j] == 1) && (i != number || j != letter)) {
                        System.out.println("Wrong coordinates");
                        return false;
                    }
                }
            }
        } else if (shipSide == 2) {
            if ((number > 9 || number < 0 || letter + (4 - shipType) > 9 || letter < 0)) {
                System.out.println("Wrong coordinates");
                return false;
            }
            for (int i = (number - 1); i <= (number + 1); i++) {
                for (int j = (letter - 1); j <= (letter + (5 - shipType)); j++) {
                    if (i > 9 || i < 0 || j > 9 || j < 0) {

                    } else if (yourBattlefield[i][j] == 1 && (i != number || j != letter)) {
                        System.out.println("Wrong coordinates");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean SetShip (int[][] yourBattlefield, boolean[] ships, int shipType, int shipSide, int number, int letter) {
        if (shipSide == 0) {
            yourBattlefield[number][letter] = 1;
        }
        if (shipSide == 1) {
            for (int i = number; i <= (number + (4 - shipType)); i++) {
                yourBattlefield[i][letter] = 1;
            }
        } else if (shipSide == 2) {
            for (int i = letter; i <= (letter + (4 - shipType)); i++) {
                yourBattlefield[number][i] = 1;
            }
        }
        ships[shipType - 1] = true;
        System.out.println("Ship is set");
        return true;
    }
}
