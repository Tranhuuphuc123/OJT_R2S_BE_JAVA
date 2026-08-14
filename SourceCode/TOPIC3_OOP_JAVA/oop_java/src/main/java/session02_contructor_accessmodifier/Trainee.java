package session02_contructor_accessmodifier;

//class mo ta chi tiet dac diem mot thuc tap sinh(MO hinh hoa)
public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    // contructor
    public Trainee() {
    }

    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            // IllegalArgumentException: ngoai le tham so khong hop le
            throw new IllegalArgumentException("Id cannot be empty");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be empty");
        }
        // du nhap gender la hoa hay thuong thi van chuyen thanh chu in thuong
        String normalGender = gender.trim().toLowerCase();
        if (!normalGender.equals("male") && !normalGender.equals("female")) {
            throw new IllegalArgumentException("Gender must be 'male' or 'female' ");
        }
        this.gender = gender;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age < 6) {
            throw new IllegalArgumentException("Age must be >= 6");
        }
        this.age = age;
    }

    // method tostring

    @Override
    public String toString() {
        return String.format("id: %s | name: %s | gender: %s | age: %d", id, name, gender, age);
    }

}
