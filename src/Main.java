import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("::Welcome to Menu driven code::");

        //menu driven template
        while(true){
            System.out.println();
            System.out.println("****************************************");
            System.out.println("*                 MENU                 *");
            System.out.println("****************************************");
            System.out.println("[1] Dodaj produkt");
            System.out.println("[2] Wyświetl rachunek końcowy");
            System.out.println("[3] Wyjdź");
            System.out.println();

            System.out.println("Wybrano opcję: ");
            int choice = scan.nextInt();//accept user input

            switch (choice) {
                case 1 -> System.out.println("I am case 1");

                //method call or logic for case 1
                case 2 -> System.out.println("I am case 2");

                //method call or logic for case 2
                case 3 -> {
                    System.out.println("Zamykanie aplikacji");
                    System.exit(0);
                }
                default -> System.out.println("Błędna wartość !!! Proszę wybrać numer 1,2 lub 3");
            }
        }

//       JOptionPane.showMessageDialog(null, "Coś", "tytuł", JOptionPane.PLAIN_MESSAGE);
    }
}