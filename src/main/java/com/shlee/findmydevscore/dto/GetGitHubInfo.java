package com.shlee.findmydevscore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class GetGitHubInfo {
    private GitHubCommitInfoDto gitHubCommitInfoDto;
    private GithubProfileDto githubProfileDto;
}
