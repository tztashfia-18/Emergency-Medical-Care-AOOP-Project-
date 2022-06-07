
package Project;

public class AdDoctor {
    
     String doc_name, contact, hospital, time, charges,catagory;

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }
    public String getCatagory() {
        return catagory ;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public AdDoctor(String doc_name, String contact, String hospital, String time, String charges,String catagory) {
        this.doc_name = doc_name;
        this.contact = contact;
        this.hospital = hospital;
        this.time = time;
        this.charges = charges;
        this.catagory=catagory;
    }
}
