package ent;

import java.sql.Date;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private Date date;
    private String manufacturer;
    private String contraindications;
    private String analogs;

    public Medicine(int id, String name, double price, Date date){

    }
    public Medicine(String name,double price,Date date,String manufacturer,String contraindications,String analogs){
        setName(name);
        setPrice(price);
        setDate(date);
        setManufacturer(manufacturer);
        setContraindications(contraindications);
        setAnalogs(analogs);
    }
    public Medicine(int id,String name,double price,Date date,String manufacturer,String contraindications,String analogs){
        setId(id);
        setName(name);
        setPrice(price);
        setDate(date);
        setManufacturer(manufacturer);
        setContraindications(contraindications);
        setAnalogs(analogs);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getAnalogs() {
        return analogs;
    }

    public void setAnalogs(String analogs) {
        this.analogs = analogs;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", contraindications='" + contraindications + '\'' +
                ", analogs='" + analogs + '\'' +
                '}';
    }
}


