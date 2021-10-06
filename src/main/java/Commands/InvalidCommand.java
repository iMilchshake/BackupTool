package Commands;

import java.util.Arrays;

public class InvalidCommand implements Command{

    @Override
    public void run(String[] args) {
        System.out.println("Invalid Commands! " + Arrays.toString(args));
    }
}
