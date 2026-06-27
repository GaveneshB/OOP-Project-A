public class StudentInformation {
    protected String student_ID;
    protected String student_Name;
    protected String programme;
    protected int year_Of_Study;

    public StudentInformation() {
        this.student_ID = "";
        this.student_Name = "";
        this.programme = "";
        this.year_Of_Study = 0;
    }

    public StudentInformation(String student_ID, String student_Name, String programme, int year_Of_Study) {
        this.student_ID = student_ID;
        this.student_Name = student_Name;
        this.programme = programme;
        this.year_Of_Study = year_Of_Study;
    }

    public String getStudentID() {
        return student_ID;
    }

    public void setStudentID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudentName() {
        return student_Name;
    }

    public void setStudentName(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getYearOfStudy() {
        return year_Of_Study;
    }

    public void setYearOfStudy(int year_Of_Study) {
        this.year_Of_Study = year_Of_Study;
    }

    public void displayStudentInfo() {
            System.out.println("Student ID: " + getStudentID());
            System.out.println("Student Name: " + getStudentName());
            System.out.println("Programme: " + getProgramme());
            System.out.println("Year of Study: " + getYearOfStudy());
        }
}
