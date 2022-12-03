

package models;

public class PatchSwitchUserActivityModel {

    private String userId;
    private Boolean isActive;

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public PatchSwitchUserActivityModel(String userId, Boolean isActive) {
        setuserId(userId);
        setActive(isActive);
    }
}