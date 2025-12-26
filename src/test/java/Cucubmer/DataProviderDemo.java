package Cucubmer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @Test(dataProvider = "driverTest")
    public void loginTest(String userName, String password){
        System.out.println("Attempting login with: "+userName+" "+password);

    }

    @DataProvider(name = "driverTest")
    public Object[][] getData(){

        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "incorrect"},
                {"problem user", "incorrect"}
        };
    }

}
