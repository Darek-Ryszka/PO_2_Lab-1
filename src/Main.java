import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.Document;

class Product {
    // properties
    private int id;
    private double a; //cena
    private int x; //ilość
    private float p; //vat
    private double totalNetto;
    private double totalVAT;
    private double totalBrutto;


    // constructor
    Product(int id, double a, int x, float p, double totalNetto, double totalVAT, double totalBrutto) {
        this.id = id;
        this.a = a;
        this.x = x;
        this.p = p;
        this.totalNetto = totalNetto;
        this.totalVAT = totalVAT;
        this.totalBrutto = totalBrutto;
    }

    // getter methods
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

            int id = 0;
            float a = 0;
            int x = 0;
            float p = 0;
            float totalNetto = 0;
            float totalVAT = 0;
            float totalBrutto = 0;
            float overAllPriceNetto = 0;
            float overAllPriceVAT = 0;
            float overAllPriceBrutto = 0;

            Scanner scan = new Scanner(System.in);

            List<Product> product = new ArrayList<>();

            //menu
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

                        totalNetto = a * x;
                        totalVAT = (p / 100) * a * x;
                        totalBrutto = totalNetto + totalVAT;

                        id++;

                        product.add(new Product(id, a, x, p, totalNetto, totalVAT, totalBrutto));

                        overAllPriceNetto += totalNetto;
                        overAllPriceVAT += totalVAT;
                        overAllPriceBrutto += totalBrutto;
                        break;

                    case 2:
                        DefaultListModel<String> l1 = new DefaultListModel<>();

                        for (Product i : product){
                            l1.addElement("\n####################################");
                            l1.addElement("\n");
                            l1.addElement("\nProdukt: " +  i.getId());
                            l1.addElement("\nCena netto za sztukę: " +  String.format("%.2f",i.getCena()));
                            l1.addElement("\nWysokość stawki VAT w %: " +  String.format("%.2f",i.getVAT()));
                            l1.addElement("\nLiczba sztuk: " +  String.format("%d",i.getIlość()));
                            l1.addElement("\n");
                        }
                        l1.addElement("\n<<<<< PODSUMOWANIE RACHUNKU >>>>>");
                        l1.addElement("\n");
                        l1.addElement("\nWartość netto: " +  String.format("%.2f", overAllPriceNetto));
                        l1.addElement("\nWartość VAT: " +  String.format("%.2f", overAllPriceVAT));
                        l1.addElement("\n");
                        l1.addElement("\nWartość brutto: " +  String.format("%.2f", overAllPriceBrutto));
                        l1.addElement("\n");

                        JList<String> list = new JList<>(l1);

                        JTextArea tx = new JTextArea();
                        for (int i = 0; i < list.getModel().getSize(); i++ ) {
                            tx.append(list.getModel().getElementAt(i));
                        }

                        JScrollPane sc = new JScrollPane(tx);
                        tx.setLineWrap(true);
                        tx.setWrapStyleWord(true);
                        sc.setPreferredSize(new Dimension(260,400));

                        JOptionPane.showMessageDialog(null, sc, "Rachunek", JOptionPane.INFORMATION_MESSAGE );
//                        JOptionPane.showMessageDialog(null, list, "Rachunek", JOptionPane.INFORMATION_MESSAGE );
                        break;

                    case 3:
                        System.exit(0);

                    default:
                        JOptionPane.showMessageDialog(null, "Błędna wartość !!! Proszę wybrać numer 1,2 lub 3", "tytuł", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }