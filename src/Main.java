import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import javax.swing.JOptionPane;
import javax.swing.*;

//class Product {
//    // properties
//    private int id;
//    private double a; //cena
//    private int x; //ilość
//    private float p; //vat
//    private double totalNetto;
//    private double totalVAT;
//    private double totalBrutto;
//
//
//    // constructor
//    Product(int id, double a, int x, float p, double totalNetto, double totalVAT, double totalBrutto) {
//        this.id = id;
//        this.a = a;
//        this.x = x;
//        this.p = p;
//        this.totalNetto = totalNetto;
//        this.totalVAT = totalVAT;
//        this.totalBrutto = totalBrutto;
//    }
//
//    // getter methods
//    public int getId() {
//        return id;
//    }
//    public double getCena() {
//        return a;
//    }
//    public int getIlość() {
//        return x;
//    }
//    public float getVAT() {
//        return p;
//    }
//    public double getTotalNetto() {
//        return totalNetto;
//    }
//    public double getTotalVAT() {
//        return totalVAT;
//    }
//    public double getTotalBrutto() {
//        return totalBrutto;
//    }
//
//    // displayFormat
//    public static void displayFormat() {
//        System.out.print(
//                "\nID:      Cena:    Ilość:   VAT(%):   Całkowita wartość Netto:    Wartość podatku VAT:    Suma Brutto:    \n");
//    }
//
//    // display
//    public void display() {
//        System.out.format("%2d %10.2f %5d %2f %10.2f %10.2f %10.2f\n", id, a, x, p, totalNetto, totalVAT, totalBrutto);
//    }
//}

public class Main {

    public static void main(String[] args) {

        int id = 0;
        float a = 0;
        int x = 0;
        float p = 0;
        float totalNetto = 0;
        float totalVAT = 0;
        float totalBrutto = 0;

        Scanner scan = new Scanner(System.in);

//        List<Product> product = new ArrayList<Product>();

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
               case 1:
                   String value1 = JOptionPane.showInputDialog("Cena netto za sztukę: ");
                   a = Float.parseFloat(value1);

                   String value2 = JOptionPane.showInputDialog("Wysokość stawki VAT w %: ");
                   p = Float.parseFloat(value2);

                   String value3 = JOptionPane.showInputDialog("Liczba sztuk: ");
                   x = Integer.parseInt(value3);

                   totalNetto = a * x;
                   totalVAT = (p/100) * a * x;
                   totalBrutto = totalNetto + totalVAT;

                   id++;

//                   product.add(new Product(id, a, x, p, totalNetto, totalVAT, totalBrutto));

                   break;
                //method call or logic for case 1
                case 2:

                    JFrame f= new JFrame();
                    DefaultListModel<String> l1 = new DefaultListModel<>();
                    l1.addElement("ID produktu: " + id);
                    l1.addElement("Cena jednostkowa netto: " + String.valueOf(a));
                    l1.addElement("Wysokość VAT(%): " + p);
                    l1.addElement("Ilość: " + x);
                    l1.addElement("Wartość netto: " + totalNetto);
                    l1.addElement("Wartość VAT: " + totalVAT);
                    l1.addElement("Suma brutto: " + totalBrutto);
                    JList<String> list = new JList<>(l1);
                    list.setBounds(0,0, 400,400);
                    f.add(list);
                    f.setSize(800,800);
                    f.setLayout(null);
                    f.setVisible(true);

//                    Prawie działa

//                    for (int i = 0; i < product.size(); i++ ) {
//                    JOptionPane.showMessageDialog(null, "Produkt: " + id
//                    + "\nCena netto za sztukę: " + String.format("%2f",a)
//                    + "\nWysokość stawki VAT w %: " + String.format("%2f",p)
//                    + "\nLiczba sztuk: " + String.format("%d",x)
//                    + "\nWartość netto: " + String.format("%2f",totalNetto)
//                    + "\nWartość VAT: " + String.format("%2f",totalVAT)
//                    + "\nWartość brutto: " + String.format("%2f",totalBrutto),
//                    "Rachunek" ,JOptionPane.INFORMATION_MESSAGE);
//                    }

//                    Product.displayFormat();

//                    for (Product i : product) {
//                        i.display();
//                    }

//                    JFrame frame = new JFrame(); //creates a frame
//                    frame.setTitle("JFrame title goes here"); //sets title of frame
//                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
//                    frame.setResizable(false); //prevent frame from being resized
//                    frame.setSize(420,420); //sets the x-dimension, and y-dimension of frame
//                    frame.setVisible(true); //make frame visible
//                    frame.getContentPane().setBackground(new Color(255,255,255)); //change color of background


//                    JOptionPane optionPane = new NarrowOptionPane();
//                    optionPane.setMessage(product.get(0));
//                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
//                    JDialog dialog = optionPane.createDialog(null, "Width 100");
//                    dialog.setVisible(true);

//                    JFrame f= new JFrame();
//                    DefaultListModel<String> l1 = new DefaultListModel<>();
//                    product.add(new Product(id, a, x, p, totalNetto, totalVAT, totalBrutto));
//                    l1.addElement("Item1");
//                    l1.addElement("Item2");
//                    l1.addElement("Item3");
//                    l1.addElement("Item4");
//                    JList<Product> list = new JList<Product>();
//                    list.setBounds(100,100, 75,75);
//                    f.add(Product);
//                    f.
//                    f.setSize(400,400);
//                    f.setLayout(null);
//                    f.setVisible(true);

                    break;

                //method call or logic for case 2
                case 3:
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Błędna wartość !!! Proszę wybrać numer 1,2 lub 3", "tytuł", JOptionPane.PLAIN_MESSAGE);
//                    System.out.println("Błędna wartość !!! Proszę wybrać numer 1,2 lub 3");
            }
        }
    }
}