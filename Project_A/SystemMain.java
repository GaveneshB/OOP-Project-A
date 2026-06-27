import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class SystemMain {
    static Student[] students = new Student[100];
    static int studentCount = 0;
    static Vector<Booking> booking_List = new Vector<>();
    static int bookingCount = 0;
    static Vector<EquipmentBorrowing> borrow_List = new Vector<>();
    static Vector<IssueReport> issue_List = new Vector<>();

    // Student Profile Management System
    public static void addStudent(Student student) {
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

    public static void displayAllStudents() {
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

    public static void searchStudentByID(String student_ID) {
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

    public static void countByCategory() {
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
    }

     // Facility Booking System

    public static void addBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Booking ID: ");
        String booking_ID = input.nextLine();
        System.out.print("Enter Student ID: ");
        String student_ID = input.nextLine();
        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        String booking_Date = input.nextLine();
        System.out.print("Enter Duration (hours): ");
        int duration = input.nextInt();
        input.nextLine(); 
        System.out.println("Facility Type : STUDY_ROOM/COMPUTER_LAB/SPORT_COURT/SEMINAR_ROOM");
        System.out.print("Enter Facility Type: ");
        String facility_Type = input.nextLine();
        System.out.println("Time Slot : MORNING/AFTERNOON/EVENING");
        System.out.print("Enter Time Slot: ");
        String time_Slot = input.nextLine();
        System.out.println("Booking Status : PENDING/APPROVED/REJECTED/CANCELLED");
        System.out.print("Enter Booking Status: ");
        String booking_Status = input.nextLine();

        Booking newBooking = new Booking(booking_ID, student_ID, booking_Date, duration, Booking.FacilityType.valueOf(facility_Type.toUpperCase()), Booking.TimeSlot.valueOf(time_Slot.toUpperCase()), Booking.BookingStatus.valueOf(booking_Status.toUpperCase()));
        booking_List.add(newBooking);
    }

    public static void displayAllBookings() {
        for (Booking booking : booking_List) {
            System.out.println("----------------------------------------");
            System.out.println("Booking ID: " + booking.getBookingID());
            System.out.println("Student ID: " + booking.getStudentID());
            System.out.println("Booking Date: " + booking.getBookingDate());
            System.out.println("Duration: " + booking.getDuration() + " hours");
            System.out.println("Facility Type: " + booking.getFacilityType());
            System.out.println("Time Slot: " + booking.getTimeSlot());
            System.out.println("Booking Status: " + booking.getBookingStatus());
        }
        System.out.println("----------------------------------------");
    }

    public static void searchBookingByStudentID(String student_ID) {
        boolean found = false;
        for (Booking booking : booking_List) {
            if (booking.getStudentID().equals(student_ID)) {
                System.out.println("Booking found:");
                System.out.println("----------------------------------------");
                System.out.println("Booking ID: " + booking.getBookingID());
                System.out.println("Student ID: " + booking.getStudentID());
                System.out.println("Booking Date: " + booking.getBookingDate());
                System.out.println("Duration: " + booking.getDuration() + " hours");
                System.out.println("Facility Type: " + booking.getFacilityType());
                System.out.println("Time Slot: " + booking.getTimeSlot());
                System.out.println("Booking Status: " + booking.getBookingStatus());
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bookings found for Student ID: " + student_ID);
        }
    }

    public static void searchBookingByID(String booking_ID) {
        boolean found = false;
        for (Booking booking : booking_List) {
            if (booking.getBookingID().equals(booking_ID)) {
                System.out.println("Booking found:");
                System.out.println("----------------------------------------");
                System.out.println("Booking ID: " + booking.getBookingID());
                System.out.println("Student ID: " + booking.getStudentID());
                System.out.println("Booking Date: " + booking.getBookingDate());
                System.out.println("Duration: " + booking.getDuration() + " hours");
                System.out.println("Facility Type: " + booking.getFacilityType());
                System.out.println("Time Slot: " + booking.getTimeSlot());
                System.out.println("Booking Status: " + booking.getBookingStatus());
                System.out.println("----------------------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No booking found with ID: " + booking_ID);
        }
    }

    public static void calculateTotalDuration() {
        int totalDuration = 0;
        for (Booking booking : booking_List) {
            totalDuration += booking.getDuration();
        }
        System.out.println("Total Duration of All Bookings: " + totalDuration + " hours");
    }

    public static void updateBookingStatus() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Booking ID to update status: ");
        String booking_ID = input.nextLine();
        boolean found = false;
        for (Booking booking : booking_List) {
            if (booking.getBookingID().equals(booking_ID)) {
                System.out.print("Enter new status (PENDING/APPROVED/REJECTED/CANCELLED): ");
                String newStatus = input.nextLine();
                booking.setBookingStatus(Booking.BookingStatus.valueOf(newStatus.toUpperCase()));
                System.out.println("Booking status updated successfully.");
                saveBookingsToFile(); // Save changes to file
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No booking found with the given ID.");
        }
    }

    public static void saveBookingsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookings.txt"))) {
            for (Booking booking : booking_List) {
                writer.write(booking.getBookingID() + "|" +
                             booking.getStudentID() + "|" +
                             booking.getBookingDate() + "|" +
                             booking.getDuration() + "|" +
                             booking.getFacilityType() + "|" +
                             booking.getTimeSlot() + "|" +
                             booking.getBookingStatus());
                writer.newLine();
            }
            System.out.println("Bookings saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }

    public static void loadBookingsFromFile() {
        File file = new File("bookings.txt");
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String bookingID = parts[0];
                    String studentID = parts[1];
                    String bookingDate = parts[2];
                    int duration = Integer.parseInt(parts[3]);
                    Booking.FacilityType facilityType = Booking.FacilityType.valueOf(parts[4]);
                    Booking.TimeSlot timeSlot = Booking.TimeSlot.valueOf(parts[5]);
                    Booking.BookingStatus bookingStatus = Booking.BookingStatus.valueOf(parts[6]);

                    Booking booking = new Booking(bookingID, studentID, bookingDate, duration, facilityType, timeSlot, bookingStatus);
                    booking_List.add(booking);
                }
            }
            System.out.println("Bookings loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading bookings: " + e.getMessage());
        }
    }

    public static void bookingMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---Facility Booking System---");
            System.out.println("1. Add New Booking");
            System.out.println("2. Display All Bookings");
            System.out.println("3. Search Booking by ID");
            System.out.println("4. Search Booking by Student ID");
            System.out.println("5. Calculate Total Duration of Bookings");
            System.out.println("6. Update Booking Status");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addBooking();
                    saveBookingsToFile(); // Save after adding a new booking
                    break;
                case 2:
                    displayAllBookings();
                    break;
                case 3:
                    System.out.print("Enter Booking ID to search: ");
                    String booking_ID = input.nextLine();
                    searchBookingByID(booking_ID);
                    break;
                case 4:
                    System.out.print("Enter Student ID to search bookings: ");
                    String student_ID = input.nextLine();
                    searchBookingByStudentID(student_ID);
                    break;
                case 5:
                    calculateTotalDuration();
                    break;
                case 6:
                    updateBookingStatus();
                    saveBookingsToFile(); // Save changes to file
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
    
    // Equipment Borrowing System
    public static void saveBorrowingRecord(EquipmentBorrowing borrowing) {
    try {
        FileWriter create = new FileWriter("equipment_borrowing.txt", true);

        create.write(borrowing.getStudentId() + "\n");
        create.write(borrowing.getEquipmentType() + "\n");
        create.write(borrowing.getBorrowDays() + "\n");
        create.write(borrowing.getStatus() + "\n");

        create.close();
        System.out.println("Borrowing record saved to file successfully.");
    }
    catch (IOException e) {
        System.out.println("Error saving borrowing record: " + e.getMessage());
    }
}

    public static void addBorrowingRecord() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID: ");
            String student_ID = input.nextLine();

            System.out.println("Equipment Type : LAPTOP/PROJECTOR/CAMERA/SENSOR_KIT");
            System.out.print("Enter Equipment Type: ");
            String equipment_Type = input.nextLine();

            System.out.print("Enter Borrowing Days: ");
            int borrow_Days = input.nextInt();
            input.nextLine();

            EquipmentBorrowing newBorrowing = new EquipmentBorrowing(
                student_ID,
                EquipmentBorrowing.EquipmentType.valueOf(equipment_Type.toUpperCase()),
                borrow_Days
            );

            borrow_List.add(newBorrowing);
            saveBorrowingRecord(newBorrowing);
            System.out.println("Borrowing record added successfully.");
        }

        catch (InputMismatchException e) {
            System.out.println("Wrong input data! Borrowing days must be a number.");
            input.nextLine(); 
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid input! " + e.getMessage());
        }
    }
    
    public static void readBorrowingRecords() {
    try {
        File file = new File("equipment_borrowing.txt");
        Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String studentId = read.nextLine();
                String equipmentType = read.nextLine();
                
                int borrowDays = Integer.parseInt(read.nextLine());
                String status = read.nextLine();

                EquipmentBorrowing borrowing = new EquipmentBorrowing(studentId,EquipmentBorrowing.EquipmentType.valueOf(equipmentType),borrowDays);

                borrowing.setStatus(EquipmentBorrowing.BorrowStatus.valueOf(status));
                borrow_List.add(borrowing);

            }

        read.close();
    }
    catch (IOException e) {
        System.out.println("No file found!");
    }
}
    
    public static void displayAllBorrowing() {
        for (int i = 0; i < borrow_List.size(); i++) {
            EquipmentBorrowing borrowing = borrow_List.get(i);
            System.out.println("----------------------------------------");
            System.out.println("Student ID: " + borrowing.getStudentId());
            System.out.println("Equipment Type: " + borrowing.getEquipmentType());
            System.out.println("Borrowing Days: " + borrowing.getBorrowDays());
        }
        System.out.println("----------------------------------------");
    }
    
    public static void searchBorrowingByID(String student_ID) {
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

    public static void calculateTotalBorrowedItems() {
        Scanner input = new Scanner(System.in);
        System.out.println("Total items borrowed across all students: " + borrow_List.size());
    }

    public static void checkBorrowingDuration() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID to check their borrowing status: ");
        String search_ID = input.nextLine();
        
        boolean found = false;
        for (int i = 0; i < borrow_List.size(); i++) {
            EquipmentBorrowing borrowing = borrow_List.get(i);
            if (borrowing.getStudentId().equals(search_ID)) {
                System.out.println("Borrowing record found:");
                System.out.println("-----------------------------------");
                System.out.println("Student ID: " + borrowing.getStudentId());
                System.out.println("Equipment Type: " + borrowing.getEquipmentType());
                System.out.println("Borrowing Days: " + borrowing.getBorrowDays());
                System.out.println("Duration Status: " + borrowing.getDurationStatus());
                System.out.println("------------------------------------");
                found = true;
            }
        }        
        if (found==false) {
            System.out.println("No borrowing records found for that ID.");
        }
    }

    public static void equipmentMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Equipment Borrowing System");
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
    public static void addIssueReport() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String student_ID = input.nextLine();
        System.out.println("Issue Type : ELECTRICAL/NETWORK/FURNITURE/CLEANLINESS/AIR_CONDITIONING");
        System.out.print("Enter Issue Type: ");
        String issue_Type = input.nextLine();
        System.out.print("Enter Priority Level (LOW/MEDIUM/HIGH/CRITICAL): ");
        String priority = input.nextLine();

        try {
            IssueReport newReport = new IssueReport(
                student_ID,
                IssueReport.IssueType.valueOf(issue_Type.toUpperCase()),
                IssueReport.PriorityLevel.valueOf(priority.toUpperCase())
            );
            issue_List.add(newReport);
            saveIssueReports(); // File Handling: auto-save after adding
            System.out.println("Issue report added successfully.");
        } catch (IllegalArgumentException e) {
            // Catches invalid IssueType or PriorityLevel input
            System.out.println("Invalid input: '" + e.getMessage().split(" ")[3] + "'. Please use the listed options only.");
        }
    }
    
    public static void displayAllIssues() {
        for (IssueReport report : issue_List) {
            System.out.println("----------------------------------------");
            System.out.println("Student ID: " + report.getStudentId());
            System.out.println("Issue Type: " + report.getIssueType());
            System.out.println("Priority Level: " + report.getPriority());
            System.out.println("Status: " + report.getStatus());
        }
        System.out.println("----------------------------------------");
    }

    public static void searchIssueByID() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID to search their reports: ");
        String search_ID = input.nextLine();

        // Exception Handling: validate empty input
        if (search_ID.trim().isEmpty()) {
            System.out.println("Error: Student ID cannot be empty.");
            return;
        }

        boolean found = false;
        for (IssueReport report : issue_List) {
            if (report.getStudentId().equals(search_ID)) {
                System.out.println("Issue report found:");
                System.out.println("Student ID: " + report.getStudentId());
                System.out.println("Issue Type: " + report.getIssueType());
                System.out.println("Priority Level: " + report.getPriority());
                System.out.println("Status: " + report.getStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No issue reports found for Student ID: " + search_ID);
        }
    }

    public static void countReportsByPriority() {
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
        System.out.println("Issue Reports by Priority");
        System.out.println("Low: " + lowCount);
        System.out.println("Medium: " + mediumCount);
        System.out.println("High: " + highCount);
        System.out.println("Critical: " + criticalCount);
    }
    
    public static void updateReportStatus() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID to update their report status: ");
        String student_ID = input.nextLine();

        // Exception Handling: validate empty input
        if (student_ID.trim().isEmpty()) {
            System.out.println("Error: Student ID cannot be empty.");
            return;
        }

        boolean found = false;
        for (IssueReport report : issue_List) {
            if (report.getStudentId().equals(student_ID)) {
                System.out.print("Enter new status (OPEN/IN_PROGRESS/RESOLVED/CLOSED): ");
                String newStatus = input.nextLine();
                try {
                    report.setStatus(IssueReport.ReportStatus.valueOf(newStatus.toUpperCase()));
                    saveIssueReports(); // File Handling: auto-save after update
                    System.out.println("Report status updated successfully.");
                    found = true;
                } catch (IllegalArgumentException e) {
                    // Catches invalid ReportStatus input
                    System.out.println("Invalid status '" + newStatus + "'. Use: OPEN / IN_PROGRESS / RESOLVED / CLOSED");
                }
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
            System.out.println("Facility Issue Reporting");
            System.out.println("1. Add New Issue Report");
            System.out.println("2. Display All Reports");
            System.out.println("3. Search Issue by Student ID");
            System.out.println("4. Count Reports by Priority");
            System.out.println("5. Update Report Status"); 
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (java.util.InputMismatchException e) {
                // Catches non-integer menu input
                System.out.println("Invalid input! Please enter a number between 1-6.");
                input.nextLine(); // clear bad input from buffer
                choice = -1;     // reset to re-show menu
                continue;
            }

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

    // ─── FILE HANDLING: IssueReport ───

    // Saves all issue reports to a text file (one record per line)
    public static void saveIssueReports() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("issue_reports.txt"))) {
            for (IssueReport report : issue_List) {
                // Format: studentId|issueType|priority|status
                writer.write(report.getStudentId() + "|" +
                             report.getIssueType() + "|" +
                             report.getPriority() + "|" +
                             report.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving issue reports: " + e.getMessage());
        }
    }

    // Loads issue reports from the text file into issue_List on startup
    public static void loadIssueReports() {
        File file = new File("issue_reports.txt");
        if (!file.exists()) return; // No file yet, skip loading

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String studentId  = parts[0];
                    IssueReport.IssueType   issueType = IssueReport.IssueType.valueOf(parts[1]);
                    IssueReport.PriorityLevel priority = IssueReport.PriorityLevel.valueOf(parts[2]);
                    IssueReport.ReportStatus  status   = IssueReport.ReportStatus.valueOf(parts[3]);

                    IssueReport report = new IssueReport(studentId, issueType, priority);
                    report.setStatus(status);
                    issue_List.add(report);
                }
            }
            System.out.println("Issue reports loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading issue reports: " + e.getMessage());
        }
    }

    public static void viewSystemSummary() {

    System.out.println("SYSTEM SUMMARY");

    System.out.println("Total Students Registered : " + studentCount);
    System.out.println("Total Facility Bookings   : " + booking_List.size());
    System.out.println("Total Equipment Borrowing : " + borrow_List.size());
    System.out.println("Total Issue Reports       : " + issue_List.size());

    int undergraduate = 0;
    int postgraduate = 0;
    int exchange = 0;

    for (int i = 0; i < studentCount; i++) {

        switch (students[i].getCategory()) {

            case UNDERGRADUATE:
                undergraduate++;
                break;

            case POSTGRADUATE:
                postgraduate++;
                break;

            case EXCHANGE:
                exchange++;
                break;
        }
    }

    System.out.println("Student Category Summary");
    System.out.println("UNDERGRADUATE : " + undergraduate);
    System.out.println("POSTGRADUATE  : " + postgraduate);
    System.out.println("EXCHANGE      : " + exchange);

    int pending = 0;
    int approved = 0;
    int rejected = 0;
    int cancelled = 0;

    for (int i = 0; i < booking_List.size(); i++) {

        switch (booking_List.get(i).getBookingStatus()) {

            case PENDING:
                pending++;
                break;

            case APPROVED:
                approved++;
                break;

            case REJECTED:
                rejected++;
                break;

            case CANCELLED:
                cancelled++;
                break;
        }
    }

    System.out.println("\n--- Booking Status Summary ---");
    System.out.println("PENDING   : " + pending);
    System.out.println("APPROVED  : " + approved);
    System.out.println("REJECTED  : " + rejected);
    System.out.println("CANCELLED : " + cancelled);

    int low = 0;
    int medium = 0;
    int high = 0;
    int critical = 0;

    for (int i = 0; i < issue_List.size(); i++) {

        switch (issue_List.get(i).getPriority()) {

            case LOW:
                low++;
                break;

            case MEDIUM:
                medium++;
                break;

            case HIGH:
                high++;
                break;

            case CRITICAL:
                critical++;
                break;
        }
    }

    System.out.println("\n--- Issue Priority Summary ---");
    System.out.println("LOW      : " + low);
    System.out.println("MEDIUM   : " + medium);
    System.out.println("HIGH     : " + high);
    System.out.println("CRITICAL : " + critical);

    System.out.println("\n====================================");
}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mainChoice;

        readBorrowingRecords();
        loadIssueReports(); // File Handling: load saved issue reports on startup
        loadBookingsFromFile(); // Load bookings from file on startup

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Student Management System");
            System.out.println("2. Facility Booking System");
            System.out.println("3. Equipment Borrowing System");
            System.out.println("4. Facility Issue Reporting");
            System.out.println("5. Feedback Collection System");
            System.out.println("6. View System Summary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = input.nextInt();
            input.nextLine();

            switch(mainChoice){
                case 1:
                    studentMenu();
                    break;
                case 2:
                    bookingMenu();
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
                case 6:
                    viewSystemSummary();
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