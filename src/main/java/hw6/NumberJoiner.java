package hw6;

class NumberJoiner {
    public String join(int[] numbers) {
        StringBuilder result = new StringBuilder();
        for (int n: numbers)
            result.append(n);
        return result.toString();
    }
}

class NumberJoinerTest {
    public static void main(String[] args) {
        //102030
        System.out.println(new NumberJoiner().join(new int[] {10, 20, 30}));
    }
}