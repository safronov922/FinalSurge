package utilities;

import com.github.javafaker.Faker;

public class FakerGenerator {
    public static String getEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        Faker faker = new Faker();
        return faker.internet().password(7, 15, true, true, true);
    }

    public static String getFirstNAme() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getLAstName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String getWorkoutName() {
        Faker faker = new Faker();
        return faker.name().title();
    }

    public static String getWorkoutDescription() {
        Faker faker = new Faker();
        return faker.lorem().sentence();
    }

    public static Integer getNumbers() {
        Faker faker = new Faker();
        return faker.number().numberBetween(20, 2000);
    }

    public static Integer getWeightMuscMass() {
        Faker faker = new Faker();
        return faker.number().numberBetween(100, 900);
    }

    public static Integer getBodyWater() {
        Faker faker = new Faker();
        return faker.number().numberBetween(20, 99);
    }

    public static Integer getHrVariability() {
        Faker faker = new Faker();
        return faker.number().numberBetween(100, 400);
    }

    public static Integer getSleep() {
        Faker faker = new Faker();
        return faker.number().numberBetween(4, 8);
    }

    public static Integer getHr() {
        Faker faker = new Faker();
        return faker.number().numberBetween(20, 300);
    }
    public static String getShoeName() {
        Faker faker = new Faker();
        return faker.witcher().character();
    }
    public static String getModelName() {
        Faker faker = new Faker();
        return faker.funnyName().name();
    }
    public static String getCost() {
        Faker faker = new Faker();
        return faker.numerify("2");
    }
    public static String getTime(){
        Faker faker = new Faker();
        return faker.numerify("15");
    }
    public static String getAge(){
        Faker faker = new Faker();
        return faker.numerify("4#");
    }
}
