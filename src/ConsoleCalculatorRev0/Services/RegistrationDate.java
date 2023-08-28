package ConsoleCalculatorRev0.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrationDate {
    //Date and time
    LocalDateTime registeredAt = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formatDateTime = registeredAt.format(formatter);


    //Method to get Date and time
    public String getFormatDateTime() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formatDateTime = now.format(formatter);

        return formatDateTime;
    }


    public void setFormatDateTime(String formatDateTime) {
        this.formatDateTime = formatDateTime;
    }
}
