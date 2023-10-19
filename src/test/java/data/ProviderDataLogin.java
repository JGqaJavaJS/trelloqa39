package data;

import dto.UserDTO;
import dto.UserDtoLombok;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderDataLogin {

    @DataProvider
    public Iterator<Object[]> usersPositiveData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("juliagordyin@gmail.com")
                        .password("123456Aa$")
                        .build()
        });
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("juliagordyin@gmail.com")
                        .password("123456Aa$")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> usersNegativePasswordData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("juliagordyin@gmail.com")
                        .password("123456Aa")
                        .build()
        });
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email("juliagordyin@gmail.com")
                        .password("123456a$")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginCSV() { // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/reg_dataset.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while (line != null){
                String[] split = line.split(",");
                list.add(new Object[] { UserDtoLombok.builder().email(split[0]).password(split[1]).build()});
                line = reader.readLine();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        //  reader.close();
        return list.iterator();
    }
}
