package remember;

public class Sample {
    public static void main(String args[]) {
        Sample sample = new Sample();
        sample.hello();
        sample.morning("SATOSHI");
        sample.printAllCodes();
    }
    void hello() {
        System.out.println("Hello world");
    }
    void morning(String name) {
        System.out.println("Good morning " + name + "!");
    }
    void printAllCodes() {
        for(int i=1; i <= 52; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
