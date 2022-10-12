package pojo;

import org.apache.ibatis.annotations.Param;

public class appetite {
    private String foodId;
    private String userId;


    public appetite() {

    }

    public appetite(String userId, String foodId) {
        this.userId = userId;
        this.foodId = foodId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @Override
    public String toString() {
        return "appetite{" +
                "userId='" + userId + '\'' +
                ", foodId='" + foodId + '\'' +
                '}';
    }
}
