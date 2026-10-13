public class ExceptionImpl {
    public static void main(String[] args) throws InterruptedException {
        int a = 10;
        int b = 0;

        Thread.sleep(2000);

        try{
            int c = a / b;
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds");
        }  catch(NullPointerException e){
            System.out.println("NullPointer Exception");
        } catch(Exception e){
            System.out.println("Exception");
        }
        finally {
            System.out.println("finally");
        }
    }
}
