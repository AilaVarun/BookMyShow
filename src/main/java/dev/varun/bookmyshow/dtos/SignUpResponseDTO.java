package dev.varun.bookmyshow.dtos;

import dev.varun.bookmyshow.models.User;
import dev.varun.bookmyshow.models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private User user;
    private ResponseStatus responseStatus;

    }
