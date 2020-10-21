package training.errorAndExceptions;

public class SubjectsBase {
    private String studentName;
    private String subjectName;
    private int assessment;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public SubjectsBase(String studentName, String subjectName, int assessment) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.assessment = assessment;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

}
