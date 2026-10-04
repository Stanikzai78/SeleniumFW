package JavaProgram;

class Item {
    String name;
    double unitPrice;
    int quantity;
}

public class ItemClients {

    public static void main(String[] args) {

        Item pen = new Item();
        pen.name      = "Pen";
        pen.unitPrice = 1.99;
        pen.quantity  = 5;
        System.out.println(pen.name);
        System.out.println(pen.unitPrice);
        System.out.println(pen.quantity);

        Item notebook = new Item();
        notebook.name      = "Notebook";
        notebook.unitPrice = 2.55;
        notebook.quantity  = 3;
        System.out.println(notebook.name);
        System.out.println(notebook.unitPrice);
        System.out.println(notebook.quantity);
    }
}