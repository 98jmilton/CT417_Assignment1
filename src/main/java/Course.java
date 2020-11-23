import lombok.Getter;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

class Course {
    @Getter
    private final String courseName;
    @Getter
    private final DateTime courseStartDate;
    @Getter
    private final DateTime courseEndDate;
    @Getter
    final
    List<Module> courseModuleList;
    @Getter
    final
    List<Student> courseStudentList;

    public Course(String courseName, DateTime courseStartDate, DateTime courseEndDate) {
        this.courseName = courseName;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseModuleList = new ArrayList<>();
        this.courseStudentList = new ArrayList<>();
    }

    public void addModule(Module m) {
        if (!courseModuleList.contains(m)) {
            courseModuleList.add(m);
        } else{
            System.out.println(" > Error adding module \""+m.getModuleName()+"\" to course \""+this.getCourseName()+"\": Module already added");
        }
    }

    public void enrollCourse(Student s) {
        if (!courseStudentList.contains(s)) {
            courseStudentList.add(s);
        } else{
            System.out.println(" > Error adding student \""+s.getUsername()+"\" to course \""+this.getCourseName()+"\": Student already added");
        }
    }

    @Override
    public String toString() {
        return "********************\nCourse Details: " +
                "\n Name: " + this.getCourseName() + "\n Start Date:" + this.getCourseStartDate().toDate() +
                "\n End Date: " + this.getCourseEndDate().toDate() + "\n Modules: " + StringBuilders.getModuleList(courseModuleList) +
                "\n Students: " + StringBuilders.getStudentList(courseStudentList);
    }
}
