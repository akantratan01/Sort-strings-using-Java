import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class SortStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Input number of strings to be inserted in file
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();
 
        try {
            // Open file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
 
            // Insert the strings into file
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the string: ");
                String name = scanner.nextLine();
 
                // Writing into the file
                writer.write(name + "\n");
            }
 
            // Close the writer
            writer.close();
 
            // Open file for reading
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
 
            // Read the lines until end of file is reached
            List<String> names = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
 
            // Close the reader
            reader.close();
 
            // Sort the strings
            Collections.sort(names);
 
            // Open the file for writing
            writer = new BufferedWriter(new FileWriter("file.txt"));
 
            // Insert the sorted strings into the file
            for (String name : names) {
                writer.write(name + "\n");
            }
 
            // Close the writer
            writer.close();
 
            // Print the sorted names
            for (String name : names) {
                System.out.println(name);
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        scanner.close();
    }
}