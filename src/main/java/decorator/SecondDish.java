package decorator;

public class SecondDish implements Food {

    @Override
    public String prepareFood() {
        return "Potatoes";
    }

    @Override
    public int getPrice() {
        return 50;
    }
}
