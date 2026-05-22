import java.util.Scanner;


public class SystemMain {
    static Student[] students = new Student[100];
    static int studentCount = 0;
    


    static void addStudent(Student student) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String student_ID = input.nextLine();
        System.out.print("Enter Student Name: ");
        String student_Name = input.nextLine();
        System.out.print("Enter Programme: ");
        String programme = input.nextLine();
        System.out.print("Enter Year of Study: ");
        int year_Of_Study = input.nextInt();
        input.nextLine(); 
        System.out.print("Enter Category (UNDERGRADUATE/POSTGRADUATE/EXCHANGE): ");
        String categoryStr = input.nextLine();
        Student.StudentCategory category = Student.StudentCategory.valueOf(categoryStr.toUpperCase());
        
        Student newStudent = new Student(student_ID, student_Name, programme, year_Of_Study, category);
        students[studentCount++] = newStudent;
    }

    static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students registered.");
        } else {
            System.out.println("List of Students:");
            for (int i = 0; i < studentCount; i++) {
                Student student = students[i];
                System.out.println("----------------------------------------");
                System.out.println("ID: " + student.getStudent_ID());
                System.out.println("Name: " + student.getStudent_Name());
                System.out.println("Programme: " + student.getProgramme());
                System.out.println("Year of Study: " + student.getYear_Of_Study()); 
                System.out.println("Category: " + student.getCategory());
                System.out.println("----------------------------------------");
            }
        }   
    }

    static void searchStudentByID(String student_ID) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            if (student.getStudent_ID().equals(student_ID)) {
                System.out.println("Student found:");
                System.out.println("----------------------------------------");
                System.out.println("ID: " + student.getStudent_ID());
                System.out.println("Name: " + student.getStudent_Name());
                System.out.println("Programme: " + student.getProgramme());
                System.out.println("Year of Study: " + student.getYear_Of_Study()); 
                System.out.println("Category: " + student.getCategory());
                System.out.println("----------------------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + student_ID + " not found.");
        }
    }

    static void countByCategory() {
        int undergraduateCount = 0;
        int postgraduateCount = 0;
        int exchangeCount = 0;

        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            switch (student.getCategory()) {
                case UNDERGRADUATE:
                    undergraduateCount++;
                    break;
                case POSTGRADUATE:
                    postgraduateCount++;
                    break;
                case EXCHANGE:
                    exchangeCount++;
                    break;
            }
        }

        System.out.println("Student Count by Category:");
        System.out.println("Undergraduate: " + undergraduateCount);
        System.out.println("Postgraduate: " + postgraduateCount);
        System.out.println("Exchange: " + exchangeCount);
    }

    public static void studentMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---Student Management System---");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Count Students by Category");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(new Student());
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    String student_ID = input.nextLine();
                    searchStudentByID(student_ID);
                    break;
                case 4:
                    countByCategory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        input.close();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Student Management System");
            System.out.println("5. Feedback Collection System");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = input.nextInt();
            input.nextLine();

            switch(mainChoice){
                case 1:
                    studentMenu();
                    break;
                case 5:
                    AdditionalFeatureSystem.feedbackMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(mainChoice!= 3);

        
    }

}