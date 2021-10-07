import Configuration.Job;
import Configuration.JobStorage;

import java.util.Arrays;

import static Configuration.JobStorage.getJob;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("[DEBUG] args: " + Arrays.toString(args));

        // determine entered command
        if ("addjob".equals(args[0])) {
            JobStorage.addJob(new Job(args[1], args[2], args[3]));
        } else if ("removejob".equals(args[0])) {
            JobStorage.removeJob(args[1]);
        } else if ("joblist".equals(args[0])) {
            JobStorage.printJobs();
        } else if ("run".equals(args[0])) {
            Backup.backup(getJob(args[1]));
        } else {
            throw new Exception("Invalid Command! " + Arrays.toString(args));
        }
    }
}
