package training.stage1.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuEngine {
    static HashMap<String, Integer> hierObjPlugin = new HashMap<>();
    private static String actionNameInput;
    private static boolean assignActNameState;
    private static Integer total = 0;

    public static boolean isAssignActNameState() {
        return assignActNameState;
    }

    public static void setAssignActNameState(boolean assignActNameState) {
        MenuEngine.assignActNameState = assignActNameState;
    }

    public static String getActionNameInput() {
        return actionNameInput;
    }

    public static void setActionNameInput(String actionNameInput) {
        MenuEngine.actionNameInput = actionNameInput;
    }

    public static void menuAction() {

        int exit = 0;
        while (exit < 1) {

            Scanner in = new Scanner(System.in);
            String optionInput = in.next();

            switch (optionInput) {
                case "1":
                    System.out.println();
                    objectsList();
                    System.out.println();
                    Menu.menuShowing();
                    break;
                case "2":
                    if (!assignActNameState) {
                        System.out.println("Input an action name");
                        actionNameInput = in.next();
                        assignActNameState = true;
                        Menu.menuShowing();
                        break;
                    }
                    if (assignActNameState) {
                        System.out.println();
                        System.out.println("List of objects:");
                        objectsList();
                        System.out.println();
                        objectsPlugin();
                        Menu.menuShowing();
                        break;
                    }
                    ;
                case "3":
                    System.out.println();
                    System.out.println("The total " + MenuEngine.getActionNameInput() + " is:" + total);
                    Menu.menuShowing();
                    break;
                case "4":
                    System.out.println();
                    sortByValue();
                    Menu.menuShowing();
                    break;
                case "5":
                    System.out.println();
                    searchByParametersRange();
                    Menu.menuShowing();
                    break;
                case "0":
                    exit = 1;
            }
        }

    }

    public static void objectsList() {
        for (Map.Entry entry : HiearDef.hierObj.entrySet()) {

            System.out.println(entry);

        }
    }

    public static void objectsPlugin() {
        for (Map.Entry<String, Integer> entry : HiearDef.hierObj.entrySet()) {
            // get key
            String key = entry.getKey();
            // get value
            Integer value = entry.getValue();
            Scanner in = new Scanner(System.in);
            System.out.println("Do you wish to plugin " + key + " ? y/n");
            String plugin = in.next();
            if (plugin.equals("y")) {
                hierObjPlugin.put(key, value);
                total = total + value;
            }
            ;
        }
        System.out.println();
        System.out.println("Where applied action " + actionNameInput + "to:");
        System.out.println(hierObjPlugin);
        System.out.println();
    }

    public static void sortByValue() {
        Map<String, Integer> unSortedMap = HiearDef.hierObj;

        System.out.println("Unsorted Map : " + unSortedMap);

//LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);
    }

    public static void searchByParametersRange() {
        int exist = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the range of searching");
        System.out.println("Search from:");
        Integer searchLow = new Integer(in.next());

        System.out.println("Please input the range of searching");
        Scanner in2 = new Scanner(System.in);
        System.out.println("Search to:");
        Integer searchHigh = new Integer(in2.next());

        while (searchHigh < searchLow) {
            System.out.println("Incorrect HIGH range. Should be higher than Low range. Please input the correct one");
            Scanner in3 = new Scanner(System.in);
            System.out.println("Search to:");
            searchHigh = new Integer(in3.next());
        }
        System.out.println();
        System.out.println("The objects within search range (" + searchLow + "-" + searchHigh + ") are:");
        for (Map.Entry<String, Integer> entry : HiearDef.hierObj.entrySet()) {
            // get key
            String key = entry.getKey();
            // get value
            Integer value = entry.getValue();
            if (value > searchLow & value < searchHigh) {
                exist = 1;
                System.out.println(key + "=" + value);
            }
        }
        if (exist == 0) System.out.println("not exist");
    }
}