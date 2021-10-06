package Commands;

public class JobCommand implements Command {

    @Override
    public void run(String[] args) {
        System.out.println("creating job: " + args[1]);
    }
}
