package hw5;

class LevelLoaders {
    private static LevelLoaders instance = new LevelLoaders();

    private LevelLoaders() {
    }

    public static LevelLoaders getInstance() {
        return instance;
    }
    String load(String levelName){
        return "Loading level " + levelName + " ...";
    }

}
class LevelLoadersTest {
    public static void main(String[] args) {
        //Loading level Startlevel ...
        System.out.println(LevelLoaders.getInstance().load("StartLevel"));
    }
}