package testdata;

import models.RegistrationModel;
import models.ShoeModel;
import utilities.FakerGenerator;

public class GetShoesModel {
    public static ShoeModel addShoesData(){
        return ShoeModel.builder()
                .shoeName(FakerGenerator.getShoeName())
                .model(FakerGenerator.getModelName())
                .data("05/05/2022")
                .cost(FakerGenerator.getCost())
                .notes(FakerGenerator.getWorkoutDescription())
                .build();
    }
    }
