package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;


public class Programa {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Funcionario> list = new ArrayList<>();

        for(int i=0; i<n; i++) {

            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            Integer id = sc.nextInt();

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Funcionario func = new Funcionario(id, name, salary);

            list.add(func);

            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        Integer idsalary = sc.nextInt();

        Funcionario func = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);

        if (func ==null) {
            System.out.println("This id does not exist! ");
        }
        else {
            System.out.println("Enter the percentage: ");
            double percent = sc.nextDouble();
            func.increaseSalary(percent);
        }

        System.out.println("List of employees: ");

        for(Funcionario emp : list) {
            System.out.print(emp);
        }
      
       

       
        sc.close();

    }

}
