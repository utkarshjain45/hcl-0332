package Day7.src;

public class StudentRecord {
    record Student(String name, int rollNo, String HCLId, int MobNo){}

    public static void main(String[] args) {
        Student s = new Student("Sumit", 23, "HCLTFP9388", 1234567890);

        System.out.println(s.HCLId);
    }
}
