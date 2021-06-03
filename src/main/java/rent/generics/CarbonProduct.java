package rent.generics;

public class CarbonProduct extends MetalProduct {

    private String something;

    public CarbonProduct() {}
    public CarbonProduct(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}