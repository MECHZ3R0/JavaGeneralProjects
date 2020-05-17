package product_inventory;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class InventoryOperations {
    public static int k=0;
    public static void insertItems (String path) throws Exception{
        FileWriter write = new FileWriter(path);
        Scanner scan = new Scanner(System.in);
        String item="id\t\tproduct\t\tprice\t\tquantity\n__\t\t_______\t\t_____\t\t________\n";
        String answer;
        do {
            System.out.print("Product id: ");
            item+=scan.nextLine()+"\t\t";
            System.out.print("Product name: ");
            item+=scan.nextLine()+"\t\t";
            System.out.print("Product price: ");
            item+=scan.nextLine()+"\t\t";
            System.out.print("Product quantity: ");
            item+=scan.nextLine()+"\n";
            System.out.println("Do you want to add another product? (Y/N) ");
            answer=scan.nextLine();
            while(true){
                if(answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("n")){
                    break;
                }
                System.out.println("Please enter Y or N for adding another product: ");
                answer=scan.nextLine();
            }
        }
        while (answer.equalsIgnoreCase("y"));
        write.write(item);
        scan.close();
        write.close();
    }
    public static ArrayList<ArrayList<String>> listInventory(String path) throws Exception{
        File read = new File(path);
        Scanner scan = new Scanner(read);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        while(scan.hasNext()){
            list.add(new ArrayList<>());
            for (int i = 0; i < 4; i++) {
                list.get(k).add(scan.next());
            }
            k++;
        }
        return list;
    }
    public static void listInventory(ArrayList<ArrayList<String>> list, String product){
        System.out.println(list.get(0).get(0)+"\t\t"+list.get(0).get(1)+"\t\t"+list.get(0).get(2)+"\t\t"+list.get(0).get(3)+"\t\t");
        System.out.println(list.get(1).get(0)+"\t\t"+list.get(1).get(1)+"\t\t"+list.get(1).get(2)+"\t\t"+list.get(1).get(3)+"\t\t");
        Iterator<String> itr;
        String connector="";
        String control;
        for (int i = 2; i < k; i++) {
            itr = list.get(i).iterator();
            while(itr.hasNext()){
                control=itr.next();
                if (control.equalsIgnoreCase(product)) {
                    connector+=list.get(i).get(0)+"\t\t";
                    connector+=control+"\t\t";
                    for (int j = 0; j < 3; j++) {
                        if(itr.hasNext()){
                            control=itr.next();
                            connector+=control+"\t\t";
                        }
                    }
                    connector+="\n";
                }
            }
        }
        if(connector.isEmpty()){
            System.out.println("Product not found");
        }
        else {
            System.out.println(connector);
        }
        connector="";
        k=0;
    }
    public static void listInventory(ArrayList<ArrayList<String>> list, int quantity){
        System.out.println(list.get(0).get(0)+"\t\t"+list.get(0).get(1)+"\t\t"+list.get(0).get(2)+"\t\t"+list.get(0).get(3)+"\t\t");
        System.out.println(list.get(1).get(0)+"\t\t"+list.get(1).get(1)+"\t\t"+list.get(1).get(2)+"\t\t"+list.get(1).get(3)+"\t\t");
        int sum;
        String connector="";
        for (int i = 2; i < k; i++) {
            sum=Integer.parseInt(list.get(i).get(3));
            if(sum>=quantity){
                for (int j = 0; j < 4; j++) {
                    connector+=list.get(i).get(j)+"\t\t";
                }
                System.out.println(connector);
                connector="";
            }
        }
        k=0;
    }
    public static void listTotalQuantityInInventory(ArrayList<ArrayList<String>> list){
        System.out.print("Total quantity of products in inventory is ");
        int sum=0;
        for (int i = 2; i < k; i++) {
            sum+=Integer.parseInt(list.get(i).get(3));
        }
        System.out.println(sum+ "");
        k=0;
    }
    public static void printListInventory(ArrayList<ArrayList<String>> list){
        Iterator<String> itr;
        for (int i = 0; i < k; i++) {
            itr = list.get(i).iterator();
            while(itr.hasNext()){
                System.out.print(itr.next()+"\t\t");
            }
            System.out.println();
        }
        k=0;
    }
}
