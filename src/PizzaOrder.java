import java.util.List;

public class PizzaOrder {
    private CrustType crustType;
    private String sauce;
    private String cheese;
    private List<String> toppings;
    String currentStepName;

    public CrustType getCrustType() {
        return crustType;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }
}
