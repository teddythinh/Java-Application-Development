package pojo;

public class StudentPOJO {
    int id;
    int mssv;
    String hoTen;
    double gpa;

    public StudentPOJO(int id, int mssv, String hoTen, double gpa) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String toString() {
        return "StudentPOJO{" +
                "id=" + id +
                ", mssv=" + mssv +
                ", hoTen='" + hoTen + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
