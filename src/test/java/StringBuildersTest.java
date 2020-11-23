import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringBuildersTest {
    private static Student testStudent1;
    private static Student testStudent2;
    private static Course testCourse1;
    private static Course testCourse2;
    private static Module testModule1;
    private static Module testModule2;

    @BeforeClass
    public static void setup() {
        testStudent1 = new Student("Student A", "1998-9-12");
        testStudent2 = new Student("Student B", "1998-9-12");
        testCourse1 = new Course("Course A", new DateTime("2020-08-01T00:0:00Z"), new DateTime("2021-5-30T00:0:00Z"));
        testCourse2 = new Course("Course B", new DateTime("2020-08-01T00:0:00Z"), new DateTime("2021-5-30T00:0:00Z"));
        testModule1 = new Module("Module A", "CT101");
        testModule2 = new Module("Module B", "CT101");
    }

    @Test
    public void testGetCourseList() {
        List<Course> testCourseList = new ArrayList<>();
        testCourseList.add(testCourse1);
        testCourseList.add(testCourse2);

        String courseNames = StringBuilders.getCourseList(testCourseList);

        assertEquals(courseNames,"Course A, Course B, ");
    }

    @Test
    public void testGetModuleList() {
        List<Module> testModuleList = new ArrayList<>();
        testModuleList.add(testModule1);
        testModuleList.add(testModule2);

        String moduleNames = StringBuilders.getModuleList(testModuleList);

        assertEquals(moduleNames,"Module A, Module B, ");
    }

    @Test
    public void testGetStudentList() {
        List<Student> testStudentList = new ArrayList<>();
        testStudentList.add(testStudent1);
        testStudentList.add(testStudent2);

        String studentNames = StringBuilders.getStudentList(testStudentList);

        assertEquals(studentNames,"Student A, Student B, ");
    }
}
