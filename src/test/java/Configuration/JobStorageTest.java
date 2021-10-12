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
    public void resetJobs() throws IOException {
        FileWriter file = new FileWriter("jobs.json");
        file.write("[]");
        file.close();
    }

    @Test
    public void addJob() throws Exception {
        JobStorage.addJob(jobA);
    }

    @Test
    public void addAndGetJob() throws Exception {
        JobStorage.addJob(jobA);
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
    }

    @Test
    public void getWrongJob() {

        try {
            JobStorage.getJob(jobA.getName());
        } catch (Exception e) {
            return;
        }
        fail("no Exception was caught!");

    }

    @Test
    public void addJobTwice() throws Exception {
        JobStorage.addJob(jobA);
        try {
            JobStorage.addJob(jobA);
        } catch (Exception e) {
            return;
        }
        fail("Same job was added twice!");
    }

    @Test
    public void addTwoJobs() throws Exception {
        JobStorage.addJob(jobA);
        JobStorage.addJob(jobB);
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
        assertEquals(jobB, JobStorage.getJob(jobB.getName()));
    }

    @Test
    public void removeJob() throws Exception {
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
    public void removeNonexistentJob() throws Exception {
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
    public void removeDifferentJob() throws Exception {
        JobStorage.addJob(jobA);
        JobStorage.addJob(jobB);
        JobStorage.removeJob(jobB.getName());
        assertEquals(jobA, JobStorage.getJob(jobA.getName()));
    }
}