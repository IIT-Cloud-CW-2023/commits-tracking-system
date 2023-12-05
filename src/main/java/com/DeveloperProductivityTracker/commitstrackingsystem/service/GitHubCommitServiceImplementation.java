package com.DeveloperProductivityTracker.commitstrackingsystem.service;

import com.DeveloperProductivityTracker.commitstrackingsystem.dto.GitHubCommitsDto;
import com.DeveloperProductivityTracker.commitstrackingsystem.model.GitHubCommit;
import com.DeveloperProductivityTracker.commitstrackingsystem.repository.GitHubCommitsRepository;
import com.DeveloperProductivityTracker.commitstrackingsystem.service.external.GitHubExternalCommits;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubCommitServiceImplementation implements GitHubCommitService {
    private final GitHubExternalCommits gitHubExternalCommits;
    private final GitHubCommitsRepository gitHubCommitsRepository;

    @Override
    public List<GitHubCommit> getGitHubCommits() {
        List<GitHubCommit> gitHubCommits = new ArrayList<>();

        List<GitHubCommitsDto> gitHubCommitsDtoList = this.gitHubExternalCommits.getUserDetails();

        gitHubCommitsDtoList.forEach(gitHubCommitsDto -> {
            GitHubCommit gitHubCommit = this.generateGitHubCommitsObject(gitHubCommitsDto);
            gitHubCommits.add(gitHubCommit);
        });

        this.gitHubCommitsRepository.saveAll(gitHubCommits);

        return gitHubCommits;

    }
    private GitHubCommit generateGitHubCommitsObject(GitHubCommitsDto gitHubCommitsDto) {
        return GitHubCommit.builder()
                .gitHubId(gitHubCommitsDto.getId())
                .login(gitHubCommitsDto.getLogin())
                .contributions(gitHubCommitsDto.getContributions())
                .type(gitHubCommitsDto.getType())
                .siteAdmin(gitHubCommitsDto.isSiteAdmin())
                .reposUrl(gitHubCommitsDto.getReposUrl())
                .nodeId(gitHubCommitsDto.getNodeId())
                .build();
    }

}
