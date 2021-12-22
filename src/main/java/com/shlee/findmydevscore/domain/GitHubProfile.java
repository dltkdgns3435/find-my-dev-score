package com.shlee.findmydevscore.domain;

import com.shlee.findmydevscore.dto.GithubProfileDto;
import lombok.Getter;
import lombok.ToString;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

@Getter
@ToString
public class GitHubProfile {
    private final String uri = "https://api.github.com/users/";
    private final RestTemplate restTemplate;
    private final String email;

    private int numOfRepos;
    private int numOfFollowers;
    private String profileImg;

    public GitHubProfile(String email, RestTemplate restTemplate) {
        this.email = email;
        this.restTemplate = restTemplate;

        this.parseProfileInfo();
    }

    //json parsing
    private void parseProfileInfo(){
        String uri = this.uri + this.email;
        String response = restTemplate.getForObject(uri, String.class);

        JSONObject jo = new JSONObject(response);

        this.numOfRepos =  jo.getInt("public_repos");
        this.numOfFollowers =  jo.getInt("followers");
        this.profileImg = jo.getString("avatar_url");
    }


    public GithubProfileDto toDto(){
        return GithubProfileDto.builder()
                .numOfFollowers(this.numOfFollowers)
                .numOfRepos(this.numOfRepos)
                .profileImg(this.profileImg)
                .build();
    }

}
