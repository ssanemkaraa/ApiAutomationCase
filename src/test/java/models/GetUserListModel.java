

package models;

public class GetUserListModel {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean isActive;

    public String getid() {
        return id;
    }

    public void setid(String id) {
        if (!id.isEmpty()){
            this.id = id;
        }
        else {
            throw new NullPointerException();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public GetUserListModel(String id, String username, String firstName, String lastName, Boolean isActive) {
        setid(id);
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setActive(isActive);
    }
}