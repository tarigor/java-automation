package training.javaIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        File file = new File("output.txt");
        file.delete();
        File path = new File(args[0]);
        if (!path.exists()) {
            System.out.println(args[0] + " NOT exist");
            return;
        }
        pathPrint(path, "");
    }
    public static void pathPrint(File path, String tabulator) {
        File[] fileOrFolder = path.listFiles();
        if (fileOrFolder != null) {
            for (int i = 0; i < fileOrFolder.length; i++)
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

    private static void writeToFile(String s) {
        File file = new File("output.txt");
        try {
            BufferedWriter writer= new BufferedWriter(new FileWriter(file,true));
            writer.write(s+ "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
