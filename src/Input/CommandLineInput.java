package Input;
import java.util.Scanner;

public class CommandLineInput implements Input{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void getInput() {
        return scanner.nextLine();
    }
}
