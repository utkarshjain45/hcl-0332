public class SingleObject {

    private SingleObject(){}

    public void display(){
        System.out.println("Display");
    }

    static final SingleObject obj = new SingleObject();

    public static SingleObject createInstance(){
        return obj;
    }
}
