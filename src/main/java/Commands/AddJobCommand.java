package Commands;

import Configuration.Job;
import Configuration.JobStorage;

public class AddJobCommand implements Command {

    @Override
    public void run(String[] args) throws Exception {
        JobStorage.addJob(new Job(args[1], args[2], args[3]));
    }
}
