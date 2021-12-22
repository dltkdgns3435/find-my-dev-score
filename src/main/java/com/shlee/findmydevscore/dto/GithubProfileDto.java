package com.shlee.findmydevscore.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GithubProfileDto {
    private int numOfRepos;
    private int numOfFollowers;
    private String profileImg;
}
