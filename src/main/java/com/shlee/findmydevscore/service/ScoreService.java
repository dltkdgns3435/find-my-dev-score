package com.shlee.findmydevscore.service;

import com.shlee.findmydevscore.domain.GitHubCommit;
import com.shlee.findmydevscore.domain.GitHubProfile;
import com.shlee.findmydevscore.dto.GetGitHubInfo;
import com.shlee.findmydevscore.dto.GithubProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final RestTemplate restTemplate;

    public GetGitHubInfo getGithubInfo(String email){
        GitHubProfile gitHubProfile = new GitHubProfile(email, restTemplate);
        GitHubCommit gitHubCommit = new GitHubCommit(email, restTemplate);

        return GetGitHubInfo.builder()
                .gitHubCommitInfoDto(gitHubCommit.toDto())
                .githubProfileDto(gitHubProfile.toDto())
                .build();
    }
}
