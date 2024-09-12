package com.thxforservice.survey.services;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thxforservice.global.ListData;
import com.thxforservice.global.Pagination;
import com.thxforservice.survey.constants.DeleteStatus;
import com.thxforservice.survey.controllers.SurveyQuestionSearch;
import com.thxforservice.survey.entities.QSurveyQuestion;
import com.thxforservice.survey.entities.SurveyInfo;
import com.thxforservice.survey.entities.SurveyQuestion;
import com.thxforservice.survey.repositories.SurveyQuestionRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class SurveyInfoService {

    private final JPAQueryFactory queryFactory;
    private final SurveyQuestionRepository questionRepository;
    private final HttpServletRequest request;

    public SurveyInfo get(Long srvyNo) {
        return null;
    }

    // 설문 목록 조회
    public ListData<SurveyQuestion> getList(SurveyQuestionSearch search, DeleteStatus status) {

        String srvyNo = search.getSrvyNo();
        List<String> srvyNos = search.getSrvyNos(); // 설문 여러개 조회

        SurveyInfo surveyInfo = new SurveyInfo();

        int page = Math.max(search.getPage(), 1);
        int limit = search.getLimit();

        int offset = (page - 1) * limit;

        // 삭제가 되지 않은 설문 문항 목록이 기본 값
        status = Objects.requireNonNullElse(status, DeleteStatus.UNDELETED);




        /* 검색 처리 S */
        QSurveyQuestion surveyQuestion = QSurveyQuestion.surveyQuestion;
        BooleanBuilder andBuilder = new BooleanBuilder();

        // 삭제, 미삭제 게시글 조회 처리
        if (status != DeleteStatus.ALL) {
            if (status == DeleteStatus.UNDELETED) {
                andBuilder.and(surveyQuestion.deletedAt.isNull()); // 미삭된 설문 문항
            } else {
                andBuilder.and(surveyQuestion.deletedAt.isNotNull()); // 삭제된 설문 문항
            }
        }

        if (srvyNo != null && StringUtils.hasText(srvyNo.trim())) { // 설문별 조회
            srvyNos = List.of(srvyNo);
        }

        if (srvyNos != null && !srvyNos.isEmpty()) { // 설문 여러개 조회
            andBuilder.and(surveyQuestion.surveyInfo.srvyNo.in(srvyNos));
        }

        /**
         * 조건 검색 처리
         *
         * sopt - ALL : 통합검색(제목 + 내용 + 글작성자(작성자, 회원명))
         *       SUBJECT : 제목검색
         *       CONTENT : 내용검색
         *       SUBJECT_CONTENT: 제목 + 내용 검색
         *       NAME : 이름(작성자, 회원명)
         */

            /* 목록 조회 처리 S */
            List<SurveyQuestion> items = queryFactory
                    .selectFrom(surveyQuestion)
                    .leftJoin(surveyQuestion.surveyInfo)
                    .fetchJoin()
                    .where(andBuilder)
                    .offset(offset)
                    .limit(limit)
                    .fetch();

            // 추가 정보 처리
//        items.forEach(this::addInfo);

            /* 목록 조회 처리 E */

            // 전체 설문 문항 갯수
            long total = questionRepository.count(andBuilder);

//        // 페이징 처리
            int ranges = surveyInfo.getPageCountPc();

            Pagination pagination = new Pagination(page, (int) total, ranges, limit, request);

            return new ListData<>(items, pagination);
    }

    /**
     * 게시판 별 목록
     *
     * @param srvyNo
     * @param search
     * @return
     */
    public ListData<SurveyQuestion> getList(String srvyNo, SurveyQuestionSearch search, DeleteStatus status) {
        search.setSrvyNo(srvyNo);

        return getList(search, status);
    }

    public ListData<SurveyQuestion> getList(String srvyNo, SurveyQuestionSearch search) {
        return getList(srvyNo, search, DeleteStatus.UNDELETED);
    }
}