package product_inventory;

public class ProductInventory {
    public static void main(String[] args) throws Exception{
        InventoryOperations.insertItems("src\\survey_questions\\inventory.txt");
        InventoryOperations.printListInventory(InventoryOperations.listInventory("src\\survey_questions\\inventory.txt"));
        System.out.println("************************************************************************************");
        InventoryOperations.listInventory(InventoryOperations.listInventory("src\\survey_questions\\inventory.txt"), "apples");
        System.out.println("************************************************************************************");
        InventoryOperations.listInventory(InventoryOperations.listInventory("src\\survey_questions\\inventory.txt"), 4);
        System.out.println("************************************************************************************");
        InventoryOperations.listTotalQuantityInInventory(InventoryOperations.listInventory("src\\survey_questions\\inventory.txt"));
    }
}
