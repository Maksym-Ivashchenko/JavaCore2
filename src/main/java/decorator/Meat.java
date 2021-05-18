package decorator;

public class Meat extends FoodDecorator {
    public Meat(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " with meat";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+100;
    }
}
