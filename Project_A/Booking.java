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

    private String booking_ID;
    private String student_ID;
    private String booking_Date;
    private int duration;
    private FacilityType facility_Type;
    private TimeSlot time_Slot;
    private BookingStatus booking_Status;

    public Booking() {
        this.booking_ID = "";
        this.student_ID = "";
        this.facility_Type = FacilityType.STUDY_ROOM;
        this.time_Slot = TimeSlot.MORNING;
        this.booking_Status = BookingStatus.PENDING;
        this.duration = 0;
        this.booking_Date = "";
    }

    public Booking(String booking_ID, String student_ID, String booking_Date, int duration, FacilityType facility_Type, TimeSlot time_Slot, BookingStatus booking_Status) {
        this.booking_ID = booking_ID;
        this.student_ID = student_ID;
        this.booking_Date = booking_Date;
        this.duration = duration;
        this.facility_Type = facility_Type;
        this.time_Slot = time_Slot;
        this.booking_Status = booking_Status;
    }

    public String getBookingID() {
        return booking_ID;
    }

    public void setBookingID(String booking_ID) {
        this.booking_ID = booking_ID;
    }

    public String getStudentID() {
        return student_ID;
    }

    public void setStudentID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getBookingDate() {
        return booking_Date;
    }

    public void setBookingDate(String booking_Date) {
        this.booking_Date = booking_Date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public FacilityType getFacilityType() {
        return facility_Type;
    }

    public void setFacilityType(FacilityType facility_Type) {
        this.facility_Type = facility_Type;
    }

    public TimeSlot getTimeSlot() {
        return time_Slot;
    }

    public void setTimeSlot(TimeSlot time_Slot) {
        this.time_Slot = time_Slot;
    }

    public BookingStatus getBookingStatus() {
        return booking_Status;
    }

    public void setBookingStatus(BookingStatus booking_Status) {
        this.booking_Status = booking_Status;
    }

}