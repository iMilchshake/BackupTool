import Commands.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("[DEBUG] args: " + Arrays.toString(args));

        // determine entered command
        Command cmd;
        if ("addjob".equals(args[0])) {
            cmd = new AddJobCommand();
        } else if ("removejob".equals(args[0])) {
            cmd = new RemoveJobCommand();
        } else if ("joblist".equals(args[0])) {
            cmd = new JobListCommand();
        } else {
            cmd = new InvalidCommand();
        }

        // run command
        cmd.run(args);
    }
}
