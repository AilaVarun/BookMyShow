package dev.varun.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import dev.varun.bookmyshow.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Show extends BaseModel {
    private Movie movie;
    private Long startTime;
    private Long endTime;
    private List<Feature> features;

}
