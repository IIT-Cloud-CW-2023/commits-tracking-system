package com.DeveloperProductivityTracker.commitstrackingsystem.service.external;

import com.DeveloperProductivityTracker.commitstrackingsystem.dto.GitHubCommitsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GitHubExternalCommits {

    private final RestTemplate restTemplate;

    @Value("${github.user-detail-url}")
    private String gitHubUserDetailsUrl;

    public GitHubExternalCommits(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubCommitsDto> getUserDetails() {
        ResponseEntity<List<GitHubCommitsDto>> response = restTemplate.exchange(gitHubUserDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }
}
