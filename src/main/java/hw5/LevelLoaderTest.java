package hw5;

class Level {
    private int width;
    private int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
class LevelTooBigException extends Exception {
    public LevelTooBigException() {
    }
}

class LevelLoader {
    public void load(Level level) throws LevelTooBigException {
        if (level.getHeight()* level.getWidth() >100000){
            throw  new LevelTooBigException();
        } else
        System.out.println("Level loaded");
    }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}