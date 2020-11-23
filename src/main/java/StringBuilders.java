import java.util.List;

class StringBuilders {

    //get names from list of objects for toString
    public static String getCourseList(List<Course> courses) {
        StringBuilder courseList = new StringBuilder();
        for (Course c : courses) {
            courseList.append(c.getCourseName()).append(", ");
        }
        return courseList.toString();
    }

    public static String getModuleList(List<Module> modules) {
        StringBuilder moduleList = new StringBuilder();
        for (Module m : modules) {
            moduleList.append(m.getModuleName()).append(", ");
        }
        return moduleList.toString();
    }

    public static String getStudentList(List<Student> students) {
        StringBuilder studentList = new StringBuilder();
        for (Student s : students) {
            studentList.append(s.getStudentName()).append(", ");
        }
        return studentList.toString();
    }

}
