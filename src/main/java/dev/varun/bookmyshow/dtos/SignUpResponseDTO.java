package dev.varun.bookmyshow.dtos;

import dev.varun.bookmyshow.Models.User;
import dev.varun.bookmyshow.Models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private User user;
    private ResponseStatus responseStatus;

    }
