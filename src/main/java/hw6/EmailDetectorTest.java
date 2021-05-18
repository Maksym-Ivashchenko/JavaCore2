package hw6;

class EmailDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new EmailDetector().isPresent("This email is no-reply  @goo.com"));

        //false
        System.out.println(new EmailDetector().isPresent("ll@"));
    }
}

class EmailDetector {
    public boolean isPresent(String text) {
        String[] emailArray = text.split("@");
        try {
            String[] emailArray1 = emailArray[0].split(" ");
        String[] emailArray2 = emailArray[1].split(" ");
            if (emailArray1[emailArray1.length - 1].length() > 1 &&
                    emailArray2[0].length() > 1 &&
                    !emailArray[0].endsWith(" ") &&
                    !emailArray[1].startsWith(" "))
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }
}