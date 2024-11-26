import java.io.*; // For file I/O
import java.text.*; // For date formatting
import java.util.*; // For utilities like Random

public class Updated {

    public static void main(String[] args) {
        // Check if any arguments are passed
        if (args.length == 0) {
            System.out.println("No arguments provided."); // Added meaningful error message
            return;
        }

        // Handle the "a" argument
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("students.txt")
                ))) { // Updated to use try-with-resources for automatic resource management
                String line = reader.readLine(); // Renamed variables for clarity
                String[] students = line.split(","); // More descriptive variable names
                for (String student : students) {
                    System.out.println(student.trim()); // Trim whitespace for cleaner output
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage()); // Enhanced error message
            }
        }

        // Handle the "r" argument
        else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("students.txt")
                ))) {
                String line = reader.readLine();
                String[] students = line.split(",");
                Random random = new Random(); // More descriptive variable names
                int randomIndex = random.nextInt(students.length);
                System.out.println(students[randomIndex].trim());
                System.out.println("Data Loaded."); // Print "Data Loaded." after the name
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Handle the "+" argument
        else if (args[0].startsWith("+")) { // Changed to startsWith for clarity
            System.out.println("Loading data ...");
            try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("students.txt", true) // Open file in append mode
            )) {
                String newStudent = args[0].substring(1).trim(); // Trim whitespace
                Date currentDate = new Date(); // More descriptive variable names
                String dateFormatPattern = "dd/MM/yyyy-hh:mm:ss a"; // Corrected date format
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(currentDate);
                writer.write(", " + newStudent + " - Last updated on " + formattedDate);
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Handle the "?" argument
        else if (args[0].startsWith("?")) { // Changed to startsWith for clarity
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("students.txt")
                ))) {
                String line = reader.readLine();
                String[] students = line.split(",");
                String targetStudent = args[0].substring(1).trim(); // Trim input for consistency
                boolean found = false;
                for (String student : students) {
                    if (student.trim().equals(targetStudent)) {
                        System.out.println("We found it!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found."); // Added message for not found
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        // Handle the "c" argument
        else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(
            	new InputStreamReader(
            	    new FileInputStream("students.txt")
            	))) {
        	String fileContent = reader.readLine(); // Read the entire line
        	int wordCount = fileContent.split("[,\\s]+").length; // Split on commas or spaces and count
        	System.out.println(wordCount + " word(s) found.");
        	System.out.println("Data Loaded.");
           } catch (Exception e) {
           System.out.println("An error occurred: " + e.getMessage());
      }
          }

        // Handle invalid arguments
        else {
            System.out.println("Invalid argument provided."); // Added invalid argument message
        }
    }
}

