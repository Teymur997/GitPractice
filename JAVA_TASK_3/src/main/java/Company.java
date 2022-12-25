import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Company {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private Long inn;
    @JsonFormat(pattern = "dd.MM.yyyy")
        private Date founded;


    private List<Securities> securities;

    public Company() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }


    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }


    @Override
    public String toString() {
        return  "\n" + id + "\n" +
                name + "\n" +
                address + "\n" +
                phoneNumber + "\n" +
                inn + "\n" +
                Main.convertToLocalDate(founded).format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "\n" +
                securities;
    }

}
