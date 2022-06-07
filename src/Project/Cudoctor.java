
package Project;


public class Cudoctor {
    
    
    String doc_details, contact, time, hospital, charges,catagorys;
    public String getDoc_details() {
        return doc_details;
    }

    public String getContact() {
        return contact;
    }

    public String getTime() {
        return time;
    }

    public String getHospital() {
        return hospital;
    }

    public String getCharges() {
        return charges;
    }
     public String getCatagorys() {
        return catagorys ;
    }

    public void setCatagorys(String catagorys) {
        this.catagorys = catagorys;
    }

    public Cudoctor(String doc_details, String contact, String time, String hospital, String charges,String catagorys) {
        this.doc_details = doc_details;
        this.contact = contact;
        this.time = time;
        this.hospital = hospital;
        this.charges = charges;
        this.catagorys=catagorys;
    }
}
