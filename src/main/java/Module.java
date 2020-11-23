import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class Module {
    @Getter
    private final String moduleName;
    @Getter
    private final String moduleID;
    @Getter
    private final List<Student> moduleStudentList;
    @Getter
    private final List<Course> moduleCourseList;

    public Module(String moduleName, String moduleID) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
        this.moduleStudentList = new ArrayList<>();
        this.moduleCourseList = new ArrayList<>();
    }

    public void addCourse(Course c) {
        if (!moduleCourseList.contains(c)) {
            moduleCourseList.add(c);
        } else {
            System.out.println(" > Error adding course \"" + c.getCourseName() + "\" to module \"" + this.getModuleName() + "\": Module already added");
        }
    }

    public void enrollModule(Student s) {
        if (!moduleStudentList.contains(s)) {
            moduleStudentList.add(s);
        } else {
            System.out.println(" > Error adding student \"" + s.getUsername() + "\" to course \"" + this.getModuleName() + "\": Student already added");
        }
    }

    @Override
    public String toString() {
        return "********************\nModule Details: " +
                "\n Name: " + this.getModuleName() + "\n ID: " + this.getModuleID() +
                "\n Courses: " + StringBuilders.getCourseList(moduleCourseList) + "\n Students: " + StringBuilders.getStudentList(moduleStudentList);
    }
}
