public class FireShip {

    public boolean CheckCoordinates (int[][] shelledBattlefield, int number, int letter) {
        if ((number > 9 || number < 0 || letter > 9 || letter < 0)) {
            System.out.println("Wrong coordinates");
            return false;
        } else if (shelledBattlefield[number][letter] > 1) {
            System.out.println("Wrong coordinates");
            return false;
        }
        return true;
    }
    public boolean FireShip (int[][] shelledBattlefield, int number, int letter) {
        switch (shelledBattlefield[number][letter]) {
            case 0: {
                shelledBattlefield[number][letter] = 4;
                System.out.println("Miss");
                return false;
            }
            case 1: {
                for (int i = (number - 1); i <= (number + 1); i++) {
                    for (int j = (letter - 1); j <= (letter + 1); j++) {
                        if (i > 9 || i < 0 || j > 9 || j < 0) {

                        } else if ((shelledBattlefield[i][j] == 1 || shelledBattlefield[i][j] == 2) && (i != number || j != letter)) {
                            int intactShipDecks = 0;
                            int shipLength = 0;
                            int bowOfStern = 0;
                            if (i != number) {
                                for (int k = i; bowOfStern == 0; k++) {
                                    if (k == 9 ||shelledBattlefield[k + 1][letter] == 0) {
                                        bowOfStern = k;
                                        for (int l = k; ((l + 1) != 0) && (shelledBattlefield[l][letter] == 1 || shelledBattlefield[l][letter] == 2); l--) {
                                            shipLength++;
                                            if (shelledBattlefield[l][letter] == 1) {
                                                intactShipDecks++;
                                            }
                                        }
                                    }
                                }
                            } else if (j != letter) {
                                for (int k = j; bowOfStern == 0; k++) {
                                    if (k == 9 ||shelledBattlefield[number][k + 1] == 0) {
                                        bowOfStern = k;
                                        for (int l = k; ((l + 1) != 0) && (shelledBattlefield[number][l] == 1 || shelledBattlefield[number][l] == 2); l--) {
                                            shipLength++;
                                            if (shelledBattlefield[number][l] == 1) {
                                                intactShipDecks++;
                                            }
                                        }
                                    }
                                }
                            } if (intactShipDecks > 1) {
                                shelledBattlefield[number][letter] = 2;
                                System.out.println("hit");
                                return true;
                            } else {
                                if (i != number) {
                                    for (int k = (bowOfStern + 1); k != (bowOfStern - shipLength - 1); k--) {
                                        for (int l = (letter + 1); l >= (letter - 1); l--) {
                                            if (k > 9 || k < 0 || l > 9 || l < 0) {

                                            } else if (shelledBattlefield[k][l] == 1 || shelledBattlefield[k][l] == 2) {
                                                shelledBattlefield[k][l] = 3;
                                            } else {
                                                shelledBattlefield[k][l] = 4;
                                            }
                                        }
                                    }
                                } else if (j != letter) {
                                    for (int k = (bowOfStern + 1); k != (bowOfStern - shipLength - 1); k--) {
                                        for (int l = (number + 1); l >= (number - 1); l--) {
                                            if (k > 9 || k < 0 || l > 9 || l < 0) {

                                            } else if (shelledBattlefield[l][k] == 1 || shelledBattlefield[l][k] == 2) {
                                                shelledBattlefield[l][k] = 3;
                                            } else {
                                                shelledBattlefield[l][k] = 4;
                                            }
                                        }
                                    }
                                }
                            }
                            System.out.println("Destroyed");
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
