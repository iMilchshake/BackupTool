package Commands;

import Configuration.JobStorage;

public class JobListCommand implements Command {

    @Override
    public void run(String[] args) throws Exception {
        JobStorage.getJobs();
    }
}
