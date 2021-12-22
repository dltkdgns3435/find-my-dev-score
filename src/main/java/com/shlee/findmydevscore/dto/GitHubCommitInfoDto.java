package com.shlee.findmydevscore.dto;

import com.shlee.findmydevscore.domain.CommitInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GitHubCommitInfoDto {
    private List<CommitInfo> commitInfos;

}
