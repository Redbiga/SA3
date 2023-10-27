package experiment.CS2.entity;

public class Contacts {
    private Integer ccode;
    private String cname;
    private String caddress;
    private String cphone;

    public Integer getCcode() {
        return ccode;
    }

    public void setCcode(Integer ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "ccode=" + ccode +
                ", cname='" + cname + '\'' +
                ", caddress='" + caddress + '\'' +
                ", cphone='" + cphone + '\'' +
                '}';
    }
}
