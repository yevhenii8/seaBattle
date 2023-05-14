public class Demo {
    public static void main(String[] args) {
        UserInput ui = new UserInput();
        SetShip ss = new SetShip();
        FireShip fs = new FireShip();
        Battlefield bf = new Battlefield();

        int[][] firstBattlefield = new int[10][10];
        int[][] secondBattlefield = new int[10][10];
        int[][] shelledBattlefield;
        int[][] yourBattlefield;
        int mainSideChangeCounter = 0;
        int firstPlayerDecks = 20;
        int secondPlayerDecks = 20;

        while (true) {
            for (int secondarySideChangeCounter = 0; secondarySideChangeCounter < 2; secondarySideChangeCounter++) {
                boolean[] ships = new boolean[4];
                 if (secondarySideChangeCounter == 0) {
                     yourBattlefield = firstBattlefield;
                     shelledBattlefield = secondBattlefield;
                 } else {
                     yourBattlefield = secondBattlefield;
                     shelledBattlefield = firstBattlefield;
                 }
                for (int i = 0; i < ships.length;) {
                    ss.ChoiceShipType(ships);
                    int shipType = ui.InputShipType();
                    if (ss.CheckShipType(shipType, ships)) {
                        for (int j = 0; j < shipType;) {
                            int shipSide = 0;
                            if (shipType != 4) {
                                shipSide = ui.InputShipSide();
                            }
                            if (shipType == 4 || ss.CheckShipSide(shipSide)) {
                                bf.PrintBattlefield(yourBattlefield, shelledBattlefield);
                                System.out.println("where do you want to place the ship?");
                                ui.InputCoordinates();
                                int number = ui.number;
                                int letter = ui.letter;
                                if (ss.CheckCoordinates(yourBattlefield, shipType, shipSide, number, letter)) {
                                    if(ss.SetShip(yourBattlefield, ships, shipType, shipSide, number , letter)) {
                                        j++;
                                    }
                                }
                            }
                            bf.PrintBattlefield(yourBattlefield, shelledBattlefield);

                        }
                        i++;
                    }
                }
                if (secondarySideChangeCounter == 0) {
                    firstBattlefield = yourBattlefield;
                } else {
                    secondBattlefield = yourBattlefield;
                }
            }
            while (true) {
                if (mainSideChangeCounter % 2 == 0) {
                    shelledBattlefield = secondBattlefield;
                    yourBattlefield = firstBattlefield;
                } else {
                    shelledBattlefield = firstBattlefield;
                    yourBattlefield = secondBattlefield;
                }
                bf.PrintBattlefield(yourBattlefield, shelledBattlefield);
                System.out.println("where do you want to shoot");
                ui.InputCoordinates();
                int number = ui.number;
                int letter = ui.letter;
                if (fs.CheckCoordinates(shelledBattlefield, number, letter)) {
                    if (fs.FireShip(shelledBattlefield, number, letter)) {
                        if (mainSideChangeCounter % 2 == 0) {
                            secondPlayerDecks--;
                        } else {
                            firstPlayerDecks--;
                        }
                    } else {
                        mainSideChangeCounter++;
                    }
                    bf.PrintBattlefield(yourBattlefield, shelledBattlefield);
                }
                if (secondPlayerDecks == 0) {
                    System.out.println("First player win");
                    return;
                } else if (firstPlayerDecks == 0) {
                    System.out.println("Second player win");
                    return;
                }
            }
        }
    }
}
