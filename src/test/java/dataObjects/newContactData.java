package dataObjects;

public class newContactData {
    private String firstName;
    private String lastName;
    private String nickName;
    private String mobile;
    private String email;
    private String groupName;

    public newContactData(String firstName, String lastName, String nickName, String mobile, String email, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.mobile = mobile;
        this.email = email;
        this.groupName = groupName;
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

}
