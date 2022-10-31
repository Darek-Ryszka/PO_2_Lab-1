import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

class Product {
    // Właściwości klasy
    private int id;
    private double a; //cena
    private int x; //ilość
    private float p; //vat
    private double totalNetto;
    private double totalVAT;
    private double totalBrutto;


    // Konstruktor
    Product(int id, double a, int x, float p, double totalNetto, double totalVAT, double totalBrutto) {
        this.id = id;
        this.a = a;
        this.x = x;
        this.p = p;
        this.totalNetto = totalNetto;
        this.totalVAT = totalVAT;
        this.totalBrutto = totalBrutto;
    }

    // Metody getter
    public int getId() {
        return id;
    }

    public double getCena() {
        return a;
    }

    public int getIlość() {
        return x;
    }

    public float getVAT() {
        return p;
    }

    public double getTotalNetto() {
        return totalNetto;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public double getTotalBrutto() {
        return totalBrutto;
    }
}

    public class Main {

        public static void main(String[] args) {

            // Deklaracja zmiennych

            int id = 0; // Numer produktu
            float a = 0; // Cena netto za sztukę
            int x = 0; // Liczba sztuk produktu
            float p = 0; // Wysokość stawki VAT
            float totalNetto = 0;
            float totalVAT = 0;
            float totalBrutto = 0;
            float overAllPriceNetto = 0;
            float overAllPriceVAT = 0;
            float overAllPriceBrutto = 0;

            Scanner scan = new Scanner(System.in);

            // Zadeklarowanie nowej listy obiektów
            List<Product> product = new ArrayList<>();

            // Menu bazujące na switch-ach, zawarte w pętli while
            while (true) {
                System.out.println();
                System.out.println("****************************************");
                System.out.println("*                 MENU                 *");
                System.out.println("****************************************");
                System.out.println("[1] Dodaj produkt");
                System.out.println("[2] Wyświetl rachunek końcowy");
                System.out.println("[3] Wyjdź");
                System.out.println();

                System.out.println("Wybrano opcję: ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        String value1 = JOptionPane.showInputDialog("Cena netto za sztukę: ");
                        a = Float.parseFloat(value1);

                        String value2 = JOptionPane.showInputDialog("Wysokość stawki VAT w %: ");
                        p = Float.parseFloat(value2);

                        String value3 = JOptionPane.showInputDialog("Liczba sztuk: ");
                        x = Integer.parseInt(value3);

                        totalNetto = a * x; // Cena netto za sztukę, pomnożona przez liczbę sztuk na rachunku
                        totalVAT = (p / 100) * a * x; // Wysokość stawki VAT obliczona na podstawie ceny netto za sztukę, przemnożonej przez ilość sztuk
                        totalBrutto = totalNetto + totalVAT; // Wyskość ceny brutto produktu

                        id++; // Inkrementacja id produktu

                        product.add(new Product(id, a, x, p, totalNetto, totalVAT, totalBrutto)); // Dodanie (obiektu) produktu do listy "product"

                        overAllPriceNetto += totalNetto; // Sumownaie całkowietej wartości netto dla wszystkich produktów na rachunku
                        overAllPriceVAT += totalVAT; // Sumownaie całkowietej wartości VAT dla wszystkich produktów na rachunku
                        overAllPriceBrutto += totalBrutto; // Sumownaie całkowietej wartości brutto dla wszystkich produktów na rachunku
                        break;

                    case 2:
                        // Tworzenie listy zawierającej elementy typu String dla każdego elementu obiektu stworzonego na podstawie klasy "Product"
                        DefaultListModel<String> l1 = new DefaultListModel<>();

                        // Pętla iterująca po każdym elemencie i każdym obiekcie na liście "product" i dodająca dane do list l1 typu String
                        for (Product i : product){
                            l1.addElement("\n####################################");
                            l1.addElement("\n");
                            l1.addElement("\nProdukt: " +  i.getId());
                            l1.addElement("\nCena netto za sztukę: " +  String.format("%.2f",i.getCena()));
                            l1.addElement("\nWysokość stawki VAT w %: " +  String.format("%.2f",i.getVAT()));
                            l1.addElement("\nLiczba sztuk: " +  String.format("%d",i.getIlość()));
                            l1.addElement("\n");
                        }
                        // Dane wyświetlane poza pętlą, dla całego rachunku
                        l1.addElement("\n<<<<< PODSUMOWANIE RACHUNKU >>>>>");
                        l1.addElement("\n");
                        l1.addElement("\nWartość netto: " +  String.format("%.2f", overAllPriceNetto));
                        l1.addElement("\nWartość VAT: " +  String.format("%.2f", overAllPriceVAT));
                        l1.addElement("\n");
                        l1.addElement("\nWartość brutto: " +  String.format("%.2f", overAllPriceBrutto));
                        l1.addElement("\n");

                        // Tworzenie JListy z elementami typu String w celu dodania zawartośći do JTextArea i możliwości iteracji
                        JList<String> list = new JList<>(l1);

                        // Stworzenie pola tekstowego, iteracja po obiektach i elementach tych obiektów w zależności od długości listy i dodanie ich do pola tekstowego
                        JTextArea tx = new JTextArea();
                        for (int i = 0; i < list.getModel().getSize(); i++ ) {
                            tx.append(list.getModel().getElementAt(i));
                        }

                        // Dodanie stałych wymiarów okna podsumowania rachunku i suwaka w przypadku przekroczenia możliwości wyświetlenia danych w polu tekstowym
                        JScrollPane sc = new JScrollPane(tx);
                        tx.setLineWrap(true);
                        tx.setWrapStyleWord(true);
                        sc.setPreferredSize(new Dimension(260,400));

                        // Wyświetlenie wiadomości
                        JOptionPane.showMessageDialog(null, sc, "Rachunek", JOptionPane.INFORMATION_MESSAGE );
                        break;

                    case 3:
                        // Wyjście z programu
                        System.exit(0);

                    default:
                        // Informacja o niewłaściwym numerze podanym w menu
                        JOptionPane.showMessageDialog(null, "Błędna wartość !!! Proszę wybrać numer 1,2 lub 3", "Niewłaściwa wartość", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }