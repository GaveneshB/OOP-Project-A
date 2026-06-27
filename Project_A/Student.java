public class Student extends StudentInformation {
    private StudentCategory category;

    public enum StudentCategory {
        UNDERGRADUATE,
        POSTGRADUATE,
        EXCHANGE
    }

    public Student() {
        super("", "", "", 0);
        this.category = StudentCategory.UNDERGRADUATE;
    }

    public Student(String student_ID, String student_Name, String programme, int year_Of_Study, StudentCategory category) {
        super(student_ID, student_Name, programme, year_Of_Study);
        this.category = category;
    }

    public StudentCategory getCategory() {
        return category;
    }

    public void setCategory(StudentCategory category) {
        this.category = category;
    }
    
    @Override
    public void displayStudentInfo() {
            System.out.println("Student ID: " + getStudentID());
            System.out.println("Student Name: " + getStudentName());
            System.out.println("Programme: " + getProgramme());
            System.out.println("Year of Study: " + getYearOfStudy());
            System.out.println("Category: " + category);
        }

}