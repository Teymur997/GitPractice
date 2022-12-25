import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Securities {
    private String name;
    private List<String> currency;
    private String code;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    public Securities() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void setCurrency(List<String> currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return  "\n" + name + "\n" +
                currency.toString() + "\n" +
                code + "\n" +
                Main.convertToLocalDate(date).format(DateTimeFormatter.ofPattern("dd/MM/yy"));
    }


}
