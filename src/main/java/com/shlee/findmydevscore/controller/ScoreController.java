package com.shlee.findmydevscore.controller;

import com.shlee.findmydevscore.dto.GetGitHubInfo;
import com.shlee.findmydevscore.dto.GithubProfileDto;
import com.shlee.findmydevscore.service.ScoreService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("score/")
@RestController
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("git/{email}")
    public GetGitHubInfo getScore(@PathVariable String email) {
        GetGitHubInfo gitHubInfo = scoreService.getGithubInfo(email);
        System.out.println(gitHubInfo);
        return gitHubInfo;
    }
}
