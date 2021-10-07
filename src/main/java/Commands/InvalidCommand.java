package Commands;

import java.util.Arrays;

public class InvalidCommand implements Command {

    @Override
    public void run(String[] args) throws Exception {
        throw new Exception("Invalid Command! " + Arrays.toString(args));
    }
}
