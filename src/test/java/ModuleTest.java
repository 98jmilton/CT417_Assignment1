import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModuleTest {
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
    public void testAddCourseSucceeds() {
        testModule.addCourse(testCourse);
        assert (testModule.getModuleCourseList().size() == 1);

        //reset test
        setup();
    }

    @Test
    public void testAddCourseFails() {
        testModule.addCourse(testCourse);
        testModule.addCourse(testCourse);
        assert !(testModule.getModuleCourseList().size() > 1);

        //reset test
        setup();
    }

    @Test
    public void testEnrollModuleSucceeds() {
        testModule.enrollModule(testStudent);
        assert (testModule.getModuleStudentList().size() == 1);

        //reset test
        setup();
    }

    @Test
    public void testEnrollModuleFails() {
        testModule.enrollModule(testStudent);
        testModule.enrollModule(testStudent);
        assert !(testModule.getModuleStudentList().size() > 1);

        //reset test
        setup();
    }
}
