package moran.james.fruitylist;

/**
 * Stores Fruit object data and manipulate fields
 * so they are returned in the correct measurement unit
 * methods include getPriceInPoundsAndPence()and
 *getWeightInKilograms(
 **/
public class Fruit {

    private String type;
    private double priceInPence;
    private double weightInGrams;


    public Fruit(String type, double price, double weight) {
        this.type = type;
        this.priceInPence = price;
        this.weightInGrams = weight;
    }

    public String getType() {
        return type;
    }

    public double getPriceInPence() {
        return priceInPence;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    /*
        gets price of this Fruit in pounds and pence
     */
    public double getPriceInPoundsAndPence() {
        double priceInPenceAndPounds = this.priceInPence / 100;
        return priceInPenceAndPounds;
    }

    /*
        gets weight of this Fruit in kilograms
     */
    public double getWeightInKilograms() {
        double weightInKilograms = this.weightInGrams / 1000;
        return weightInKilograms;
    }

    /*
        gets weight with formatted unit String
     */
    public String formatWeightOfFruit() {
        return Double.toString(this.getWeightInKilograms()) + " KG";
    }

    /*
        gets price with formatted unit String
     */
    public String formatPriceOfFruit() {
        return "£ " + Double.toString(this.getPriceInPoundsAndPence());
    }
}
