package CoreDesignPattern.Facade;

public class Projector {
    public void on()            { System.out.println("Projector ON"); }
    public void off()           { System.out.println("Projector OFF"); }
    public void setInput(String src) { System.out.println("Projector input: " + src); }
}

