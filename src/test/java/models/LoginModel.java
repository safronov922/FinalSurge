package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class LoginModel {
    private String email;
    public String password;

}
