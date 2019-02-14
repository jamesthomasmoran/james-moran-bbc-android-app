package moran.james.fruitylist;

/*
*@author James Moran
* Stores Fruit object data and manipulate fields
* so they are returned in the correct measurement unit
* methods include getPriceInPoundsAndPence()and
*getWeightInKilograms(
 */
public class Fruit {

    private String type;
    private double priceInPence;
    private double weightInGrams;


    public Fruit (String type, double price, double weight) {
        this.type=type;
        this.priceInPence=price;
        this.weightInGrams=weight;
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
    public double getPriceInPoundsAndPence(){
        double priceInPenceAndPounds=this.priceInPence/100;
        return priceInPenceAndPounds;
    }
    /*
        gets weight of this Fruit in kilograms
     */
    public double getWeightInKilograms(){
        double weightInKilograms=this.weightInGrams/1000;
        return weightInKilograms;
    }
}
