package decorator;

public abstract class FoodDecorator implements Food {
    private Food food;

    public FoodDecorator(Food food) {
        this.food = food;
    }

    @Override
    public String prepareFood() {
        return food.prepareFood();
    }

    @Override
    public int getPrice() {
        return food.getPrice();
    }
}
