package utilities;

import com.github.javafaker.Faker;

public class FakerGenerator {
    public static String getEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    public static String getPassword(){
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
