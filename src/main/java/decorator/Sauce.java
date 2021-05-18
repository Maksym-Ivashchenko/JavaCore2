package decorator;

public class Sauce extends FoodDecorator {
    public Sauce(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " with sauce";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+10;
    }
}
