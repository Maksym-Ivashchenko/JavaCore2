package decorator;

public class Client {
    public static void main(String[] args) {

        print(new Fish(new SecondDish()));
        print(new Fish(new Sauce(new SecondDish())));
        print(new Fish(new Meat(new Sauce(new Ketchup(new SecondDish())))));
    }

    public static void print(Food food){
        System.out.println(food.prepareFood() + " -> " + food.getPrice());
    }
}
