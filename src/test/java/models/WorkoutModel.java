package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class WorkoutModel {
    private String workoutName;
    private String workoutDescription;
    private int distance;
    private String duration;
    private int pace;
    private int minHr;
    private int avgHr;
    private int maxHr;
    private int calories;
    private String weight;
    private String height;
    private String age;
    private String runDistance;

}
