import Configuration.Job;
import Configuration.JobStorage;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AppTest {

    private final Job jobA = new Job("jobA", "sourceA", "targetA");
    private final Job jobB = new Job("jobB", "sourceB", "targetB");

    @Before
    public void resetJobs() throws IOException {
        FileWriter file = new FileWriter("jobs.json");
        file.write("[]");
        file.close();
    }

    @Test
    public void testAddJob() throws Exception {
        App.runCommand(new String[]{"addjob", jobA.getName(), jobA.getSource(), jobA.getTarget()});
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
    }

    @Test
    public void testRemoveJob() throws Exception {
        JobStorage.addJob(jobA);
        App.runCommand(new String[]{"removejob", jobA.getName()});
        try {
            JobStorage.getJob(jobA.getName());
        } catch (Exception e) {
            return;
        }
        fail("No Exception was caught!");
    }

    @Test
    public void testInvalidRemove() {
        try {
            App.runCommand(new String[]{"removejob", jobA.getName()});
        } catch (Exception e) {
            return;
        }
        fail("No Exception was caught!");
    }
}




