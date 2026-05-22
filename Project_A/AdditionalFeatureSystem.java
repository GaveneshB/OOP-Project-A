import java.util.Scanner;
import java.util.Vector;

enum FeedbackCategory {
    FACILITY,
    EQUIPMENT,
    SERVICE,
    GENERAL
}

class StudentFeedback {
    private String studentId;
    private FeedbackCategory category;
    private String feedbackMessage;
    private int rating;

    public StudentFeedback(String studentId, FeedbackCategory category,
                           String feedbackMessage, int rating) {
        this.studentId = studentId;
        this.category = category;
        this.feedbackMessage = feedbackMessage;
        this.rating = rating;
    }


    public String getStudentId() {
        return studentId;
    }

    public FeedbackCategory getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public void displayFeedback() {
        System.out.println("Student ID      : " + studentId);
        System.out.println("Category        : " + category);
        System.out.println("Feedback        : " + feedbackMessage);
        System.out.println("Rating          : " + rating + "/5");
        System.out.println("-----------------------------------");
    }
}

public class AdditionalFeatureSystem {

    static Vector < StudentFeedback> feedbackList = new Vector<>();
    static Scanner sc = new Scanner(System.in);

    public static void feedbackMenu() {

        int choice;

        do {
            System.out.println("=================================");
            System.out.println(" STUDENT FEEDBACK COLLECTION ");
            System.out.println("════════════════════════════════");
            System.out.println("1. Add Feedback");
            System.out.println("2. Display All Feedback");
            System.out.println("3. Search Feedback by Student ID");
            System.out.println("4. Calculate Average Rating");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    addFeedback();
                    break;

                case 2:
                    displayAllFeedback();
                    break;

                case 3:
                    searchFeedback();
                    break;

                case 4:
                    calculateAverageRating();
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    public static void addFeedback() {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.println("Feedback Category:");
        System.out.println("1. FACILITY");
        System.out.println("2. EQUIPMENT");
        System.out.println("3. SERVICE");
        System.out.println("4. GENERAL");
        System.out.print("Choose category: ");

        int categoryChoice = sc.nextInt();
        sc.nextLine();

        FeedbackCategory category=null;

        switch(categoryChoice){
            case 1:
                category = FeedbackCategory.FACILITY;
                break;

            case 2:
                category = FeedbackCategory.EQUIPMENT;
                break;

            case 3:
                category = FeedbackCategory.SERVICE;
                break;

            case 4:
                category = FeedbackCategory.GENERAL;
                break;

            default:
                System.out.println("Invalid category!");
                return;
        }

        System.out.print("Enter Feedback Message: ");
        String message = sc.nextLine();

        System.out.print("Enter Rating (1-5): ");
        int rating = sc.nextInt();

        StudentFeedback feedback =
                new StudentFeedback(id, category, message, rating);

        feedbackList.add(feedback);

        System.out.println("Feedback added successfully!");
    }

     public static void displayAllFeedback() {

        if(feedbackList.isEmpty()){
            System.out.println("No feedback records found.");
        } else {

            System.out.println("\n===== FEEDBACK RECORDS =====");

            for (int i = 0; i < feedbackList.size(); i++) {
                feedbackList.get(i).displayFeedback();
            }
        }
        
    }

    public static void searchFeedback(){

        System.out.print("Enter Student ID to search: ");
        String searchId = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < feedbackList.size(); i++) {

            if (feedbackList.get(i).getStudentId().equalsIgnoreCase(searchId)) {

                feedbackList.get(i).displayFeedback();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No feedback found for this Student ID.");
        }
    }

    public static void calculateAverageRating() {

        if (feedbackList.isEmpty()){
            System.out.println("No feedback available.");
        } else {

            int total = 0;

            for (int i = 0; i < feedbackList.size(); i++) {
                total += feedbackList.get(i).getRating();
            }

            double average = (double) total / feedbackList.size();

            System.out.println("Average Rating: " + average);
        }
    }
}