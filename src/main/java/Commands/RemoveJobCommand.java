package Commands;

import Configuration.JobStorage;

public class RemoveJobCommand implements Command {
    @Override
    public void run(String[] args) throws Exception {
        JobStorage.removeJob(args[1]);
    }
}
