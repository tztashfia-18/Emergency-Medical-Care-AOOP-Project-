package Project;

public class NewClass {

    String names, gen_names, mgz,amounts, companys, prices;

    public String getName() {
        return names;
    }

    public void setName(String names) {
        this.names = names;
    }

    public String getGen_name() {
        return gen_names;
    }

    public void setGen_name(String gen_names) {
        this.gen_names = gen_names;
    }

    public String getMg() {
        return mgz;
    }

    public void setMg(String mgz) {
        this.mgz = mgz;
    }

    public String getAmount() {
        return amounts;
    }

    public void setAmount(String amounts) {
        this.amounts = amounts;
    }

    public String getCompany() {
        return companys;
    }

    public void setCompany(String companys) {
        this.companys = companys;
    }

    public String getPrice() {
        return prices;
    }

    public void setPrice(String prices) {
        this.prices = prices;
    }

    public NewClass(String names, String gen_names, String mgz, String amounts, String companys, String prices) {
        this.names = names;
        this.gen_names = gen_names;
        this.mgz = mgz;
        this.amounts = amounts;
        this.companys = companys;
        this.prices = prices;
    }

}

