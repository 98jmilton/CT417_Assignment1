import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private static Student testStudent;
    private static Course testCourse;
    private static Module testModule;
    private static List<Module> testModuleList;

    @BeforeClass
    public static void setup() {
        testStudent = new Student("James Milton", "1998-9-12");
        testCourse = new Course("Test", new DateTime("2020-08-01T00:0:00Z"), new DateTime("2021-5-30T00:0:00Z"));
        testModule = new Module("Test", "CT101");
        testModuleList = new ArrayList<>();
    }

    @Test
    public void getUsernameReturnsExpectedValue() {
        assertEquals(testStudent.getUsername(), "JamesMilton22");
    }

    @Test
    public void testEnrollStudentSucceeds() {
        testModuleList.add(testModule);
        testStudent.enrollStudent(testCourse, testModuleList);
        assert (testStudent.getStudentCoursesList().size() > 0);
        assert (testStudent.getStudentModulesList().size() > 0);

        //reset test
        setup();
    }

    @Test
    public void testEnrollStudentFails() {
        testModuleList.add(testModule);
        testStudent.enrollStudent(testCourse, testModuleList);
        testStudent.enrollStudent(testCourse, testModuleList);
        assert !(testStudent.getStudentCoursesList().size() > 1);

        //reset test
        setup();
    }
}
