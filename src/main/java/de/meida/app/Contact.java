package de.meida.app;

public class Contact extends Base<Long>{
    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        super(null);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contact(Long id, String name, String email, String phone) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
