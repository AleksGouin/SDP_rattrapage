import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Shop {
    private Food[] foods;

    public Shop(Food[] foods) {
        super();
        this.foods = foods;
    }

    public Shop() {
        super();
        foods = new Food[] {
                new Food("Milk", 5, 2.51),
                new Food("Cheese", 21, 2.71),
                new Food("Strawberry", 2,10.00 ),
                new Food("Melons", 4, 4.04),
                new Food("Peppers", 7, 3.60),
                new Food("Carotts", 90, 2.01),
                new Food("Onions", 21, 1.92),
                new Food("Rice", 365, 5.60),
        };
    }

    void updatePrice(int days){
        for(int i =0; i<foods.length; i++){
            double decayPerDay = foods[i].decayPerDay();
            double price = foods[i].getPrice();
            int shelfLife = foods[i].getShelfLife();

            double newPrice = price - (decayPerDay * days);
            int newShelfLife = shelfLife - days;

            if(newPrice <0){
                newPrice =0;
            }
            if(newShelfLife < 0 ){
                newShelfLife = 0;
            }

            foods[i].setPrice(newPrice);
            foods[i].setShelflife(newShelfLife);
        }
    }

    public void printShop() {
        System.out.println("***************");
        for (Food food : foods) {
            System.out.println(food);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    private void readJSONFile(String place){

    }

    public static void main(String[] args) {

        Shop shop = new Shop();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the number of days you want the product to decay (int): ");
        int n = reader.nextInt();
        reader.close();

        shop.updatePrice(n);
        shop.printShop();

    }
}
