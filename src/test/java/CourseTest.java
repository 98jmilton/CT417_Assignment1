import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

public class CourseTest {
    private static Student testStudent;
    private static Course testCourse;
    private static Module testModule;

    @BeforeClass
    public static void setup() {
        testStudent = new Student("James", "1998-6-11");
        testCourse = new Course("Test", new DateTime("2020-08-01T00:0:00Z"), new DateTime("2021-5-30T00:0:00Z"));
        testModule = new Module("Test", "CT101");
    }

    @Test
    public void testAddModuleSucceeds() {
        testCourse.addModule(testModule);
        assert (testCourse.getCourseModuleList().size() == 1);

        //reset test
        setup();
    }

    @Test
    public void testAddModuleFails() {
        testCourse.addModule(testModule);
        testCourse.addModule(testModule);
        assert !(testCourse.getCourseModuleList().size() > 1);

        //reset test
        setup();
    }

    @Test
    public void testEnrollCourseSucceeds() {
        testCourse.enrollCourse(testStudent);
        assert (testCourse.getCourseStudentList().size() == 1);

        //reset test
        setup();
    }

    @Test
    public void testEnrollCourseFails() {
        testCourse.enrollCourse(testStudent);
        testCourse.enrollCourse(testStudent);
        assert !(testCourse.getCourseStudentList().size() > 1);

        //reset test
        setup();
    }
}
