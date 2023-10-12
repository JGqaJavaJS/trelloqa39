package data;

import dto.UserDtoLombok;
import org.testng.annotations.DataProvider;

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
}
