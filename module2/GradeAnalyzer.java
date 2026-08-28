import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("Scores.txt");

        if (scores.isEmpty()) {
            System.out.println("No valid scores found.");
            return;
        }

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > high) high = score;
            if (score < low) low = score;
        }

        // Step 3: write and print report
        writeReport(scores, avg, high, low, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Warning: skipping invalid line: " + line);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // Count the grade bands
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score >= 90) countA++;
            else if (score >= 80) countB++;
            else if (score >= 70) countC++;
            else if (score >= 60) countD++;
            else countF++;
        }

        // Build the report text once, then send it to both the screen and the file
        String report =
              String.format("===== Grade Report =====%n")
            + String.format("Scores processed: %d%n", scores.size())
            + String.format("Average score:    %.2f%n", avg)
            + String.format("Highest score:    %d%n", high)
            + String.format("Lowest score:     %d%n", low)
            + String.format("%n--- Grade Distribution ---%n")
            + String.format("A (90-100): %d%n", countA)
            + String.format("B (80-89):  %d%n", countB)
            + String.format("C (70-79):  %d%n", countC)
            + String.format("D (60-69):  %d%n", countD)
            + String.format("F (0-59):   %d%n", countF);

        System.out.print(report);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(report);
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}