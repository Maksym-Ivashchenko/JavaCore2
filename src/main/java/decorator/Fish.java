package decorator;

public class Fish extends FoodDecorator {
    public Fish(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " with fish";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+50;
    }
}
