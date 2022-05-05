package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Builder
public class ShoeModel {
    private String shoeName;
    private String model;
    private String cost;
    private String notes;
    private String data;
}
