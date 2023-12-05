package com.DeveloperProductivityTracker.commitstrackingsystem.Controller;

import com.DeveloperProductivityTracker.commitstrackingsystem.model.GitHubCommit;
import com.DeveloperProductivityTracker.commitstrackingsystem.service.GitHubCommitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")
public class GitHubCommitsController {
    private final GitHubCommitService gitHubCommitService;

    @GetMapping("/commits")
    public ResponseEntity<List<GitHubCommit>> getGitHubCommits() {
        return ResponseEntity.ok(this.gitHubCommitService.getGitHubCommits());
    }
}
