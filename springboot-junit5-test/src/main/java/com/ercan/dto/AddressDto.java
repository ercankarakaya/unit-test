package com.ercan.dto;

import com.ercan.entity.Person;
import com.ercan.enums.AddressType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@Builder
public class AddressDto {

    private Long id;

    private String address;

    private String addressType;

    private Boolean active;

    private Person person;
}
