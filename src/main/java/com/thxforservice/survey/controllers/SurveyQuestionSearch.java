package com.thxforservice.survey.controllers;

import com.thxforservice.global.CommonSearch;
import lombok.Data;

import java.util.List;

@Data
public class SurveyQuestionSearch extends CommonSearch {

    private String srvyNo;
    private List<String> srvyNos; // 게시한 ID 여러개
}
