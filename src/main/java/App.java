import Commands.Command;
import Commands.InvalidCommand;
import Commands.JobCommand;
import Commands.JobListCommand;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("args: " + Arrays.toString(args));

        // determine entered command
        Command cmd;
        if ("job".equals(args[0])) {
            cmd = new JobCommand();
        } else if ("joblist".equals(args[0])) {
            cmd = new JobListCommand();
        } else {
            cmd = new InvalidCommand();
        }

        // run command
        cmd.run(args);
    }
}
