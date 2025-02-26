import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A program that reads a list of integer numbers from user input,
 * stores them in a LinkedList, sorts them in ascending order,
 * prints the sorted list, and saves it to a file.
 *
 * This program follows best coding practices and uses the Java Collections Framework.
 * It is designed to be run from the command line without needing an IDE.
 *
 * To compile:
 * javac SortedLinkedList.java
 *
 * To run:
 * java SortedLinkedList
 *
 * To generate Javadoc:
 * javadoc -d docs SortedLinkedList.java
 */
public class SortedLinkedList {

    /**
     * Reads integers from standard input, stores them in a LinkedList,
     * sorts the list, prints the sorted numbers, and saves them to a file.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> numbers = new LinkedList<>();

        System.out.println("Enter integers (type 'done' to finish):");

        // Read input and store in LinkedList
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
                }
            }
        }
        scanner.close();

        // Sort the LinkedList
        Collections.sort(numbers);

        // Print the sorted numbers
        System.out.println("Sorted List: " + numbers);

        // Save sorted list to a file
        saveToFile(numbers);
    }

    /**
     * Saves the sorted list of integers to a text file.
     *
     * @param numbers The sorted LinkedList of integers.
     */
    private static void saveToFile(LinkedList<Integer> numbers) {
        try (FileWriter writer = new FileWriter("sorted_numbers.txt")) {
            for (int num : numbers) {
                writer.write(num + "\n");
            }
            System.out.println("Sorted list saved to sorted_numbers.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}
