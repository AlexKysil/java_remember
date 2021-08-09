package dataObjects;

import java.util.Objects;

public class newContactData {
    private String firstName;
    private String lastName;
    private String nickName;
    private String mobile;
    private String email;
    private String groupName;
    private int Id;

    public newContactData(String firstName, String lastName, String nickName, String mobile, String email, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.mobile = mobile;
        this.email = email;
        this.groupName = groupName;
        this.Id = 0;
    }

    public newContactData(String firstName, String lastName, int Id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = null;
        this.email = null;
        this.groupName = null;
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "newContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Id=" + Id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        newContactData that = (newContactData) o;
        return Id == that.Id &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, Id);
    }
}
