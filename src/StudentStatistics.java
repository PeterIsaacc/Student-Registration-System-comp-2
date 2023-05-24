import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentStatistics {
    public static void main(String[] args) {
        // Set the path to the batch files directory
        String AppDataDirectory = System.getenv("DIR_PATH");

        String BatchFilesDirectory = System.getenv("DATA_BATCH");

        // Get the list of batch files
        File[] batchFiles = getBatchFiles(BatchFilesDirectory);
        File dataFile = new File(AppDataDirectory + "/data.csv");

        while (true) {
            // Display the menu
            System.out.println("Main Menu");
            System.out.println("1- Display all data");
            System.out.println("2- Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            }

            // Calculate the statistics
            int numberOfUsers = countUsers(dataFile);
            Map<String, Integer> courseCounts = countCourses(dataFile);
            int numberOfBatchFiles = batchFiles.length;
            int numberOfVerifiedBatchFiles = countVerifiedBatchFiles(batchFiles);

            // Display the statistics
            System.out.println("Number of users: " + numberOfUsers);
            for (Map.Entry<String, Integer> entry : courseCounts.entrySet()) {
                System.out.println("Number of students registered in " + entry.getKey() + " course: " + entry.getValue());
            }
            System.out.println("Number of batch files: " + numberOfBatchFiles);
            System.out.println("Number of verified batch files: " + numberOfVerifiedBatchFiles);
        }
    }

    private static File[] getBatchFiles(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));
    }

    private static int countUsers(File dataFile) {
        // create list of users
        Vector<String> usersList = new Vector<String>();


        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                usersList.add(data[0].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersList.size();
    }

    private static Map<String, Integer> countCourses(File dataFile) {
        Map<String, Integer> courseCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String[] courses = data[2].split(",");
                for (String course : courses) {
                    String trimmedCourse = course.trim();
                    courseCounts.put(trimmedCourse, courseCounts.getOrDefault(trimmedCourse, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseCounts;
    }

    private static int countVerifiedBatchFiles(File[] batchFiles) {
        int count = 0;
        for (File batchFile : batchFiles) {
            if (batchFile.getName().toLowerCase().contains("verified")) {
                count++;
            }
        }
        return count;
    }
}