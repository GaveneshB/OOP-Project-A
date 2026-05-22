import java.util.Scanner;
import java.util.Vector;

public class SystemMain {
    static Student[] students = new Student[100];
    static int studentCount = 0;
    static Vector<EquipmentBorrowing> borrow_List = new Vector<>();
    static Vector<IssueReport> issue_List = new Vector<>();


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
                System.out.println("ID: " + student.getStudentID());
                System.out.println("Name: " + student.getStudentName());
                System.out.println("Programme: " + student.getProgramme());
                System.out.println("Year of Study: " + student.getYearOfStudy()); 
                System.out.println("Category: " + student.getCategory());
                System.out.println("----------------------------------------");
            }
        }   
    }

    static void searchStudentByID(String student_ID) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            if (student.getStudentID().equals(student_ID)) {
                System.out.println("Student found:");
                System.out.println("----------------------------------------");
                System.out.println("ID: " + student.getStudentID());
                System.out.println("Name: " + student.getStudentName());
                System.out.println("Programme: " + student.getProgramme());
                System.out.println("Year of Study: " + student.getYearOfStudy()); 
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
    
    // Equipment Borrowing System
    static void addBorrowingRecord() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String student_ID = input.nextLine(); 
        System.out.println("Equipment Type : LAPTOP/PROJECTOR/CAMERA/SENSOR_KIT");
        System.out.print("Enter Equipment Type: ");
        String equipment_Type = input.nextLine();
        System.out.print("Enter Borrowing Days: "); 
        int borrow_Days = input.nextInt();
        input.nextLine();
        EquipmentBorrowing newBorrowing = new EquipmentBorrowing(student_ID, EquipmentType.valueOf(equipment_Type.toUpperCase()), borrow_Days);
        borrow_List.add(newBorrowing);
    }
    
    static void displayAllBorrowing() {
        for (int i = 0; i < borrow_List.size(); i++) {
            EquipmentBorrowing borrowing = borrow_List.get(i);
            System.out.println("----------------------------------------");
            System.out.println("Student ID: " + borrowing.getStudentId());
            System.out.println("Equipment Type: " + borrowing.getEquipmentType());
            System.out.println("Borrowing Days: " + borrowing.getBorrowDays());
        }
        System.out.println("----------------------------------------");
    }
    
    static void searchBorrowingByID(String student_ID) {
        boolean found = false;
        for (int i = 0; i < borrow_List.size(); i++) {
            EquipmentBorrowing borrowing = borrow_List.get(i);
            if (borrowing.getStudentId().equals(student_ID)) {
                System.out.println("Borrowing record found:");
                System.out.println("----------------------------------------");
                System.out.println("Student ID: " + borrowing.getStudentId());
                System.out.println("Equipment Type: " + borrowing.getEquipmentType());
                System.out.println("Borrowing Days: " + borrowing.getBorrowDays());
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No borrowing record found for Student ID: " + student_ID);
        }
    }

    static void calculateTotalBorrowedItems() {
        Scanner input = new Scanner(System.in);
        System.out.println("Total items borrowed across all students: " + borrow_List.size());
    }

    static void checkBorrowingDuration() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID to check their borrowing status: ");
        String search_ID = input.nextLine();
        
        boolean found = false;
        for (int i = 0; i < borrow_List.size(); i++) {
            EquipmentBorrowing borrowing = borrow_List.get(i);
            if (borrowing.getStudentId().equals(search_ID)) {
                System.out.println("Borrowing record found:");
                System.out.println("----------------------------------------");
                System.out.println("Student ID: " + borrowing.getStudentId());
                System.out.println("Equipment Type: " + borrowing.getEquipmentType());
                System.out.println("Borrowing Days: " + borrowing.getBorrowDays());
                System.out.println("Duration Status: " + borrowing.getDurationStatus());
                System.out.println("----------------------------------------");
                found = true;
            }
        }        
        if (!found) {
            System.out.println("No borrowing records found for that ID.");
        }
    }

    public static void equipmentMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---Equipment Borrowing System---");
            System.out.println("1. Add Borrowing Record");
            System.out.println("2. Display All Records");
            System.out.println("3. Search Records by Student ID");
            System.out.println("4. Calculate Total Borrowed Items");
            System.out.println("5. Check Borrowing Duration Rules");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addBorrowingRecord();
                    break;
                case 2:
                    displayAllBorrowing();
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    String student_ID = input.nextLine();
                    searchBorrowingByID(student_ID);
                    break;
                case 4:
                    calculateTotalBorrowedItems();
                    break;
                case 5:
                    checkBorrowingDuration();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    // Issue Reporting System
    static void addIssueReport() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String student_ID = input.nextLine();
        System.out.println("Issue Type : ELECTRICAL/NETWORK/FURNITURE/CLEANLINESS/AIR_CONDITIONING");
        System.out.print("Enter Issue Type: ");
        String issue_Type = input.nextLine();
        System.out.print("Enter Priority Level (LOW/MEDIUM/HIGH/CRITICAL): ");
        String priority = input.nextLine();
        IssueReport newReport = new IssueReport(student_ID, IssueType.valueOf(issue_Type.toUpperCase()), PriorityLevel.valueOf(priority.toUpperCase()));
        issue_List.add(newReport);
        System.out.println("Issue report added successfully.");
    }
    
    static void displayAllIssues() {
        for (IssueReport report : issue_List) {
            System.out.println("----------------------------------------");
            System.out.println("Student ID: " + report.getStudentId());
            System.out.println("Issue Type: " + report.getIssueType());
            System.out.println("Priority Level: " + report.getPriority());
            System.out.println("Status: " + report.getStatus());
        }
        System.out.println("----------------------------------------");
    }

    static void searchIssueByID() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID to search their reports: ");
        String search_ID = input.nextLine();
        
        boolean found = false;
        for (IssueReport report : issue_List) {
            if (report.getStudentId().equals(search_ID)) {
                System.out.println("Issue report found:");
                System.out.println("----------------------------------------");
                System.out.println("Student ID: " + report.getStudentId());
                System.out.println("Issue Type: " + report.getIssueType());
                System.out.println("Priority Level: " + report.getPriority());
                System.out.println("Status: " + report.getStatus());
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No issue reports found for Student ID: " + search_ID);
        }
    }

    static void countReportsByPriority() {
        int lowCount = 0, mediumCount = 0, highCount = 0, criticalCount = 0;
        for (IssueReport report : issue_List) {
            switch (report.getPriority()) {
                case LOW:
                    lowCount++;
                    break;
                case MEDIUM:
                    mediumCount++;
                    break;
                case HIGH:
                    highCount++;
                    break;
                case CRITICAL:
                    criticalCount++;
                    break;
            }
        }
        System.out.println("--- Issue Reports by Priority ---");
        System.out.println("Low: " + lowCount);
        System.out.println("Medium: " + mediumCount);
        System.out.println("High: " + highCount);
        System.out.println("Critical: " + criticalCount);
    }
    
    static void updateReportStatus() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID to update their report status: ");
        String student_ID = input.nextLine();
        boolean found = false;
        for (IssueReport report : issue_List) {
            if (report.getStudentId().equals(student_ID)) {
                System.out.print("Enter new status (OPEN/IN_PROGRESS/RESOLVED/CLOSED): ");
                String newStatus = input.nextLine();
                report.setStatus(ReportStatus.valueOf(newStatus.toUpperCase()));
                System.out.println("Report status updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No issue report found for the given Student ID.");
        }
    }

    public static void issueMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---Facility Issue Reporting---");
            System.out.println("1. Add New Issue Report");
            System.out.println("2. Display All Reports");
            System.out.println("3. Search Issue by Student ID");
            System.out.println("4. Count Reports by Priority");
            System.out.println("5. Update Report Status"); 
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addIssueReport();
                    break;
                case 2:
                    displayAllIssues();
                    break;
                case 3:
                    searchIssueByID();
                    break;
                case 4:
                    countReportsByPriority();
                    break;
                case 5:
                    updateReportStatus();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Student Management System");
            System.out.println("3. Equipment Borrowing System");
            System.out.println("4. Facility Issue Reporting");
            System.out.println("5. Feedback Collection System");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = input.nextInt();
            input.nextLine();

            switch(mainChoice){
                case 1:
                    studentMenu();
                    break;
                case 3:
                    equipmentMenu();
                    break;
                case 4:
                    issueMenu();
                    break;
                case 5:
                    AdditionalFeatureSystem.feedbackMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(mainChoice!= 0);

        
    }

}