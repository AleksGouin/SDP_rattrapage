public class Food {
    private String name;
    private int shelfLife;
    private double price;

    public Food(String name, int shelfLife, double price) {
        super();
        this.name = name;
        this.shelfLife = shelfLife;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShelfLife(){
        return shelfLife ;
    }

    public void setShelflife(int shelfLife) {
        this.shelfLife = shelfLife ;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price ;
    }

    public double decayPerDay(){
        int life = this.shelfLife;
        double price = this.price;

        double decayPerDay = price / life;

        return decayPerDay;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", shelf life=" + shelfLife +
                ", price=" + price +
                '}';
    }
}
