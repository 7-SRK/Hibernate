package DbToExcel;

public class Student {
    private int sid;
    private String sname;
    private double marks;

    public Student() {
    }

    public Student(int sid,String sname,double marks){
        this.sid = sid;
        this.sname = sname;
        this.marks = marks;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
