package Project;

public class medicinelist {
    String name, gen_name, mg, company, price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGen_name() {
        return gen_name;
    }

    public void setGen_name(String gen_name) {
        this.gen_name = gen_name;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }



    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public medicinelist(String name, String gen_name, String mg,  String company, String price) {
        this.name = name;
        this.gen_name = gen_name;
        this.mg = mg;

        this.company = company;
        this.price = price;
    }




}
