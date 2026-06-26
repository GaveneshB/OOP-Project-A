class ServiceRecord {

    protected String studentId;

    public ServiceRecord(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void displayRecord() {
        System.out.println("Student ID: " + studentId);
    }
}