package co.edu.uniquindio.unicine.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO implements Serializable {

    private String correo;
    private String password;
}
