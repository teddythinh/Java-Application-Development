class Vehicle {
    private int passengers;
    private int fuelcaps;
    private int mpg;

    // viết hàm getters và setters thì viết hoa chữ cái đầu của biến, còn lại viết thường
    // tránh việc các ORM database không nhận được
    // với biến boolean thì hàm getter đặt là is...
    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFuelcaps() {
        return fuelcaps;
    }

    public void setFuelcaps(int fuelcaps) {
        this.fuelcaps = fuelcaps;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }
}

public class OOP {
    public static void main(String args[]) {

    }
}
