package CoreDesignPattern.Observer;

// Concrete Observer
public class User implements Subscriber {
    private String name;


    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String newVideoUploaded) {
        System.out.println(name + " received notification: " + newVideoUploaded);
    }

}
