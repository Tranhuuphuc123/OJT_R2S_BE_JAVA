import java.util.Scanner;

import subclass.Circle;
import subclass.Student;
import subclass.StudentManager;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        /*lab01- area circle*/
        // Circle circle = new Circle();
        // System.out.print("Nhap ban kinh hinh tron: ");
        // double r = sc.nextDouble();
        // circle.radius = r;
        // System.out.println("Dien tich hinh tron: " + circle.CircleArea());

        /* lab02 - menu student */
        StudentManager studentManager = new StudentManager();
        int choose;

        do {
            System.out.println(">>>>>>>MENU QUAN LY SINH VIEN<<<<<<<<<<");
            System.out.println("1. CREATE A STUDENT");
            System.out.println("2. DISPLAY STUDENT");
            System.out.println("3. FIND A STUDENT BY ID");
            System.out.println("4. UPDATE A STUDENT BY ID");
            System.out.println("5. QUIT");
            System.out.print("Vui long chon chuc nang: ");
            choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    createStudentCase(sc, studentManager);
                    break;
                case 2:
                    displayAllCase(studentManager);
                    break;
                case 3:
                    findStudentByIdCase(sc, studentManager);
                    break;
                case 4:
                    updateStudentByIdCase(sc, studentManager);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh. Cam on ban!");
                    break;
                default:
                    System.out.println("Vui long chon chuc nang tu 1-5");
                    break;
            }
            System.out.println();
        } while (choose != 5);

        sc.close();
    }

   private static void createStudentCase(Scanner sc, StudentManager manager) {
        String id;
        while (true) {
            System.out.print("Nhap id: ");
            id = sc.nextLine().strip();
            if (id.isBlank()) {
                System.out.println("ID khong duoc de trong. Vui long nhap lai.");
                continue;
            }
            if (manager.findStudentById(id) != null) {
                System.out.println("ID da ton tai. Vui long nhap ID khac.");
                continue;
            }
            break;
        }

        String name;
        while (true) {
            System.out.print("Nhap ten: ");
            name = sc.nextLine().strip();
            if (name.isBlank()) {
                System.out.println("Name must not be empty. Vui long nhap lai.");
                continue;
            }
            break;
        }

        int age;
        while (true) {
            System.out.print("Nhap tuoi: ");
            String ageLine = sc.nextLine().strip();
            try {
                age = Integer.parseInt(ageLine);
                if (age < 18) {
                    System.out.println("Age must be >= 18. Vui long nhap lai.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuoi phai la mot so nguyen. Vui long nhap lai.");
            }
        }

        System.out.print("Nhap dia chi: ");
        String address = sc.nextLine();

        String gender;
        while (true) {
            System.out.print("Nhap gender (male/female): ");
            gender = sc.nextLine().strip();
            if (!manager.isValidGender(gender)) {
                System.out.println("Gender must be 'male' or 'female'. Vui long nhap lai.");
                continue;
            }
            break;
        }

        String email;
        while (true) {
            System.out.print("Nhap email: ");
            email = sc.nextLine().strip();
            if (!manager.isValidEmail(email)) {
                System.out.println("Email invalid. Example: user@example.com. Vui long nhap lai.");
                continue;
            }
            break;
        }

        Student student = new Student(id, name, age, address, gender, email);
        Student created = manager.createStudent(student);
        if (created != null) {
            System.out.println("Tao student thanh cong.");
        } else {
            System.out.println("Tao student that bai. " + manager.getLastError());
        }
    }

    private static void displayAllCase(StudentManager manager) {
        Student[] students = manager.getAllStudents();
        if (students.length == 0) {
            System.out.println("Chua co student nao.");
            return;
        }
        System.out.println("Danh sach sinh vien:");
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }

    private static void findStudentByIdCase(Scanner sc, StudentManager manager) {
        System.out.print("Nhap id can tim: ");
        String id = sc.nextLine();
        Student student = manager.findStudentById(id);
        if (student == null) {
            System.out.println("Khong tim thay student voi id: " + id + ". " + manager.getLastError());
            return;
        }
        System.out.println("Thong tin student:");
        System.out.println("ID: " + student.getId());
        System.out.println("Ten: " + student.getName());
        System.out.println("Tuoi: " + student.getAge());
        System.out.println("Dia chi: " + student.getAddress());
        System.out.println("Gender: " + student.getGender());
        System.out.println("Email: " + student.getEmail());
    }

    private static void updateStudentByIdCase(Scanner sc, StudentManager manager) {
        System.out.print("Nhap id can cap nhat: ");
        String id = sc.nextLine().strip();
        Student current = manager.findStudentById(id);
        if (current == null) {
            System.out.println("Khong ton tai student voi id: " + id + ". " + manager.getLastError());
            return;
        }

        System.out.print("Nhap ten moi (de trong de giu \"" + current.getName() + "\"): ");
        String name = sc.nextLine().strip();
        if (name.isBlank()) {
            name = current.getName();
        }

        int age;
        while (true) {
            System.out.print("Nhap tuoi moi (de trong de giu \"" + current.getAge() + "\"): ");
            String ageLine = sc.nextLine().strip();
            if (ageLine.isBlank()) {
                age = current.getAge();
                break;
            }
            try {
                age = Integer.parseInt(ageLine);
                if (age < 18) {
                    System.out.println("Age must be >= 18. Vui long nhap lai.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuoi phai la mot so nguyen. Vui long nhap lai.");
            }
        }

        System.out.print("Nhap dia chi moi (de trong de giu \"" + current.getAddress() + "\"): ");
        String address = sc.nextLine();
        if (address.isBlank()) address = current.getAddress();

        String gender;
        while (true) {
            System.out.print("Nhap gender moi (male/female) (de trong de giu \"" + current.getGender() + "\"): ");
            String g = sc.nextLine().strip();
            if (g.isBlank()) {
                gender = current.getGender();
                break;
            }
            if (!manager.isValidGender(g)) {
                System.out.println("Gender must be 'male' or 'female'. Vui long nhap lai.");
                continue;
            }
            gender = g;
            break;
        }

        String email;
        while (true) {
            System.out.print("Nhap email moi (de trong de giu \"" + current.getEmail() + "\"): ");
            String e = sc.nextLine().strip();
            if (e.isBlank()) {
                email = current.getEmail();
                break;
            }
            if (!manager.isValidEmail(e)) {
                System.out.println("Email invalid. Example: user@example.com. Vui long nhap lai.");
                continue;
            }
            email = e;
            break;
        }

        Student updated = manager.updateStudentById(id, name, age, address, gender, email);
        if (updated != null) {
            System.out.println("Cap nhat student thanh cong.");
            System.out.println(updated);
        } else {
            System.out.println("Cap nhat that bai. " + manager.getLastError());
        }
    }
}