package training.stage1.collections;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HiearDef {

    static HashMap<String, Integer> hierObj = new HashMap<>();
    private static String hierarchyName;
    private static String hierarhObjname;
    private static String objParam;
    private static String objNameParam;

    public static String getHierarchyName() {
        return hierarchyName;
    }

    public static void setHierarchyName(String hierarchyName) {
        HiearDef.hierarchyName = hierarchyName;
    }

    public static String getObjNameParam() {
        return objNameParam;
    }

    public static void setObjNameParam(String objNameParam) {
        HiearDef.objNameParam = objNameParam;
    }

    public static void hierNameRequest() {

        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        System.out.println("Please input a hierarchy name");
        hierarchyName = in.nextLine();
        System.out.println("The hierarchy name is:" + hierarchyName);


        System.out.println("Please input a name of object parameter:");
        objNameParam = in.nextLine();
        System.out.println("The object parameter is:" + objNameParam);

        //HashMap<String, Integer> hierObj = new HashMap<>();

        int endFlag = 1;
        for (int i = 0; i < endFlag; i++) {
            endFlag = 1 + endFlag;

            System.out.println("Please input a object name of " + hierarchyName + ":");
            hierarhObjname = in1.nextLine();

            System.out.println("Please input a value of " + objNameParam + " of " + hierarhObjname + ":");
            objParam = in2.nextLine();

            hierObj.put(hierarhObjname, Integer.valueOf(objParam));

            System.out.println("Are you finished with object inputting yes/no?:");
            String getAnswer = in.next();

            if (getAnswer.contains("yes")) {
                endFlag = endFlag - 3;
                System.out.println(hierarchyName + " hierarchy is contains following objects (name=" + objNameParam + "): " + hierObj);

                File file = new File("src/main/java/training/collections/out/txt.txt");
                BufferedWriter bf = null;
                try {
                    //create new BufferedWriter for the output file
                    bf = new BufferedWriter(new FileWriter(file));
                    //iterate map entries
                    for (Map.Entry<String, Integer> entry : hierObj.entrySet()) {

                        //put key and value separated by a colon
                        bf.write(entry.getKey() + ":" + entry.getValue());

                        //new line
                        bf.newLine();
                    }

                    bf.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        //always close the writer
                        bf.close();
                    } catch (Exception e) {
                    }
                }

            } else {
                continue;
            }
            ;
        }
    }

    public HashMap<String, Integer> getPeopleMap() {
        return hierObj;
    }
}
