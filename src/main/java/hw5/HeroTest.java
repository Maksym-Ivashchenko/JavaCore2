package hw5;

class HeroTest {
    public static void main(String[] args) {
        Hero hero = new Hero("Stranger", 50);

        //Expect Paratrooper
        System.out.println(hero.getName());

        //Expect 100
        System.out.println(hero.getHp());
    }
}
class Hero {
    private String name;
    private int hp;

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public Hero() {
        this("Paratrooper", 100);
    }
    public Hero(String name, int hp) {
        this.name = name;
        if (hp < 0)
            return;
        if (hp >= 0 && hp <= 200)
            this.hp = hp;
        if (hp > 200)
        this.hp = 200;
    }
}