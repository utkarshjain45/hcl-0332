public class Main {
    public static void main(String[] args) {
        SingleObject obj1 = SingleObject.createInstance();
        SingleObject obj2 = SingleObject.createInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        obj1.display();
    }
}