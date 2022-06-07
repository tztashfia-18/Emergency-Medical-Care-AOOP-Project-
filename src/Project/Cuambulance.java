
package Project;


public class Cuambulance {
    String name, phone, address, time, ab_no, charges,star;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAb_no() {
        return ab_no;
    }

    public void setAb_no(String ab_no) {
        this.ab_no = ab_no;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }
      public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public Cuambulance(String name, String phone, String address, String time, String ab_no, String charges,String star) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.time = time;
        this.ab_no = ab_no;
        this.charges = charges;
        this.star=star;
    }
    
}
