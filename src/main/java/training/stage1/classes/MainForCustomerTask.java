package training.stage1.classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainForCustomerTask {

    public static ArrayList<Customer> customerList = customerDatabaseComposing();

    public static void main(String[] args) {
        menu();
        boolean completeTask=false;
        while (!completeTask){
            Scanner inputOption = new Scanner(System.in);
            String option = inputOption.next();
            switch (option){
                case "1":
                    sortOfCustomer();
                    menu();
                    break;
                case"2":
                    searchByrangeOfCreditCard();
                    menu();
                    break;
                case "0":
                    completeTask=true;
            }
        }
    }

    private static ArrayList<Customer> customerDatabaseComposing() {

        ArrayList<Customer> customerList;
        customerList = new ArrayList<>();

        int arrayIndex=0;

        boolean customeBasecomplete=false;

        while(!customeBasecomplete){
            Scanner fieldInput = new Scanner(System.in);

            Customer singleCustomer = new Customer();

            System.out.println("Input an id");
            singleCustomer.setId(fieldInput.nextInt());

            System.out.println("Input a family name");
            singleCustomer.setFamilyName(fieldInput.next());

            System.out.println("Input a first name");
            singleCustomer.setFirstName(fieldInput.next());

            System.out.println("Input a secondary name");
            singleCustomer.setSecondaryName(fieldInput.next());

            System.out.println("Input a creditCardNumber");
            singleCustomer.setCreditCardNumber(fieldInput.nextInt());

            System.out.println("Input a bankAccountNumber");
            singleCustomer.setBankAccountNumber(fieldInput.nextInt());

            customerList.add(arrayIndex, singleCustomer);

            System.out.println("Do you want to add one more customer? y/n");
            Scanner exitAnswer = new Scanner(System.in);
            String answer = exitAnswer.next();

            if (answer.contains("n")) {
                System.out.println((customerList.get(1)).getFirstName());
                customeBasecomplete = true;
            } else arrayIndex++;
        }
        return customerList;
    }

    private static void menu() {
        System.out.println("");
        System.out.println("1. List of customer in alphabet");
        System.out.println("2. Search by range of credit card number");
        System.out.println("0. finish");
        System.out.println("");
    }
    public static void sortOfCustomer(){
        ArrayList<String> customersName = new ArrayList<>();
        for(int i=0; i<customerList.size();i++) customersName.add(i,(customerList.get(i)).getFamilyName()+" "+(customerList.get(i)).getFirstName()+" "+(customerList.get(i)).getSecondaryName());
        Collections.sort(customersName);
        for(int i=0; i<customerList.size();i++) {
            System.out.println(customersName.get(i));
        }
    }
    public static void searchByrangeOfCreditCard(){
        Scanner rangeInput = new Scanner(System.in);
        System.out.println("Please input a low range of credit card search");
        int lowRangeSearching = rangeInput.nextInt();
        System.out.println("Please input a high range of credit card search");
        int highRangeSearching = rangeInput.nextInt();
        if (lowRangeSearching > highRangeSearching) {
            System.out.println("The inputted range is not correct because the low range higher than high range. Please input the correct one");
            System.out.println("");
            searchByrangeOfCreditCard();
        } else {
            System.out.println("The following customers have a credit card within the range " + lowRangeSearching + " - " + highRangeSearching + ":");
            for (int i = 0; i < customerList.size(); i++) {
                if ((customerList.get(i)).getCreditCardNumber() >= lowRangeSearching && (customerList.get(i)).getCreditCardNumber() <= highRangeSearching)
                    System.out.println((customerList.get(i)).getFamilyName() + " " + (customerList.get(i)).getFirstName() + " " + (customerList.get(i)).getSecondaryName());
            }
        }
    }
}
