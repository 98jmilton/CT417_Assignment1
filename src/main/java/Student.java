import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.ArrayList;
import java.util.List;

class Student {
    @Getter
    private final String studentName;
    @Getter
    private final int studentAge;
    @Getter
    private final String studentDOB;
    @Getter
    private final int studentID;
    @Getter
    private final List<Course> studentCoursesList;
    @Getter
    private final List<Module> studentModulesList;

    private static int idNum = 100000;

    public Student(String studentName, String studentDOB) {
        DateTime today = new DateTime();
        DateTime dob = new DateTime(studentDOB);
        Years years = Years.yearsBetween(dob, today);

        this.studentName = studentName;
        this.studentAge = years.getYears();
        this.studentDOB = studentDOB;
        this.studentCoursesList = new ArrayList<>();
        this.studentModulesList = new ArrayList<>();
        this.studentID = idNum;
        idNum++;
    }

    //create username for student, without spaces
    public String getUsername() {
        return getStudentName().replaceAll("\\s+", "") + getStudentAge();
    }

    //Enrolls student in course and module
    public void enrollStudent(Course c, List<Module> modules) {
        if (!studentCoursesList.contains(c)) {
            studentCoursesList.add(c);
            for (Module m : modules) {
                studentModulesList.add(m);
                m.enrollModule(this);
                c.enrollCourse(this);
            }
        } else{
            System.out.println(" > Error adding student \""+this.getUsername()+"\" to course \""+c.getCourseName()+"\": Student already enrolled");
        }
    }

    @Override
    public String toString() {
        return "********************\nStudent Details: " +
                "\n Name: " + this.getStudentName() + "\n Username: " + this.getUsername() +
                "\n Age: " + this.getStudentAge() + "\n ID: " + this.getStudentID() +
                "\n Courses: " + StringBuilders.getCourseList(studentCoursesList) + "\n Modules: " + StringBuilders.getModuleList(studentModulesList);
    }
}
