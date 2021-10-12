package Configuration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JobTest {

    Job jobA = new Job("jobA", "sourceA", "targetA");
    Job jobA2 = new Job("jobA", "sourceA", "targetA");

    @Test
    public void testToString() {
        assertEquals("name='jobA', source='sourceA', target='targetA'", jobA.toString());
    }

    @Test
    public void testEquals() {
        assertEquals(jobA, jobA2);
    }

    @Test
    public void testToJSONObject() {
        assertEquals("{\"name\":\"jobA\",\"source\":\"sourceA\",\"target\":\"targetA\"}",
                jobA.toJSONObject().toString());
    }
}