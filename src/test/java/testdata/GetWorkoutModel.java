package testdata;

import models.WorkoutModel;
import utilities.FakerGenerator;

public class GetWorkoutModel {
    public static WorkoutModel allFieldsInputs(){
        return WorkoutModel.builder()
                .workoutName(FakerGenerator.getWorkoutName())
                .workoutDescription(FakerGenerator.getWorkoutDescription())
                .distance(FakerGenerator.getNumbers())
                .duration("20:20:20")
                .pace(FakerGenerator.getNumbers())
                .minHr(FakerGenerator.getHr())
                .maxHr(FakerGenerator.getHr())
                .avgHr(FakerGenerator.getHr())
                .calories(FakerGenerator.getNumbers())
                .weight(FakerGenerator.getAge())
                .age(FakerGenerator.getAge())
                .height(FakerGenerator.getAge())
                .runDistance(FakerGenerator.getAge())
                .build();
    }
}
