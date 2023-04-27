package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //read from file and add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Data.csv")));
        String line = reader.readLine(); //[noa@gmail.com][Nnoa12345$]
        while (line != null) {
            String[] all = line.split(",");// [qwerty@gmail.com] [Ff12345$]
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();//noa@gmail.com,Nnoa12345$
        }

        return list.iterator();
    }
}
