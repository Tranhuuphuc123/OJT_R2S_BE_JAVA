package subclass;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    //contructor
    public Trainee(){}
    public Trainee(String id, String name, String gender, byte age){
        //gang du lieu thong qua setter de kiem tra dieu kien
        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
    }

    //getter and setter 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null && !id.isEmpty()){
            this.id = id;
        } else {
            System.out.println("Error: ID cannot be empty");;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty()){
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty");  
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender != null && (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))){
            this.gender = gender;
        } else {
            System.out.println("Error: gender must be 'male' or 'female'");
        };
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if(age >= 6){
            this.age = age;
        } else {
            System.out.println("Error: Age must be greater than or equals to 6");
        }
    }

    
}
