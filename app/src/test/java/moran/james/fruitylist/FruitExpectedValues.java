package moran.james.fruitylist;

/*
*@author JamesMoran
* provides expected values for Fruit class
* unit test
 */
public class FruitExpectedValues {
    private Double priceInPoundsAndPence;
    private Double weightInKilograms;
    private String formattedPrice;
    private String formattedWeight;

    public FruitExpectedValues(Double priceInPoundsAndPence, Double weightInKilograms, String formattedPrice, String formattedWeight) {
        this.priceInPoundsAndPence = priceInPoundsAndPence;
        this.weightInKilograms = weightInKilograms;
        this.formattedPrice = formattedPrice;
        this.formattedWeight = formattedWeight;
    }

    public Double getPriceInPoundsAndPence() {
        return priceInPoundsAndPence;
    }

    public Double getWeightInKilograms() {
        return weightInKilograms;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public String getFormattedWeight() {
        return formattedWeight;
    }
}
