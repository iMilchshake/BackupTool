package Configuration;

import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class JobStorageTest {

    Job jobA = new Job("jobA", "sourceA", "targetA");
    Job jobB = new Job("jobB", "sourceB", "targetB");

    @Before
    public void TestResetJobs() throws IOException {
        FileWriter file = new FileWriter("jobs.json");
        file.write("[]");
        file.close();
    }

    @Test
    public void TestAddJob() throws Exception {
        JobStorage.addJob(jobA);
    }

    @Test
    public void TestAddAndGetJob() throws Exception {
        JobStorage.addJob(jobA);
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
    }

    @Test
    public void TestGetWrongJob() {

        try {
            JobStorage.getJob(jobA.getName());
        } catch (Exception e) {
            return;
        }
        fail("no Exception was caught!");

    }

    @Test
    public void TestAddJobTwice() throws Exception {
        JobStorage.addJob(jobA);
        try {
            JobStorage.addJob(jobA);
        } catch (Exception e) {
            return;
        }
        fail("Same job was added twice!");
    }

    @Test
    public void TestAddTwoJobs() throws Exception {
        JobStorage.addJob(jobA);
        JobStorage.addJob(jobB);
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
        assertEquals(jobB, JobStorage.getJob(jobB.getName()));
    }

    @Test
    public void TestRemoveJob() throws Exception {
        JobStorage.addJob(jobA);
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
        JobStorage.removeJob(jobA.getName());

        // try to get job that was removed
        try {
            JobStorage.getJob(jobA.getName());
        } catch (Exception e) {
            return;
        }
        fail("no Exception was caught!");
    }

    @Test
    public void TestRemoveNonexistentJob() throws Exception {
        JobStorage.addJob(jobA);
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
        try {
            JobStorage.removeJob(jobB.getName());
        } catch (Exception e) {
            return;
        }
        fail("No Exception was caught!");
    }

    @Test
    public void TestRemoveDifferentJob() throws Exception {
        JobStorage.addJob(jobA);
        JobStorage.addJob(jobB);
        JobStorage.removeJob(jobB.getName());
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
    }

    @Test
    public void TestJoblist() throws Exception {
        JobStorage.addJob(jobA);
        JobStorage.addJob(jobB);
        assertEquals("[0] - name='jobA', source='sourceA', target='targetA'\n" +
                "[1] - name='jobB', source='sourceB', target='targetB'\n", JobStorage.printJobs());
    }
}