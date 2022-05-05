package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
@Data
public class VitalsModel {
    private int steps;
    private int caloriesConsumed;
    private int weight;
    private int bodyFat;
    private int water;
    private int muscleMass;
    private int restingHr;
    private int hrVariability;
    private int sleepHours;
    private int totalTimeAwake;
    private int bloodPressure;
    private String healthNotes;
    private String date;



}
