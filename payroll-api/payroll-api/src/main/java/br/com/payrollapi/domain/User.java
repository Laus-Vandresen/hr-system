package br.com.payrollapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
}
