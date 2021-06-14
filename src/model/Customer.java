package model;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private final String emailRegex = "^(.+)@(.+).(.+)$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email){
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, wrong format");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName(){ return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}

    @Override
    public String toString() {
        {return "The customer is " + firstName + " " + lastName + " with an email of " + email + "."; }
    }
}
