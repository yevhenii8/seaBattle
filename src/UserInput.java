import java.util.Scanner;

public class UserInput {
    int letter;
    int number;
    public int InputShipType () {
        Scanner scanner = new Scanner(System.in);
        int shipType = Integer.parseInt(scanner.nextLine());
        return shipType;
    }

    public int InputShipSide () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("In which direction do you want to place the ship?");
        System.out.println("1 - bottom");
        System.out.println("2 - right");
        int shipSide = Integer.parseInt(scanner.nextLine());
        return shipSide;
    }
    public void InputCoordinates () {
        Scanner scanner = new Scanner(System.in);
        String letters = ("ABCDEFGHIJ");
        String coordinates;
        coordinates = scanner.nextLine();
        for (int i = 0; i < letters.length(); i++) {
            if (coordinates.charAt(0) == letters.charAt(i)) {
                letter = i;
            }
        }
        number = Integer.parseInt(coordinates.substring(1)) - 1;
    }
}
