package session02_contructor_accessmodifier;

import java.util.Scanner;

//class chinh giu menu lenh 1-6 thuc thi cac khoi lenh khi chon menu
public class TraineeManManager {
    private TraineeForm traineeForm;
    private Scanner sc;
    private Trainee[] listOfTrainees;
    private byte count; // bien dem gia tri mang

    // contructor
    public TraineeManManager() {
        this.sc = new Scanner(System.in);
        this.traineeForm = new TraineeForm(this.sc);
        this.listOfTrainees = new Trainee[100];
        this.count = 0; // bien dem ban dau ghi nhan la 0
    }

    // method main chinh
    public static void main(String[] args) {
        TraineeManManager app = new TraineeManManager();
        int choice = 0;
        do {
            System.out.println("\n=== TRAINING MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Trainee");
            System.out.println("2. Display All Trainees");
            System.out.println("3. Find Trainee By ID");
            System.out.println("4. Find Trainee By Name");
            System.out.println("5. Update Trainee By ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            try {
                choice = Integer.parseInt(app.sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    app.addTrainee();
                    break;
                case 2:
                    app.displayAllTrainees();
                    break;
                case 3:
                    String searchId = app.traineeForm.getId();
                    Trainee foundById = app.findTraineeById(searchId);
                    if (foundById != null) {
                        System.out.println("Found: " + foundById);
                    } else {
                        System.out.println("Trainee not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = app.sc.nextLine();
                    Trainee[] matches = app.findTraineeByName(searchName);
                    if (matches.length > 0) {
                        System.out.println("Search Results:");
                        for (Trainee t : matches)
                            System.out.println(t);
                    } else {
                        System.out.println("No matching trainees found!");
                    }
                    break;
                case 5:
                    String updateId = app.traineeForm.getId();
                    Trainee existing = app.findTraineeById(updateId);
                    if (existing == null) {
                        System.out.println("Trainee ID does not exist!");
                    } else {
                        System.out.println("Enter new details (leave blank to keep current):");

                        System.out.print("Enter new name: ");
                        String newName = app.sc.nextLine().trim();
                        if (newName.isEmpty())
                            newName = null;

                        System.out.print("Enter new gender (male/female): ");
                        String newGender = app.sc.nextLine().trim().toLowerCase();
                        if (newGender.isEmpty()) {
                            newGender = null;
                        } else if (!newGender.equals("male") && !newGender.equals("female")) {
                            System.out.println("Invalid gender. Skipping gender update.");
                            newGender = null;
                        }

                        System.out.print("Enter new age (>=6): ");
                        String ageText = app.sc.nextLine().trim();
                        byte newAge = 0;
                        if (!ageText.isEmpty()) {
                            try {
                                newAge = Byte.parseByte(ageText);
                                if (newAge < 6) {
                                    System.out.println("Age must be >= 6. Skipping age update.");
                                    newAge = 0;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid age. Skipping age update.");
                                newAge = 0;
                            }
                        }

                        app.updateTrainee(updateId, new Trainee(null, newName, newGender, newAge));
                    }
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-6.");
            }
        } while (choice != 6);
    }

    /**** CÁC METHOD PHỤ TRỢ *******/
    // method add cac trainee khi nhap create xong
    private void addTrainee() {
        if (count >= 100) {
            System.out.println("List is full. Cannot add more trainees!");
            return;
        }
        String id = traineeForm.getId();
        if (findTraineeById(id) != null) {
            System.out.println("Error: Trainee ID already exists!");
            return;
        }
        Trainee trainee = traineeForm.getTrainee();
        trainee.setId(id);
        listOfTrainees[count++] = trainee;
        System.out.println("Trainee added successfully!");
    }

    // method hien thi thong tin trainee
    private void displayAllTrainees() {
        if (count == 0) {
            System.out.println("No trainees in the list.");
            return;
        }
        System.out.println("--------------------------------------------------");
        System.out.println(String.format("%-8s | %-18s | %-6s | %-3s", "ID", "Name", "Gender", "Age"));
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);
        }
        System.out.println("--------------------------------------------------");
    }

    // method tiem kiem trainee theo id
    private Trainee findTraineeById(String id) {
        if (id == null)
            return null;
        for (int i = 0; i < count; i++) {
            // equalsIgnoreCase: so sang ket qua cua hai chuoi string
            if (listOfTrainees[i].getId().equalsIgnoreCase(id.trim())) {
                return listOfTrainees[i];
            }
        }
        return null;
    }

    // method tiem kiem theo name
    private Trainee[] findTraineeByName(String name) {
        if (name == null || name.trim().isEmpty())
            return new Trainee[0];

        // Đếm số lượng phù hợp
        int matchCount = 0;
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().toLowerCase().contains(name.trim().toLowerCase())) {
                matchCount++;
            }
        }

        // Tạo mảng vừa đủ chứa kết quả
        Trainee[] result = new Trainee[matchCount];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().toLowerCase().contains(name.trim().toLowerCase())) {
                result[index++] = listOfTrainees[i];
            }
        }
        return result;
    }

    // method update trainee theo id
    private void updateTrainee(String id, Trainee newTrainee) {
        Trainee existing = findTraineeById(id);
        if (existing == null) {
            System.out.println("Error: Trainee with ID " + id + " not found!");
            return;
        }

        // Chỉ cập nhật Name nếu người dùng có nhập tên mới (không rỗng)
        if (newTrainee.getName() != null && !newTrainee.getName().trim().isEmpty()) {
            existing.setName(newTrainee.getName());
        }

        // Chỉ cập nhật Gender nếu có nhập giá trị mới hợp lệ
        if (newTrainee.getGender() != null && !newTrainee.getGender().trim().isEmpty()) {
            existing.setGender(newTrainee.getGender());
        }

        // Chỉ cập nhật Age nếu tuổi nhập vào hợp lệ (>= 6)
        if (newTrainee.getAge() >= 6) {
            existing.setAge(newTrainee.getAge());
        }

        System.out.println("Trainee updated successfully!");
    }
}
