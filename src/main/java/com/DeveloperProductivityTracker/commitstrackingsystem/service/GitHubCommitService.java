package com.DeveloperProductivityTracker.commitstrackingsystem.service;

import com.DeveloperProductivityTracker.commitstrackingsystem.model.GitHubCommit;

import java.util.List;
public interface GitHubCommitService {
    List<GitHubCommit> getGitHubCommits();
}
