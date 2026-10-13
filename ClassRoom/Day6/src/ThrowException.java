public class ThrowException {
    public static void main(String[] args) throws Exception {
        int age = 17;
        if (age < 18){
            throw new MyException("Under Age");
        }
    }
}

class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}