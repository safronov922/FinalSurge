package testdata;

import models.RegistrationModel;
import utilities.FakerGenerator;

public class GetRegistrationModel {
    public static RegistrationModel registrationModelWithAllFields(){
        String password = FakerGenerator.getPassword();
        return RegistrationModel
                .builder()
                .firstname(FakerGenerator.getFirstNAme())
                .lastname(FakerGenerator.getLAstName())
                .email(FakerGenerator.getEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }
}
