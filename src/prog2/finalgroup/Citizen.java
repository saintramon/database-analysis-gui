/**
 * @author Jasmin, Ramon Emmiel
 * @author Domingo, Diamond Darrel
 * @author Rabang, Gebreyl Isaac
 * @author Baltazar, Rudyard Lans
 * @author Urbiztondo, Karl Jasper
 * @author Bumanglag, AU
 */
package prog2.finalgroup;

public class Citizen {

    private String fullName;
    private String email;
    private String address;
    private int age;
    private boolean resident;
    private int district;
    private char gender;

    /**
     * This code defines a constructor for a class "Citizen" that initializes default values for its instance variables,
     * including fullName, email, address, age, resident, district, and gender.
     */
    public Citizen(){
        this.fullName = "Juan Dela Cruz";
        this.email = "juandelacruz@gmail.com";
        this.address = "Philippines";
        this.age = 0;
        this.resident = false;
        this.district = 0;
        this.gender = 'X';
    }

    /**
     * This code defines a constructor for a class  "Citizen" that accepts values for its instance variables.
     * @param fullName The full name of the citizen
     * @param email The email of the citizen
     * @param address The address of the citizen
     * @param age The age of the citizen
     * @param resident The resident of the citizen
     * @param district The district of the citizen
     * @param gender The gender of the citizen
     */
    public Citizen(String fullName, String email, String address, int age, boolean resident, int district, char gender){
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.resident = resident;
        this.district = district;
        this.gender = gender;
    }

    /**
     * This defines a getter method for the fullName instance variable of the class.
     * @return
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * This defines a getter method for the email instance variable of the class.
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * This defines a getter method for the address instance variable of the class.
     * @return
     */
    public String getAddress() {
        return address;
    }
    /**
     * This defines a getter method for the age instance variable of the class.
     * @return
     */
    public int getAge() {
        return age;
    }
    /**
     * This defines a getter method for the resident instance variable of the class.
     * @return
     */
    public boolean getResident(){
        return resident;
    }
    /**
     * This defines a getter method for the district instance variable of the class.
     * @return
     */
    public int getDistrict(){
        return district;
    }
    /**
     * This defines a getter method for the gender instance variable of the class.
     * @return
     */
    public char getGender() {
        return gender;
    }
    /**
     * This method sets the value of a "fullName" instance variable by concatenating a first name (fName) and last name (lName).
     * @param fName Holds the first name of the Citizen
     * @param lName Holds the last name of the Citizen
     */
    public void setFullName(String fName, String lName) {
        this.fullName = fName + " " + lName;
    }

    /**
     * This method sets the value of the "email" instance variable of the current object to the value of the "email" parameter.
     * @param email holds the email of the citizen
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * This method sets the value of the "address" instance variable of the current object to the value of the "address" parameter.
     * @param address holds the address of the citizen
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * This method sets the value of the "age" instance variable of the current object to the value of the "age" parameter.
     * @param age holds the age of the citizen
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method sets the value of the "resident" instance variable of the current object  based on the string value passed as the argument.
     * The method checks if the string value passed is equal to the string "Resident" using the "equalsIgnoreCase" method.
     * If the string value is equal, it sets the value of the "resident" instance variable to true; otherwise, it sets it to false.
     * @param resident holds the residency type of the citizen
     */
    public void setResident(String resident) {
        this.resident = (resident.equalsIgnoreCase("Resident")) ? true : false;
    }

    /**
     * The method sets the value of the "district" instance variable of the current object to the value of the "district" parameter.
     * @param district hold the district number of the resident
     */
    public void setDistrict(int district) {
        this.district = district;
    }

    /**
     * The method sets the value of the "gender" instance variable of the current object based on the string value passed as the argument.
     * The method checks if the string value passed is equal to the string "Male" using the "equalsIgnoreCase" method.
     * If the value is equal, the method sets the value of the "gender" instance variable to 'M'; otherwise, it sets it to 'F'.
     * @param gender holds the sex type of the citizen
     */
    public void setGender(String gender) {
        this.gender = (gender.equalsIgnoreCase("Male")) ? 'M' : 'F';
    }

    /**
     * This method named "toString" returns a string representation of an object, it concatenates the values of several properties of that object, including
     * "fullName", "email", "address", "age","resident", "district", and "gender", separated by commas.
     * @return String equivalent of the citizen
     */
    public String toString(){
        return fullName+","+email+","+address+","+age+","+resident+","+district+","+gender;
    }
}

