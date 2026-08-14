package session02_contructor_accessmodifier;

import java.util.Scanner;

//class form mau nhap lieu cho thuc tap sinh kem cac constraint rang buoc validate
public class TraineeForm {
    private final Scanner sc;

    // contructor
    public TraineeForm(Scanner sc) {
        this.sc = sc;
    }

    /* method rang buoc constraint cho Trainee */
    // method kiem tra id co trong khong
    public String getId() {
        while (true) {
            System.out.println("Enter trainee id: ");
            String id = sc.nextLine();
            /*
             * + neu id null thi id.isEmpty = true -> !true = false,
             * dk false thi bo qua in thong bao loi
             * + neu id != null thi id.isEmpty = false -> !false = true
             * thi dk dung tra ve id do
             */
            if (!id.isEmpty())
                return id;
            System.out.println(" Id cannot be empty. Try again");
        }
    }

    // method nhap cac value cua Trainee -> kem rang buoc validate
    public Trainee getTrainee() {
        String name = readNonEmpty("Enter name: ");
        String gender = readGender("Enter gender (male/female): ");
        byte age = readAge("Enter age (>=6): ");
        return new Trainee("TEMP: ", name, gender, age);
    }

    // method kiem tra value nhap vao co rong hay khong
    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty())
                return value;
            System.out.println("Value cannot be empty. ");
        }
    }

    // method doc kiem tra gioi tinh
    private String readGender(String prompt) {
        while (true) {
            System.out.println(prompt);
            String gender = sc.nextLine().trim().toLowerCase();
            if (gender.equals("male") || gender.equals("female")) {
                return gender;
            }
            System.out.println("Gender must be 'male' or 'female'. ");
        }
    }

    // method kiem tra rang buoc tuoi tac
    private byte readAge(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                byte age = Byte.parseByte(sc.nextLine().trim());
                if (age >= 6) {
                    return age;
                }
                System.out.println("Age must be >= 6");
            } catch (NumberFormatException e) {
                /*
                 * NumberFormatException: nem ra khi value chuyen doi tu string sang number bi
                 * loi
                 */
                System.out.println("Invalid number format. Enter a valid age");
            }
        }
    }
}
