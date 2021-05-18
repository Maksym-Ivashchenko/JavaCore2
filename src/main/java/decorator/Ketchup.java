package decorator;

public class Ketchup extends FoodDecorator {

    public Ketchup(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " with ketchup";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+5;
    }
}
