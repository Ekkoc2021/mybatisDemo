package pojo;

public class food {
    private String id;
    private String name;
    private String canteen;
    private String floor;
    public food(){

    }
    public food(String id, String name, String canteen, String floor) {
        this.id = id;
        this.name = name;
        this.canteen = canteen;
        this.floor = floor;
    }

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

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "foodList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", canteen='" + canteen + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
