package com.thxforservice.survey.repositories;

import com.thxforservice.survey.entities.SurveyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SurveyResultRepository extends JpaRepository<SurveyResult, Long>, QuerydslPredicateExecutor<SurveyResult> {
}
