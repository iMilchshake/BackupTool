package Configuration;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JobStorage {

    private static final String file = "jobs.json";

    private static JSONArray readFile() throws Exception {
        String fileContent = Files.readString(Path.of(file));

        try {
            return new JSONArray(fileContent);
        } catch (Exception e) {
            throw new Exception("Error while parsing jobs.json");
        }
    }

    private static void saveFile(JSONArray json) throws IOException {
        FileWriter file = new FileWriter("jobs.json");
        file.write(json.toString(1));
        file.close();
    }

    private static int getJobIndex(String jobName, JSONArray jobs) {
        for (int i = 0; i < jobs.length(); i++) {
            if (jobName.equals(jobs.getJSONObject(i).getString("name"))) {
                return i;
            }
        }
        return -1;
    }

    public static Job getJob(String jobName) throws Exception {
        JSONArray jobs = readFile();
        for (int i = 0; i < jobs.length(); i++) {
            JSONObject jobObject = jobs.getJSONObject(i);
            if (jobName.equals(jobObject.getString("name"))) {
                return new Job(jobObject);
            }
        }
        throw new Exception(String.format("Job '%s' was not found", jobName));
    }

    public static void addJob(Job job) throws Exception {
        JSONArray jobs = readFile();
        int jobIndex = getJobIndex(job.getName(), jobs);

        if (jobIndex == -1) {
            jobs.put(job.toJSONObject());
            saveFile(jobs);
            System.out.printf("Job '%s' was successfully added \n", job.getName());
        } else {
            throw new Exception(String.format("A Job with the name '%s' already exists", job.getName()));
        }
    }

    public static void removeJob(String jobName) throws Exception {
        JSONArray jobs = readFile();
        int jobIndex = getJobIndex(jobName, jobs);

        if (jobIndex != -1) {
            jobs.remove(jobIndex);
            saveFile(jobs);
            System.out.printf("Job '%s' was successfully removed \n", jobName);
        } else {
            throw new Exception(String.format("Job '%s' was not found", jobName));
        }
    }

    public static void printJobs() throws Exception {
        JSONArray jobs = readFile();
        for (int i = 0; i < jobs.length(); i++) {
            System.out.println("[" + i + "] - " + new Job(jobs.getJSONObject(i)));
        }
    }
}
