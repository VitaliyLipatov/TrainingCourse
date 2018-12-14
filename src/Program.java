import java.util.Scanner;

public class Program {

    private static final int MAX_PRODUCTS = 3;
    private static final int MAX_DEAL = 3;

    private Deal[] deals;

    public static void main(String[] args) {
        new Program().allActions();
    }

    private void allActions() {
        input();
        System.out.println("<------------------------>");
        output();
    }

    public void output() {
        for (Deal deal : deals) {
            System.out.println("Deal" + deal.getDate());
            System.out.println("  " + deal.getBuyer().getName() + " buyes from " + deal.getSeller().getName());

            for (Product product : deal.getProducts()) {
                System.out.println("    " + product.getTitle() + " " + product.getAmount() + " * " +
                        product.getPrice() + " = " + product.getCost());
            }
            System.out.println("Sum: " + deal.getSum());
            System.out.println("---------------------");
        }
    }

    public void input() {
        deals = new Deal[MAX_DEAL];
        for (int i = 0; i < deals.length; i++) {
            System.out.println((i + 1) + " of " + deals.length + ": ");
            deals[i] = inputDeal();
        }
    }

    private Deal inputDeal() {
        System.out.println("Input deal ->");

        System.out.println("Input seller: ");
        Party seller = inputParty();
        System.out.println("Input buyer: ");
        Party buyer = inputParty();

        Product[] products = new Product[MAX_PRODUCTS];
        for (int i = 0; i < products.length; i++) {
            products[i] = inputProduct();
        }

        return new Deal(buyer, seller, products);
    }

    private Product inputProduct() {
        System.out.println("Input product ->");
        String title = readFromConsole("Enter title of product: ");
        String price = readFromConsole("Enter price: ");
        String amount = readFromConsole("Enter amount: ");
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(Double.valueOf(price));
        product.setAmount(Integer.valueOf(amount));
        return product;
    }

    private Party inputParty() {
        Party party = new Party();
        party.setName(readFromConsole("Enter party name: "));
        return party;
    }

    private static String readFromConsole(String inputText) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(inputText);
        return scanner.nextLine();
    }
}
