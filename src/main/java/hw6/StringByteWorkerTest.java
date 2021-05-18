package hw6;

class StringByteWorkerTest {
    public static void main(String[] args) {
        byte[] startBytes = {74, 97, 86, 97};

        //java
        System.out.println(new StringByteWorker().process(startBytes));
    }
}

class StringByteWorker {
    public String process(byte[] bytes) {
        return new String(bytes).toLowerCase();
    }
}
