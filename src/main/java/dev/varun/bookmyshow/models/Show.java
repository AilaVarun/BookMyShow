package dev.varun.bookmyshow.Models;

import dev.varun.bookmyshow.Models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="Shows")
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;
    private Long startTime;
    private Long endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

}
