import controllers.MedicineController;
import data.PostgreDB;
import data.interfaces.IDB;
import repositories.MedicineRepositories;
import repositories.interfaces.IMedicineRepositories;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgreDB();
        IMedicineRepositories repo = new MedicineRepositories(db);
        MedicineController controller = new MedicineController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
