
public class Student {
    private String studentID;
    private String studentName;
    private String programme;
    private int yearOfStudy;
    private StudentCategory category;

    public enum StudentCategory {
        UNDERGRADUATE,
        POSTGRADUATE,
        EXCHANGE
    }

    public Student() {
        this.studentID = "";
        this.studentName = "";
        this.programme = "";
        this.yearOfStudy = 0;
        this.category = StudentCategory.UNDERGRADUATE;
    }

    public Student(String studentID, String studentName, String programme, int yearOfStudy, StudentCategory category) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.programme = programme;
        this.yearOfStudy = yearOfStudy;
        this.category = category;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public StudentCategory getCategory() {
        return category;
    }

    public void setCategory(StudentCategory category) {
        this.category = category;
    }
    
    public void displayStudentInfo() {
            System.out.println("========================================");
            System.out.println("Student Information Details");
            System.out.println("========================================");
            System.out.println();
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentName);
            System.out.println("Programme: " + programme);
            System.out.println("Year of Study: " + yearOfStudy);
            System.out.println("Category: " + category);
        }

}