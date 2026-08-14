package session01_class_object;

import java.util.Scanner;

public class StudentManager {
    private static Student[] listSudents = new Student[100];
    private static int count = 0;
    private static Scanner sc = new Scanner(System.in);

    // ham main quan ly chtrinh
    public static void main(String[] args) {
        // menu studentManager quan ly sinh vien
        int choice = 0;

        do {
            System.out.println(">>>>>>>MENU QUAN LY SINH VIEN<<<<<<<<<<");
            System.out.println("1. CREATE A STUDENT");
            System.out.println("2. DISPLAY STUDENT");
            System.out.println("3. FIND A STUDENT BY ID");
            System.out.println("4. UPDATE A STUDENT BY ID");
            System.out.println("5. QUIT");

            System.out.print("Vui long chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    findById();
                    break;
                case 4:
                    updateById();
                    break;
                case 5:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid choice, Please choice again! ");
                    break;
            }
        } while (choice != 5);
    }

    /** #### CAC METHOD CREATE, DISPLAY, FIND, UPDATE #### **/
    /* method kiem tra id co ton tai hay khong ton tai */
    private static int findIndexById(String id) {
        // de tranh loi nullPointerExeption khi id = null
        if (id == null)
            return -1; // -1 la id khong co ton tai

        for (int i = 0; i < count; i++) {
            Student s = listSudents[i];
            if (s != null) {
                String student_id = s.getId();
                /*
                 * equalsIgnoreCase: là phương thức so sánh hai String
                 * trả về true nếu nội dung giống nhau bất kể chữ hoa/chữ
                 * thường.
                 * + ex: "AB123".equalsIgnoreCase("ab123")
                 */
                if (student_id != null && student_id.equalsIgnoreCase(id.trim())) {
                    return i;
                }
            }
        }
        /*
         * neu vong lap ket thuc ma k tim thay id thi tra ve -1
         * de biu thi la khong tim thay, id khogn ton tai
         */
        return -1;
    }

    /* method createStudent */
    private static void createStudent() {
        if (count >= 100) {
            System.out.println("Student list is full!");
            return;
        }

        String id;
        while (true) {
            System.out.println("Enter ID: ");
            id = sc.nextLine();
            if (findIndexById(id) != -1) {
                System.out.println("Error. id already exists!");
            } else {
                break;
            }
        }

        String name;
        while (true) {
            System.out.println("Enter Name: ");
            name = sc.nextLine();
            if (name.trim().isEmpty())
                System.out.println("Name cannot be empty");
            else
                break;
        }

        int age;
        while (true) {
            System.out.println("Enter age: ");
            age = Integer.parseInt(sc.nextLine());
            if (age < 18)
                System.out.println("Age must be >= 18");
            else
                break;
        }

        System.out.println("Enter Address: ");
        String address = sc.nextLine();

        String gender;
        while (true) {
            System.out.println("Enter gender (male/female): ");
            gender = sc.nextLine();
            // equalsIgnoreCase la ss hai chui string du hoa hay thuong deu ok
            if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))
                System.out.println("Gender must be 'male' or 'female'");
            else
                break;
        }

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        // khoi tao va add cac ds student moi tao vao mang listStudents o tren
        listSudents[count++] = new Student(id, name, age, address, gender, email);
        System.out.println("Student added successfully!");
    }

    /* method display */
    private static void displayAll() {
        if (count == 0) {
            System.out.println("No students found");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(listSudents[i].toString());
        }
    }

    /* method findById: tim kiem t2heo id */
    private static void findById() {
        System.out.println("Enter ID to want find: ");
        int index = findIndexById(sc.nextLine());
        // -1 nghia la id khong co ton tai
        if (index == -1) {
            System.out.println("Student not found");
            return;
        } else {
            System.out.println(listSudents[index]);
        }
    }

    /* method update */
    private static void updateById() {
        System.out.print("Enter ID to update: ");
        int index = findIndexById(sc.nextLine());
        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }
        Student st = listSudents[index];

        System.out.print("New Name (leave blank to keep old): ");
        String name = sc.nextLine();
        /*
         * "
         * => khối đk trong if phải là true mới thực thi nếu false thì bỏ qua
         * => “kiểm tra isEmpty() trước, rồi dùng ! để lấy trường hợp ngược lại”.
         * "=> ex:
         * name.trim() = "", isEmpty() = true, !true = false → không set
         * "Lan" -> name.trim() = "Lan", isEmpty() = false, !false = true → set name
         */
        if (!name.trim().isEmpty())
            st.setName(name);

        System.out.print("New Age (leave blank to keep old): ");
        String ageLine = sc.nextLine();
        if (!ageLine.trim().isEmpty()) {
            int age = Integer.parseInt(ageLine);
            if (age >= 18) {
                st.setAge(age);
            } else {
                System.out.println("Age must be >= 18. Keeping old value.");
            }
        }

        System.out.print("New Address (leave blank to keep old): ");
        String address = sc.nextLine();
        if (!address.trim().isEmpty())
            st.setAddress(address);

        System.out.print("New Gender (male/female, leave blank to keep old): ");
        String gender = sc.nextLine();
        if (!gender.trim().isEmpty()) {
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                st.setGender(gender);
            } else {
                System.out.println("Invalid gender. Keeping old value.");
            }
        }

        System.out.print("New Email (leave blank to keep old): ");
        String email = sc.nextLine();
        if (!email.trim().isEmpty())
            st.setEmail(email);

        System.out.println("Updated successfully!");
    }
}
