package training.stage2.javaIO;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("output.txt");
        File path = new File(args[0]);
        System.out.println("-------------------");
        if (args[0].contains(".txt")) {
            System.out.println("Second task started");
            System.out.println("-------------------");
            file = new File(args[0]);
            fileScanner(file);
        } else {
            file.delete();
            System.out.println("First task started");
            System.out.println("-------------------");
            if (!path.exists()) {
                System.out.println(args[0] + " NOT exist");
                return;
            }
            pathPrint(path, "");
            System.out.println("-------------------------------");
        }
    }

    private static void fileScanner(File file) throws IOException {
        long amountOfFolders = 0;
        long amountOfFiles = 0;
        int index = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int indexOfArrayLines = 0;
            double amountOfFileChar = 0.0;
            while ((line = bufferedReader.readLine()) != null) {
                indexOfArrayLines++;
                if (line.contains("|__")) amountOfFolders++;
                if (line.contains(".") & !line.contains("|__")) {
                    amountOfFiles++;
                    long countOfChar = 0;
                    for (int i = 0; i < line.length(); i++) {
                        //count of char till '.' appeared
                        if (line.charAt(i) == '.') break;
                        //do not count spaces before file name
                        if (line.charAt(i) != ' ') countOfChar++;
                    }
                    index++;
                    System.out.print(index + ".");
                    System.out.println("Amount of char in filename '" + line + "' = " + countOfChar);
                    amountOfFileChar = amountOfFileChar + countOfChar;
                }
            }
            System.out.println("--------------------------");
            System.out.println("Amount of folders = " + amountOfFolders);
            System.out.println("Amount of files = " + amountOfFiles);
            System.out.println("Average amount of files in folder = " + ((double) amountOfFiles) / ((double) amountOfFolders));
            System.out.println("Average amount of char in file = " + amountOfFileChar / ((double) amountOfFiles));
        }
    }

    public static void pathPrint(File path, String tabulator) {
        File[] fileOrFolder = path.listFiles();
        if (fileOrFolder != null) {
            for (int i = 0; i < fileOrFolder.length; i++) {
                if (fileOrFolder[i].isDirectory()) {
                    System.out.println(tabulator + "|__" + fileOrFolder[i].getName());
                    writeToFile(tabulator + "|__" + fileOrFolder[i].getName());
                    pathPrint(fileOrFolder[i], tabulator + "   ");
                } else {
                    System.out.println(tabulator + "" + fileOrFolder[i].getName());
                    writeToFile(tabulator + "" + fileOrFolder[i].getName());
                }
            }
        }
    }

    private static void writeToFile(String s) {
        File file = new File("output.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(s + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
