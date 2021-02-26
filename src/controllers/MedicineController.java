package controllers;

import ent.Medicine;
import repositories.interfaces.IMedicineRepositories;

import java.sql.Date;
import java.util.List;

public class MedicineController {
    private final IMedicineRepositories repo;

    public MedicineController(IMedicineRepositories repo){this.repo=repo;}
    public String createMedicine(String name, double price, Date date, String manufacturer, String contraindications, String analogs){
        Medicine medicine = new Medicine(name, price,date,manufacturer,contraindications,analogs);
        boolean created = repo.createMedicine(medicine);

        return (created ? "medicine was created!" : "medicine creation was failed! ");
    }
    public  String getMedicine(int id){
        Medicine medicine = repo.getMedicine(id);

        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }
    public String getAllMedicine(){
        List <Medicine> medicines = repo.getAllMedicine();

        return medicines.toString();
    }
    public  String deleteMedicine(int id){
        boolean deleted=repo.deleteMedicine(id);

        return (deleted == false ? "Medicine was not deleted!" : "Medicine has been deleted");
    }
    public String getMedicine(String name){
        Medicine medicine=repo.getMedicineByName(name);
        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }
    public String getMedicineByMan(String manufacturer){
        Medicine medicine=repo.getMedicineByManufacturer(manufacturer);
        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }

    public String getMedicineExpensive(String name){
        Medicine medicine=repo.getMedicineExpensive(name);
        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }

    public String getMedicineCheapest(String name){
        Medicine medicine=repo.getMedicineCheapest(name);
        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }


}
