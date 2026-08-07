/*class student */
package subclass;

public class Student{
    //properties
    private String id, name, address, gender, email;
    private int age;


    //cntructor
    public Student(String id, String name, 
                    int age, String address, 
                    String gender, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email = email;
        
    }

    /* method */
    @Override
    public String toString() {
        return "ID: " + id + " | Ten: " + name + " | Tuoi: " + age + 
            " | Dia chi: " + address + " | Gioi tinh: " + gender + " | Email: " + email;
    }


    /*getter and setter */
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
   
}