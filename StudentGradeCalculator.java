import java.util.Scanner;

public class StudentGradeCalculator {

    // Function to calculate grade based on percentage
    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        if (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting program.");
            return;
        }

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Taking input for each subject's marks
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validating input
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
                return;
            }

            totalMarks += marks[i];
        }

        // Calculating average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determining grade
        String grade = calculateGrade(averagePercentage);

        // Displaying results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

