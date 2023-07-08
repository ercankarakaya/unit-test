package com.ercan.dto;

import com.ercan.entity.Address;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@Builder
public class PersonDto {

    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String gender;
    private String email;
    private List<Address> addresses;
}
