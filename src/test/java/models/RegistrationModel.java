package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class RegistrationModel {
   private String firstname;
   private String lastname;
   private String email;
   private String password;
   private String confirmPassword;
}
