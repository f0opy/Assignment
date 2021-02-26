import controllers.MedicineController;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final MedicineController controller;
    private final Scanner scanner;

    public MyApplication(MedicineController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to Medicine Application");
            System.out.println("Select option: (1-~)");
            System.out.println("1. Get All medicines list");
            System.out.println("2. Create medicine");
            System.out.println("3. Get medicine by id");
            System.out.println("4. Get medicine by name");
            System.out.println("5. Get medicine by manufacturer");
            System.out.println("6. Get medicine by name cheapest one");
            System.out.println("7. Get medicine by name most expensive one");
            System.out.println("8. Delete medicine by id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (1-8)");
                int option = scanner.nextInt();
                if(option==1){
                    getAllMedicineMenu();
                }
               else if(option ==3){
                    getMedicineByIdMenu();
                }
                else if(option == 2){
                    createUserMenu();
                }
                else if(option==8){
                   deleteMedicineMenu();
                }
                else if(option==4){
                    getMedicineByNameMenu();
                }
                else if(option==5){
                    getMedicineByManMenu();
                }
                else if(option==6){
                    getMedicineCheapestMenu();
                }
                else if(option==7){
                    getMedicineExpensiveMenu();
                }


                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("*******************************");
        }
    }


    public void getMedicineByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getMedicine(id);
        System.out.println(response);
    }



    public void createUserMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        Double price = scanner.nextDouble();
        System.out.println("Please enter expirationDate");
        Date date = Date.valueOf(scanner.next());
        System.out.println("Please enter manufacturer");
        String manufacturer = scanner.next();
        System.out.println("Please enter contraindications");
        String contraindications = scanner.next();
        System.out.println("Please enter analogs");
        String analogs = scanner.next();
        String response = controller.createMedicine(name, price,date,manufacturer,contraindications,analogs);
        System.out.println(response);

    }
    public void deleteMedicineMenu(){
        System.out.println("Please enter id of medicine which you want to delete:");
        int id = scanner.nextInt();
        String response = controller.deleteMedicine(id);
        System.out.println(response);
    }
    public void getAllMedicineMenu(){
        String response = controller.getAllMedicine();
        System.out.println(response);
    }

    public void getMedicineByNameMenu(){
        System.out.println("Please enter name of medicine");
        String name = scanner.next();
        String response = controller.getMedicine(name);
        System.out.println(response);
    }
    public void getMedicineByManMenu() {
        System.out.println("Please enter name of manufacturer");
        String man = scanner.next();
        String response=controller.getMedicineByMan(man);
        System.out.println(response);
    }

    public void getMedicineExpensiveMenu(){
        System.out.println("Please enter name of medicine");
        String name = scanner.next();
        String response=controller.getMedicineExpensive(name);
        System.out.println(response);
    }

    public void getMedicineCheapestMenu(){
        System.out.println("Please enter name of medicine");
        String name = scanner.next();
        String response=controller.getMedicineCheapest(name);
        System.out.println(response);
    }

}
