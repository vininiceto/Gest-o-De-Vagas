package br.com.vininiceto.modules.candidate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @NotBlank
    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços")
    private String username;
    @Email(message = "O campo(email) deve conter um e-mail válido!")
    @NotBlank
    private String email;
    @Length(min = 10, max = 25)
    @NotBlank
    private String password;
    private String description;
    private String curriculum;


}
