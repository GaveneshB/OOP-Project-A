public class Student {
    private String student_ID;
    private String student_Name;
    private String programme;
    private int year_Of_Study;
    private StudentCategory category;

    public enum StudentCategory {
        UNDERGRADUATE,
        POSTGRADUATE,
        EXCHANGE
    }

    public Student() {
        this.student_ID = "";
        this.student_Name = "";
        this.programme = "";
        this.year_Of_Study = 0;
        this.category = StudentCategory.UNDERGRADUATE;
    }

    public Student(String student_ID, String student_Name, String programme, int year_Of_Study, StudentCategory category) {
        this.student_ID = student_ID;
        this.student_Name = student_Name;
        this.programme = programme;
        this.year_Of_Study = year_Of_Study;
        this.category = category;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getYear_Of_Study() {
        return year_Of_Study;
    }

    public void setYear_Of_Study(int year_Of_Study) {
        this.year_Of_Study = year_Of_Study;
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
            System.out.println("Student ID: " + student_ID);
            System.out.println("Student Name: " + student_Name);
            System.out.println("Programme: " + programme);
            System.out.println("Year of Study: " + year_Of_Study);
            System.out.println("Category: " + category);
        }

}