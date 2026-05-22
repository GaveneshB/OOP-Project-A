enum IssueType {
    ELECTRICAL, NETWORK, FURNITURE, CLEANLINESS, AIR_CONDITIONING
}

enum PriorityLevel {
    LOW, MEDIUM, HIGH, CRITICAL
}

enum ReportStatus {
    OPEN, IN_PROGRESS, RESOLVED, CLOSED
}

class IssueReport {
    private String studentId;
    private IssueType issueType;
    private PriorityLevel priority;
    private ReportStatus status;

    // Constructor
    public IssueReport(String studentId, IssueType issueType, PriorityLevel priority) {
        this.studentId = studentId;
        this.issueType = issueType;
        this.priority = priority;
        this.status = ReportStatus.OPEN;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }
}
