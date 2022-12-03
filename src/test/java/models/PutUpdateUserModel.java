

package models;

public class PutUpdateUserModel {

    private String userId;

    public String getUserId() {
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

    public PutUpdateUserModel(String userId) {
        setuserId(userId);
    }
}