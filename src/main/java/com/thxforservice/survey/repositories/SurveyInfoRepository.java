package com.thxforservice.survey.repositories;

import com.thxforservice.survey.entities.SurveyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SurveyInfoRepository extends JpaRepository<SurveyInfo, Long>, QuerydslPredicateExecutor<SurveyInfo> {

}
