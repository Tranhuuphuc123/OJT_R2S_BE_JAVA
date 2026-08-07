package subclass;
import java.util.Scanner;


public class TraineeForm {
    // attribute
    private final Scanner scanner;

    /*contructor */
    public TraineeForm(Scanner scanner){
        this.scanner = scanner;
    }

    //ham getId
    public String getId(){
        while(true){
            System.out.println("Enter trainee ID: ");
            String id = scanner.nextLine().trim();

            if(!id.isEmpty()) return id;
            System.out.println("Id cannot be empty. Try again. ");
        }
    }
   
    //ham getTrainee
    public Trainee getTrainee(){
        System.out.println("== Enter Trainee Information ==");
        
       String name = readNonEmty("Enter name: ");
       String gender = readGender(" Enter gender (Male/Female): " );
       byte age = readAge("Enter age >= 6");
       return new Trainee("TEMP", name, gender, age);
    }

    /*#### VALIDATE #### */
    private String readNonEmty(String prompt){
        while(true){
            System.out.println(prompt);
            String value = scanner.nextLine().trim();
            if(!value.isEmpty()) return value;
            System.out.println("Value cannot be empty. Try again.");
        }
    }

    private String readGender(String prompt){
        while(true){
            System.out.println(prompt);
            String gender = scanner.nextLine().trim();

            if(gender.equals("male") || gender.equals("female")) return gender;
            System.out.println("Gender must be 'male' or 'female'");
        }
    }

    private byte readAge(String prompt){
        while(true){
            try{
                System.out.println(prompt);
                String line = scanner.nextLine().trim();
                byte age = Byte.parseByte(line);

                if(age >= 6) return age;
                System.out.println(" Age must be greater be >= 6");;
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number for age.");;
            }
        }
    }
}
