package training.stage2.errorAndExceptions;

public class Student {
    private String studentFullName;
    private String group;
    private String faculty;

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Student(String studentFullName, String group, String faculty) {
        this.studentFullName = studentFullName;
        this.group = group;
        this.faculty = faculty;
    }
}
