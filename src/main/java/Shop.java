import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import java.util.ArrayList;

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
/*
    private Shop readJSONFile(String place){
        JSONParser parser = new JSONParser();
        Food[] foods;
        try {
            Object obj = parser.parse(new FileReader(place)); //problem here

            JSONObject jsonObject =  (JSONObject) obj;

            String name = (String) jsonObject.get("name");

            String shelfLife = (String) jsonObject.get("Shelf life");
            int shelf_life = Integer.parseInt(shelfLife);

            String price_ = (String) jsonObject.get("Price");
            double price = Double.parseDouble(price_);

            foods.add(new Food(name, shelf_life, price)); // problem here
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    Shop shop = new Shop(foods);
    }
    Unfinished
*/
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
