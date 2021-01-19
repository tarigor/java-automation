package training.stage1.collections;

public class Menu {

    public static void menuShowing() {
        System.out.println();
        System.out.println("Please select an option");
        System.out.println("1. to show all objects of " + HiearDef.getHierarchyName());
        if (!MenuEngine.isAssignActNameState()) System.out.println("2. to assign an action name");
        else System.out.println("2. " + MenuEngine.getActionNameInput() + " " + HiearDef.getHierarchyName());
        System.out.println("3. to calculate a " + MenuEngine.getActionNameInput());
        System.out.println("4. to make sort by parameter - " + HiearDef.getObjNameParam());
        System.out.println("5. to find an object in hierarchy " + HiearDef.getHierarchyName());
        System.out.println("0. finish");
        System.out.println();
    }

}
