package repositories.interfaces;

import ent.Medicine;

import java.util.List;

public interface IMedicineRepositories {
    boolean createMedicine(Medicine medicine);
    Medicine getMedicine(int id);
    Medicine getMedicineByName(String name);
    Medicine getMedicineByManufacturer(String manufacturer);
    Medicine getMedicineCheapest(String name);
    Medicine getMedicineExpensive(String name);
    boolean  deleteMedicine(int id);
    List<Medicine> getAllMedicine();

}
