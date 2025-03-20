package com.example.DTO;


import com.example.entity.Skills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRes {
    private long id;
    private String name;
    private String email;
    private List<Skills> offeredSkills;
    private List<Skills> desiredSkills;
}
