package rent.generics;

public class MetalProduct extends Product {
    private String type;

    public MetalProduct() {}
    public MetalProduct(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}