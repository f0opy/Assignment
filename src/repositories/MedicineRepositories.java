package repositories;

import data.interfaces.IDB;
import ent.Medicine;
import repositories.interfaces.IMedicineRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MedicineRepositories implements IMedicineRepositories {
    private final IDB db;
    public MedicineRepositories(IDB db){this.db= db;}

    @Override
    public boolean createMedicine(Medicine medicine) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Medicines(name, price,expirationDate,manufacturer,contraindications,analogs) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, medicine.getName());
            st.setDouble(2, medicine.getPrice());
            st.setDate(3, medicine.getDate());
            st.setString(4,medicine.getManufacturer());
            st.setString(5,medicine.getContraindications());
            st.setString(6,medicine.getAnalogs());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public Medicine getMedicine(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  id, name, price,expirationDate,manufacturer,contraindications,analogs FROM medicines WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDate("expirationDate"),
                        rs.getString("manufacturer"),
                        rs.getString("contraindications"),
                        rs.getString("analogs"));
                return medicine;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteMedicine(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM medicines WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.execute();
            return true;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Medicine> getAllMedicine() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  id, name, price,expirationDate,manufacturer,contraindications,analogs FROM medicines";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Medicine> medicines = new LinkedList<>();
            while(rs.next()){
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDate("expirationDate"),
                        rs.getString("manufacturer"),
                        rs.getString("contraindications"),
                        rs.getString("analogs"));
                medicines.add(medicine);
            }
            return medicines;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public Medicine getMedicineByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM medicines WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDate("expirationDate"),
                        rs.getString("manufacturer"),
                        rs.getString("contraindications"),
                        rs.getString("analogs"));
                return medicine;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }



    @Override
    public Medicine getMedicineByManufacturer(String manufacturer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM medicines WHERE manufacturer=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, manufacturer);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDate("expirationDate"),
                        rs.getString("manufacturer"),
                        rs.getString("contraindications"),
                        rs.getString("analogs"));
                return medicine;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Medicine getMedicineCheapest(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * from medicines where name=? and price in (SELECT min(price) from medicines);";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDate("expirationDate"),
                        rs.getString("manufacturer"),
                        rs.getString("contraindications"),
                        rs.getString("analogs"));
                return medicine;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Medicine getMedicineExpensive(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * from medicines where name=? and price in (SELECT max(price) from medicines);";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDate("expirationDate"),
                        rs.getString("manufacturer"),
                        rs.getString("contraindications"),
                        rs.getString("analogs"));
                return medicine;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
