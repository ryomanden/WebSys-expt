package remember;

public class Sample {
    public static void main(String args[]){
        Sample sample = new Sample();
        sample.hello();
        sample.morning("SATOSHI");
    }
    void hello(){
        System.out.println("Hello world");
    }
    void morning(String name){
        System.out.println("Good morning " + name + "!");
    }
}
