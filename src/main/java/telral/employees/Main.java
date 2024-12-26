package telral.employees;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String fileName = "employees-sql-data.csv";
        DepartmentStaff[] departments = {
                new DepartmentStaff("QA", 1, 1, 4, 0),
                new DepartmentStaff("Development", 1, 3, 3, 0),
                new DepartmentStaff("Devops", 1, 4, 2, 0),
                new DepartmentStaff("Sales", 1, 0, 0, 5)
        };
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writeFile(writer, departments);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(PrintWriter writer, DepartmentStaff[] departments) {
        for (int i = 0; i < departments.length; i++) {
            for (int e = 0; e < departments[i].nEmployees(); e++) {
                writer.println(Employee.getEmployee(departments[i].department()));
            }
            for (int e = 0; e < departments[i].nManagers(); e++) {
                writer.println(Employee.getManager(departments[i].department()));
            }
            for (int e = 0; e < departments[i].nWageEmployees(); e++) {
                writer.println(Employee.getWageEmployee(departments[i].department()));
            }
            for (int e = 0; e < departments[i].nSalesPersons(); e++) {
                writer.println(Employee.getSalesPerson(departments[i].department()));
            }
        }
    }

}