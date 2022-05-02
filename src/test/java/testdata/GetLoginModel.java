package testdata;

import models.LoginModel;
import utilities.FakerGenerator;

public class GetLoginModel {
    public static LoginModel getLoginWithAllFields(){
        return LoginModel
                .builder()
                .email(FakerGenerator.getEmail())
                .password(FakerGenerator.getPassword())
                .build();
    }
}
