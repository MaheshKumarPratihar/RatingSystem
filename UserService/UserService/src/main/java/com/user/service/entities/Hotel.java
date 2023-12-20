package com.user.service.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
// Note getter setter are important for the REST TEMPLATE
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;
}
