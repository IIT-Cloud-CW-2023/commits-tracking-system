package com.DeveloperProductivityTracker.commitstrackingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitHubCommitsDto {
    @JsonProperty("sha")
    private String sha;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("commit")
    private Commit commit;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("author")
    private Author author;

    @JsonProperty("committer")
    private Author committer;

    @JsonProperty("parents")
    private Parent[] parents;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Commit {
        private Author author;
        private Author committer;
        private String message;
        private Tree tree;
        private String url;
        private int comment_count;
        private Verification verification;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Author {
        private String login;
        private int id;
        private String node_id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private boolean site_admin;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tree {
        private String sha;
        private String url;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Verification {
        private boolean verified;
        private String reason;
        private String signature;
        private String payload;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Parent {
        private String sha;
        private String url;
        private String html_url;
    }
}
