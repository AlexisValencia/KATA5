package kata4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata4 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        String name = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\data\\emailsfilev1.txt";
        ArrayList<String> mailList = MailListLoader.read(name);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        new HistogramDisplay(histogram).execute();
    }
}
