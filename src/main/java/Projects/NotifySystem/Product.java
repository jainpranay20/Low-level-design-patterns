package Projects.NotifySystem;

// Product entity
public class Product {
    private final String id;
    private final String name;
    private boolean inStock;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
        this.inStock = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
