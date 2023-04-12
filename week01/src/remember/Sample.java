package remember;

public class Sample {
    public static void main(String args[]) {
        Sample sample = new Sample();
        sample.hello();
        sample.morning("SATOSHI");
        sample.printAllCodes();
        sample.printOddCodes();
        sample.printSpadeCodes();
        sample.printdiamondCodes();
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
    void printOddCodes() {
        for(int i = 1; i <= 52; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    void printSpadeCodes() {
        for(int i = 1; i <= 52; i++) {
            if(i <= 13) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    void printdiamondCodes() {
        for(int i = 1; i <= 52; i++) {
            if(i >= 27 && i <= 39) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
