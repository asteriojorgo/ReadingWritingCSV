import java.util.*;
import java.io.*;

public class FindEmployee {
    public static void main(String[] args) throws FileNotFoundException {
        String companies = "/Users/hayden/Desktop/PS/ReadingFiles/src/Company.csv";
        String employees = "/Users/hayden/Desktop/PS/ReadingFiles/src/SalesReps.csv";

        File companyFile = new File(companies);
        Scanner companyInput = new Scanner(companyFile);

        File employeeFile = new File(employees);
        Scanner employeeInput = new Scanner(employeeFile);

        ArrayList<String[]> companyData = new ArrayList<>();

        while (companyInput.hasNextLine()) {
            String Line = companyInput.nextLine();
            String[] splitedLine = Line.split(",");
            companyData.add(splitedLine);
        }
//        for (String[] line : companyData) {
//            System.out.println(line[0]);
//            System.out.println(line[1]);
//            System.out.println("Employee ID: " + line[2] );
//            System.out.println("Company Name: " + line[3]);
//            System.out.println("Company Website: " + line[4]);
//            System.out.println("===============================");
//        }

        ArrayList<String[]> employeeData = new ArrayList<>();

        while (employeeInput.hasNextLine()) {
            String Line = employeeInput.nextLine();
            String[] splitedLine1 = Line.split(",");
            employeeData.add(splitedLine1);
        }
//        for (String[] line : employeeData) {
//            System.out.println("Employee ID: " + line[0] );
//            System.out.println("Employee Last Name: " + line[2]);
//            System.out.println("===============================");
//        }

        Scanner scanName = new Scanner(System.in);
        System.out.println("Enter last name of employee and I'll display the data you want: ");

        String getLastName = scanName.nextLine();
        scanName.close();

        String findEmployeeID = "";
        for (String[] employee : employeeData) {
            if (employee[2].equals(getLastName)) {
                System.out.println("Id of " + getLastName + " is " + employee[0]);
                findEmployeeID = employee[0];
            }
        }

        for (String[] company : companyData) {
            if (company[2].equals(findEmployeeID)){
                /*
                They require these fields to be displayed:
                Organization Id, Company Name, Country, Industry, Number of employees: 0, 3, 5, 8, 9
                */
                System.out.println("The company information for " + getLastName);
                System.out.println("Organization ID: " + company[1] );
                System.out.println("Company Name: " + company[3]);
                System.out.println("Country: " + company[5]);
                System.out.println("Industry: " + company[8]);
                System.out.println("Number of Employees: " + company[9]);
            }
        }
    }
}
