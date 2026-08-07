package subclass;

import java.util.Arrays;
import java.util.Scanner;

public class TrainingManManager {
  private final TraineeForm traineeForm;
  private final Scanner scanner;
  private final Trainee[] listOfTrainees = new Trainee[100];
  private byte count = 0;

  // contructor
  public TrainingManManager() {
    this.scanner = new Scanner(System.in);
    this.traineeForm = new TraineeForm(scanner);
  }

  // method
  public static void main(String[] arge) {
    new TrainingManManager().runMenu();
  }

  /* method menu */
  private void runMenu() {
    while (true) {
      System.out.println("\n==== Trainee Management ====");
      System.out.println("1. Add trainee");
      System.out.println("2. Display all trainees");
      System.out.println("3. Find trainee by id");
      System.out.println("4. Find trainee by name");
      System.out.println("5. Update trainee by id");
      System.out.println("0. Exit");

      System.out.print("Choose: ");
      int choice = Integer.parseInt(scanner.nextLine().trim());

      switch (choice) {
        case 1:
          addTrainee();
          break;
        case 2:
          displayAllTrainees();
          break;
        case 3:
          System.out.println("Enter id to find: ");
          String findId = scanner.nextLine();

          Trainee trainee = findTraineeById(findId);
          if (trainee != null) {

          }
          if (trainee != null) {
            System.out.println("Trainee found successfully!");
            System.out.println("ID: " + trainee.getId());
            System.out.println("Name: " + trainee.getName());
            System.out.println("Gender: " + trainee.getGender());
          } else {
            System.out.println("Trainee not found!");
          }
          break;

        case 4:
          System.out.println("Enter name (keyword");
          String name = scanner.nextLine().trim();

          Trainee[] result = findTraineeByName(name);
          if (result.length == 0) {
            System.out.println("No Match");
          } else {
            for (Trainee t : result) {
              System.out.println(t);
            }
          }
          break;

        case 5:
          System.out.print("Enter id to update: ");
          String updateId = scanner.nextLine().trim();

          System.out.print("Enter new name (leave blank to keep old): ");
          String newName = scanner.nextLine().trim();

          System.out.print("Enter new gender (Male/Female, leave blank to keep old): ");
          String newGender = scanner.nextLine().trim();

          System.out.print("Enter new age (leave blank to keep old): ");
          String newAge = scanner.nextLine().trim();

          updateTrainee(updateId, newName, newGender, newAge);
          break;

        case 0:
          System.out.println("Bye!");
          break;

        default:
          System.out.println("Invalid choide");
          ;
          break;

      }
    }
  }

  /* 1. method addTrainee */
  public void addTrainee() {
    if (count >= listOfTrainees.length) {
      System.out.println("Error: Trainee list is full");
      return;
    }

    String id;
    while (true) {
      id = traineeForm.getId();
      /*
       * dung ham indexOfld kiem tra id co ton tai khong, neu khong trung thi tra ve
       * -1
       * id khong trung moi hop le
       */
      if (indexOfld(id) == -1)
        break;
      System.out.println("Error: Trainee with this ID already exists. Please enter a different ID.");
    }
    Trainee trainee = traineeForm.getTrainee();
    trainee.setId(id); // gan lai id da kiem tra hop le

    listOfTrainees[count++] = trainee;
    System.out.println("Trainee added successfully.");
  }

  /* 2. method display Alltrainees */
  public void displayAllTrainees() {
    if (count == 0) {
      System.out.println("No trainees to yet");
      return;
    }

    System.out.println("== List of Trainees ==");
    for (int i = 0; i < count; i++) {
      System.out.println(listOfTrainees[i].getId() + " - " + listOfTrainees[i].getName() + " - "
          + listOfTrainees[i].getGender() + " - " + listOfTrainees[i].getAge());
    }
  }

  /* 3. method findTraineeById: tim kiem theo id */
  public Trainee findTraineeById(String id) {
    int index = indexOfld(id);
    if (index != -1) {
      return listOfTrainees[index];
    }
    return null;
  }

  /* 4. method findTraineeByName: tim kiem theo ten */
  public Trainee[] findTraineeByName(String name) {
    String key = name.toLowerCase();
    /*
     * truyen bien dem count vao de khop voi may muc 1 khi addTrainee
     * chi can co bao nhieu Trainee moi dc create thi count dem dung so
     * do truyen vao thanh phan mang cua method tim kiem theo ten nay de
     * khong bao gio co vu khong khop khi thuc thi method addTrainee()
     * thi tao dc 3 Trainee ma duoi method findTraineeByName lai co hon
     * 3 trainee dc
     */
    Trainee[] temp = new Trainee[count];
    int k = 0; // bien dem k

    for (int i = 0; i < count; i++) {
      // ktra xem trainee co chua chuoi can tim kiem voi id tuong ung khong
      if (listOfTrainees[i].getName().toLowerCase().contains(key)) {
        // neu co dua trainee do vao mang tam temp va tang k len de luu tru
        temp[k++] = listOfTrainees[i];
      }
    }

    // tra ve mang chi chua dung so phan tu tim thay
    return Arrays.copyOf(temp, k);
  }

  /* 5 .mehod UpdateTrainee */
  public void updateTrainee(String id, String newName, String newGender, String newAgeText) {
    int index = indexOfld(id);
    if (index == -1) {
      System.out.println("Id not found");
      return;
    }

    Trainee trainee = listOfTrainees[index];

    if (newName != null && !newName.trim().isEmpty()) {
      trainee.setName(newName.trim());
    }

    if (newGender != null && !newGender.trim().isEmpty()) {
      trainee.setGender(newGender.trim());
    }

    if (newAgeText != null && !newAgeText.trim().isEmpty()) {
      try {
        byte age = Byte.parseByte(newAgeText.trim());
        trainee.setAge(age);
      } catch (NumberFormatException e) {
        System.out.println("Invalid age input. Age was not updated.");
      }
    }

    System.out.println("Update successfully!");
  }

  /* method xua ly kiem tra co trung id */
  private int indexOfld(String id) {
    for (int i = 0; i < count; i++) {
      // equalsIgnoreCase: so sanh 2 chuoi khong phan biet hoa thuong
      if (listOfTrainees[i].getId().equalsIgnoreCase(id))
        return i;
    }
    // -1 la gia tri tra ve neu khong tim thay id trung nhau
    return -1;
  }

}
