public class Booking {

    enum FacilityType { 
        STUDY_ROOM, COMPUTER_LAB, SPORT_COURT, SEMINAR_ROOM 
} 
    enum TimeSlot { 
        MORNING, AFTERNOON, EVENING 
} 
    enum BookingStatus { 
        PENDING, APPROVED, REJECTED, CANCELLED 
} 

    private String bookingID;
    private String studentID;
    private int duration;
    private FacilityType facilityType;
    private TimeSlot timeSlot;
    private BookingStatus bookingStatus;

    public Booking() {
        this.bookingID = "";
        this.studentID = "";
        this.facilityType = FacilityType.STUDY_ROOM;
        this.timeSlot = TimeSlot.MORNING;
        this.bookingStatus = BookingStatus.PENDING;
        this.duration = 0;
    }

    public Booking(String bookingID, String studentID, int duration, FacilityType facilityType, TimeSlot timeSlot, BookingStatus bookingStatus) {
        this.bookingID = bookingID;
        this.studentID = studentID;
        this.duration = duration;
        this.facilityType = facilityType;
        this.timeSlot = timeSlot;
        this.bookingStatus = bookingStatus;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}