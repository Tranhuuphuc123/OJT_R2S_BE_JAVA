package subclass;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StudentManager {
    private final Student[] students;
    private int size;
    private String lastError;

    public StudentManager() {
        students = new Student[100];
        size = 0;
        lastError = null;
    }

    //method de bao loi
    public String getLastError() {
        return lastError;
    }
    
    /*method1: create student */
    public Student createStudent(Student student) {
        if (student == null) {
            lastError = "Student object is null.";
            return null;
        }

        //check dieu kien kiem tra xem co hop le hay khong
        if (!isValidName(student.getName())) {
            lastError = "Name must not be empty.";
            return null;
        }
        if (!isValidAge(student.getAge())) {
            lastError = "Age must be >= 18.";
            return null;
        }
        if (!isValidGender(student.getGender())) {
            lastError = "Gender must be 'male' or 'female'.";
            return null;
        }
        if (!isValidEmail(student.getEmail())) {
            lastError = "Email is invalid. Example: user@example.com";
            return null;
        }
        if (!isUniqueId(student.getId())) {
            lastError = "ID '" + student.getId() + "' already exists.";
            return null;
        }
        if (size >= students.length) {
            lastError = "Student storage is full.";
            return null;
        }

        students[size++] = student;
        lastError = null;
        return student;
    }

    /* method 2: to get all students */
    public Student[] getAllStudents() {
        return Arrays.copyOf(students, size);
    }

    
    /*method 3: find student by id */
    public Student findStudentById(String id) {
        if (id == null || id.isBlank()) {
            lastError = "ID must not be empty.";
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equals(id)) {
                lastError = null;
                return students[i];
            }
        }
        lastError = "No student found with ID: " + id;
        return null;
    }

    
    /*method4: update student by id */
    public Student updateStudentById(
            String id,
            String name,
            int age,
            String address,
            String gender,
            String email) {
        Student student = findStudentById(id);
        if (student == null) {
            // findStudentById already sets lastError
            if (lastError == null) lastError = "Student with ID '" + id + "' not found.";
            return null;
        }
        if (!isValidName(name)) {
            lastError = "Name must not be empty.";
            return null;
        }
        if (!isValidAge(age)) {
            lastError = "Age must be >= 18.";
            return null;
        }
        if (!isValidGender(gender)) {
            lastError = "Gender must be 'male' or 'female'.";
            return null;
        }
        if (!isValidEmail(email)) {
            lastError = "Email is invalid. Example: user@example.com";
            return null;
        }

        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        student.setGender(gender);
        student.setEmail(email);
        lastError = null;
        return student;
    }


    /* ################ CAC METHODS CHECK LIST VALIDATION#################### */
    //isUniqueId: check(ktra xem id da ton tai hay chua)
    public boolean isUniqueId(String id) {
       // 1. Tìm xem ID đã tồn tại chưa
        Student st = findStudentById(id);

        // 2. Nếu tìm thấy (st != null) nghĩa là bị trùng ID -> KHÔNG duy nhất (false)
        if (st != null) {
            return false; 
        } 
        // 3. Nếu không tìm thấy (st == null) nghĩa là ID mới -> DUY NHẤT (true)
        else {
            return true; 
        }
    }

    //check dk xem ten hop le khong
    public boolean isValidName(String name) {
        return name != null && !name.isBlank();
    }

    //check tuoi co hop le khong (>=18)
    public boolean isValidAge(int age) {
        return age >= 18;
    }

    //kiemtra gioi tinh co hơp le
    public boolean isValidGender(String gender) {
        if (gender == null) {
            return false;
        }
        String value = gender.strip().toLowerCase();
        return value.equals("male") || value.equals("female");
    }

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public boolean isValidEmail(String email) {
        if (email == null || email.isBlank()) return false;
        return EMAIL_PATTERN.matcher(email.strip()).matches();
    }

    private boolean isValidStudent(Student student) {
        return isValidName(student.getName())
                && isValidAge(student.getAge())
                && isValidGender(student.getGender())
                && isValidEmail(student.getEmail());
    }
}