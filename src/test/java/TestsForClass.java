public class TestsForClass {
    public static void main(String[] args) {

        MyClassFile classFile = new MyClassFile();
//        Operator 1 - true, operator 2 - true
        int actual1 = classFile.getNumber(-5, 5);
        if (actual1 == 42) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }
//        Operator 1 - true, operator 2 - false
        int actual2 = classFile.getNumber(-70, 1);
        if (actual2 == -40) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }
//        Operator 1 - false, operator 2 - true
        int actual3 = classFile.getNumber(-5, 11);
        if (actual3 == 42) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }
//        Operator 1 - false, operator 2 - false
        int actual4 = classFile.getNumber(10, 70);
        if (actual4 == 120) {
            System.out.println("Test four passed");
        } else {
            System.out.println("Test four failed");
        }
    }

}
