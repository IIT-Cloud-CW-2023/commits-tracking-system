package com.DeveloperProductivityTracker.commitstrackingsystem.model;

import com.DeveloperProductivityTracker.commitstrackingsystem.dto.GitHubCommitsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "github_commits")
public class GitHubCommit {
    @Id
    private String id;
    private String login;
    private int gitHubId;
    private String nodeId;
    private String reposUrl;
    private String type;
    private boolean siteAdmin;
    private int contributions;

    // Additional fields based on the modified GitHubCommitsDto class
    private String sha;
    private String url;
    private String htmlUrl;
    private String commentsUrl;
    private GitHubCommitsDto.Author author;
    private GitHubCommitsDto.Author committer;
    private GitHubCommitsDto.Parent[] parents;
}
