/*
 * Program featuring an array to store and interactively manipulate a list of words.
 */
package arraylistplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordList {
    // VARIABLES LOCAL TO THE CLASS, AND HENCE GLOBAL TO THE METHODS
    private static final int LIMIT = 1000;
    private static ArrayList <String> words = new ArrayList<>(LIMIT);
    private static int numberOfWords = 0;
    private static Scanner commandReader = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // ESTABLISH THE ARRAY OF Words
            readWords();
            // CHECK THE DATA
            System.out.println("\nThe original list of words ...");
            displayWords();
            // ENTER THE INTERPRETER
            interpreter();
        } catch (IOException ex) {
            System.out.println("The file was not found. Please think again.");
            System.exit(-1);
        }
    }

    //Make Compatible with my windows computer
    public static String pathBuilder(){
        String separator = System.getProperty("file.separator");
        String home = null;

        //Make Program Compatible With Windows (I use windows :P )
        if(System.getProperty("os.name").startsWith("Windows")) {
            home = System.getProperty("user.dir");
        }
        else if(System.getProperty("os.name").startsWith("Windows 10")) {
            home = System.getProperty("user.dir");
        }
        else {
            home = System.getProperty("user.home");
        }
        String path = home + separator + "CS1Files" + separator + "data" + separator;
        return path;
    }


    // Assuming that the data file will be found in the public_html/data
    // subdirectory of the user’s home directory.
    private static Scanner establishScanner(String fn, String path) throws FileNotFoundException {
        String fullFileName = path + fn;
        return new Scanner(new File(fullFileName));
    }

    private static void readWords() throws FileNotFoundException {
        Scanner scanner = establishScanner("WordSet.txt",pathBuilder());
        while( scanner.hasNext()) {
            words.add(scanner.next());
            numberOfWords = numberOfWords + 1;
        }

    }

    private static void displayWords() {
        System.out.println("--------------");
        System.out.print("Index #");
        System.out.print(" Element");
        System.out.println();
        System.out.println("--------------");
        for (int x = 0; x < numberOfWords; x = x + 1) {
            System.out.println( (x+1) + "      " + words.get(x));
        }
    }

    private static void interpreter(){
        System.out.print(">>> ");
        String command = commandReader.next();
        if (command.equalsIgnoreCase("DISPLAY")) {
            interpreterDisplayCommand();
        } else if (command.equalsIgnoreCase("PRINT")) {
            interpretPrintCommand();
        } else if (command.equalsIgnoreCase("SWAP")) {
            interpretSwapCommand();
        } else if (command.equalsIgnoreCase("ADD")) {
            interpretAddCommand();
        } else if (command.equalsIgnoreCase("HELP")) {
            interpretHelpCommand();
        } else if(command.equalsIgnoreCase("CLEAR")) {
            interpretClearCommand();
        } else if(command.equalsIgnoreCase("LS")) {
            interpretListCommand(pathBuilder());
        } else if (command.equalsIgnoreCase("EXIT")) {
            System.exit(0);
        } else {
            System.out.println("### Unrecognizable command: " + command);
        }
        interpreter();
    }

    private static void interpreterDisplayCommand() {
        displayWords();
    }

    private static void interpretPrintCommand() {
        String operand = commandReader.next();
        if (operand.equalsIgnoreCase("FIRST")) {
            System.out.println(words.get(0));
        } else if (operand.equalsIgnoreCase("LAST")) {
            System.out.println(words.get(numberOfWords - 1));
        } else {
            int index = Integer.valueOf(operand);
            System.out.println(words.get(index - 1));
        }
    }

    private static void interpretHelpCommand() {
        System.out.println("HELP - display a menu of commands");
        System.out.println("DISPLAY - display the list of words");
        System.out.println("PRINT - print a String (FIRST;LAST;nth)");
        System.out.println("SWAP - exchange two elements (nth;mth)");
        System.out.println("ADD - add a word to the list (FIRST;LAST)");
        System.out.println("CLEAR - clears the console");
        System.out.println("LS - lists file in data directory");
        System.out.println("EXIT - terminate execution of the program");
    }

    private static void interpretSwapCommand() {
        int position1 = commandReader.nextInt() -1; // subtraction of 1 so we won't have to use "exact" values as index input
        int position2 = commandReader.nextInt() -1;
        words.set(position1, words.set(position2 , words.get(position1))); // swapping is here  (no Java.Util.Collections.swap needed)
    }

    private static void interpretAddCommand() {
        String position = commandReader.next();
        if (position.equalsIgnoreCase("LAST")) {
            addLast();
        } else if (position.equalsIgnoreCase("FIRST")) {
            addFirst();
        } else {
            System.out.println("### invalid operand for add command");
        }
        numberOfWords = numberOfWords + 1;
    }


    private static void interpretClearCommand(){
        int intelliJConsoleHistorySize = 300;
        for (int i = 0; i < intelliJConsoleHistorySize;++i) {
            System.out.println();

        }
    }

    private static void interpretListCommand(String path){
        File dataFolder = new File(path);
        File[] listOfFiles = dataFolder.listFiles();
        for( File element: listOfFiles) {
            System.out.println(element);
        }
    }

    private static void addLast() {
       words.add(commandReader.next()); // No need to have words.size() as a parameter (ArrayList.add appends elements to the bottom of the array)
    }

    private static void addFirst() {
        words.add(0, commandReader.next());
    }
}