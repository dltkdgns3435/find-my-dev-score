package com.shlee.findmydevscore.domain;

import com.shlee.findmydevscore.dto.GitHubCommitInfoDto;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class GitHubCommit {
    private final String uri = "https://github.com/";
    private final RestTemplate restTemplate;
    private final String email;

    private final String originalHtml;

    private List<CommitInfo> commitInfoList;

    public GitHubCommit(String email, RestTemplate restTemplate){
        this.email = email;
        this.restTemplate = restTemplate;
        originalHtml = "";

        this.parseHtmlCommitInfo();
    }

    private void parseHtmlCommitInfo() {
        String uri = this.uri + this.email;
        String response = restTemplate.getForObject(uri, String.class);

        assert response != null;


        this.commitInfoList = this.parseOriginalHtml(response);
    }

    private List<CommitInfo> parseOriginalHtml(String response){
        return Arrays
                .stream(response.split("\n"))
                .filter(this::isParsableCommitLine)
                .map(CommitInfo::new)
                .collect(Collectors.toList());

    }

    private boolean isParsableCommitLine(String line) {
        return line.contains("<rect") && line.contains("data-count");
    }

    public GitHubCommitInfoDto toDto(){
        return GitHubCommitInfoDto.builder()
                .commitInfos(this.commitInfoList)
                .build();
    }

}
