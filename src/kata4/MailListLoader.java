package kata4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListLoader {
    public static ArrayList<String> read (String nameFile) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conect = DriverManager.getConnection("jdbc:sqlite:PEOPLE");
	Statement state = conect.createStatement();
        
        String query = "SELECT * FROM MAIL";
        ResultSet rs = state.executeQuery(query);

        ArrayList<String> mailList = new ArrayList<>();
        
        while (rs.next())
            mailList.add(rs.getString("MAIL"));
        rs.close();
        state.close();
        conect.close();
        return mailList;
    }
}