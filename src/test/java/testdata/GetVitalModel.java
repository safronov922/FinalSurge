package testdata;

import models.VitalsModel;
import utilities.FakerGenerator;

public class GetVitalModel {
    public static VitalsModel addVitalsFields(){
        return VitalsModel.builder()
                .date("5/4/2022")
                .steps(FakerGenerator.getNumbers())
                .caloriesConsumed(FakerGenerator.getNumbers())
                .weight(FakerGenerator.getWeightMuscMass())
                .water(FakerGenerator.getBodyWater())
                .bodyFat(FakerGenerator.getBodyWater())
                .muscleMass(FakerGenerator.getWeightMuscMass())
                .restingHr(FakerGenerator.getHr())
                .hrVariability(FakerGenerator.getHrVariability())
                .sleepHours(FakerGenerator.getSleep())
                .totalTimeAwake(FakerGenerator.getSleep())
                .bloodPressure(FakerGenerator.getBodyWater())
                .healthNotes(FakerGenerator.getWorkoutDescription())
                .build();
    }
}
