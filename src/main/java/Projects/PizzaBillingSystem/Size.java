package Projects.PizzaBillingSystem;

// Size enum and SizeDecorator
public enum Size {
    SMALL(1.0, "Small"),
    MEDIUM(1.5, "Medium"),
    LARGE(2.0, "Large");

    public final double multiplier;
    public final String label;
    Size(double m, String l) { this.multiplier = m; this.label = l; }
}

