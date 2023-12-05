package com.DeveloperProductivityTracker.commitstrackingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.DeveloperProductivityTracker.commitstrackingsystem.model.GitHubCommit;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubCommitsRepository extends MongoRepository<GitHubCommit, String> {
}
