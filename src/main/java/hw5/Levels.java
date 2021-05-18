package hw5;

class Levels {
    private LevelInfo levelInfo;
    private Point[] points;

    public Levels(LevelInfo levelInfo, Point[] points) {
        this.levelInfo = levelInfo;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Quarke level, name is " + levelInfo.getName() + ", difficulty is " + levelInfo.getDifficulty() + ", point count is " + points.length;
    }

    public int calculateLevelHash(){
        int res = 0;
        for (Point pointer: points){
            res += pointer.getX()* pointer.getY();
        }
        return res;
    }

    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class LevelInfo {
        private String name;
        private String difficulty;

        public LevelInfo(String name, String difficulty) {
            this.name = name;
            this.difficulty = difficulty;
        }

        public String getName() {
            return name;
        }

        public String getDifficulty() {
            return difficulty;
        }
    }
}

class LevelTest {
    public static void main(String[] args) {
        Levels.Point p1 = new Levels.Point(3, 5);
        Levels.Point p2 = new Levels.Point(10, 100);
        Levels.Point p3 = new Levels.Point(50, 40);

        Levels.Point[] points = {p1, p2, p3};

        Levels.LevelInfo info = new Levels.LevelInfo("Quarke Intro", "Easy");

        //3015
        System.out.println(new Levels(info, points).calculateLevelHash());
    }
}