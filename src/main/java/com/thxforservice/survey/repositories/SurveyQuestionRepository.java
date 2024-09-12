package com.thxforservice.survey.repositories;

import com.thxforservice.survey.entities.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long>, QuerydslPredicateExecutor<SurveyQuestion> {
}
