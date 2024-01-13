
    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunCLICommand_Java {

    public static void main(String[] args) {
        try {
            // Specify the command to be executed
            String command = "tasklist";

            // Create a process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));

            // Redirect error stream to the input stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the output as needed
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Check the exit code
            if (exitCode == 0) {
                System.out.println("Command executed successfully.");
            } else {
                System.out.println("Command failed. Exit code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}



