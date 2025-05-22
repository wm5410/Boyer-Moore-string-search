/**
 * Student 1: William Malone ID: 1604564
 * Student 2: Justin Poutoa ID: 1620107
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BMSearch {
    private static String searchString;
    public static void main(String[] args) {
        // Check if command-line arguments are provided correctly
        if (args.length != 2) {
            System.err.println("Usage: java BMSearch <skip_array_file> <text_file>");
            System.exit(1);
        }

        // Parse command-line arguments
        String skipArrayFile = args[0];
        String textFile = args[1];

        // Load the skip array and search for the target string in the text file
        try{
            loadSkipArray(skipArrayFile);
            searchInText(textFile);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Function to load the skip array for processing from the skip array file
    private static void loadSkipArray(String skipArrayFile) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(skipArrayFile))){
            //The first line contains the word, so extract it
            String line = reader.readLine();
            String resultString = line.replaceAll("[,*]", "");
            searchString = resultString;
        }
    }

    // Function to search for target string in text file
    private static void searchInText(String textFile) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(textFile))){
            String line;
            boolean found = false;

            //Search for word
            while ((line = br.readLine()) != null){
                //If word is found in the line, display the line
                if(line.contains(searchString)){
                    System.out.println(line);
                    found = true;
                }
            }
            if(!found){
                //If word is not found, display message
                System.out.println("Word not found");
            }
        }
    }
}
