import java.util.List;

class Generic <T extends Number> {
    T a;
    T b;

    public Generic(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public int m1(T a, T b){
        return a.intValue() + b.intValue();
    }
}

class A{
    static <T>void m1(T a, T b){
        return;
    }

    void display(List<? extends Number> ls){

    }
}