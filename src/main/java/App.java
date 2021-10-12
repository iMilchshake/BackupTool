import Configuration.Job;
import Configuration.JobStorage;
import Util.Backup;

import java.util.Arrays;

import static Configuration.JobStorage.getJob;
import static Util.Constants.HELP_TEXT;

public class App {

    private static final boolean DEBUG = false;

    private static void sanitizeInput(String[] args, int argumentCountMin, int argumentCountMax) throws Exception {
        if (argumentCountMin > args.length - 1 || args.length - 1 > argumentCountMax) {
            throw new Exception(String.format("Invalid Argument Count! -> should be inside [%d, %d]",
                    argumentCountMin, argumentCountMax));
        }
    }

    private static void sanitizeInput(String[] args, int argumentCount) throws Exception {
        sanitizeInput(args, argumentCount, argumentCount);
    }

    public static void runCommand(String[] args) throws Exception {
        if (DEBUG)
            System.out.println("[DEBUG] args: " + Arrays.toString(args));

        if (args.length == 0)
            throw new Exception("No Command was entered!");

        // run entered command
        switch (args[0]) {
            case "addjob":
                sanitizeInput(args, 3);
                JobStorage.addJob(new Job(args[1], args[2], args[3]));
                break;
            case "removejob":
                sanitizeInput(args, 1);
                JobStorage.removeJob(args[1]);
                break;
            case "joblist":
                sanitizeInput(args, 0);
                System.out.println(JobStorage.printJobs());
                break;
            case "run":
                sanitizeInput(args, 1);
                Backup.backup(getJob(args[1]));
                break;
            case "help":
                sanitizeInput(args, 0, 0);
                System.out.println(HELP_TEXT);
                break;
            default:
                throw new Exception("Invalid Command! " + Arrays.toString(args));
        }
    }
}
