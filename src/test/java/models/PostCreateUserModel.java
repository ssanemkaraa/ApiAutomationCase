

package models;

public class PostCreateUserModel {

    private String userId;

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        if (!userId.isEmpty()){
            this.userId = userId;
        }
        else {
            throw new NullPointerException();
        }
    }

    public PostCreateUserModel(String userId) {
        setuserId(userId);
    }
}