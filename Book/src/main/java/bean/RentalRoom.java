package bean;

public class RentalRoom {
    private int id;
    private String name;
    private int phone;
    private String borrow_date;
    private String payment;
    private String note;

    public RentalRoom() {
    }

    public RentalRoom(int id, String name, int phone, String borrow_date, String payment, String note) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.borrow_date = borrow_date;
        this.payment = payment;
        this.note = note;
    }

    public RentalRoom(String name, int phone, String borrow_date, String payment, String note) {
        this.name = name;
        this.phone = phone;
        this.borrow_date = borrow_date;
        this.payment = payment;
        this.note = note;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
