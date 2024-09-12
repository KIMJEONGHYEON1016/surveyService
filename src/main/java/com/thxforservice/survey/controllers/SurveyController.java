package com.thxforservice.survey.controllers;

import com.thxforservice.global.ListData;
import com.thxforservice.global.rests.JSONData;
import com.thxforservice.survey.entities.SurveyQuestion;
import com.thxforservice.survey.services.SurveyInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name="Survey", description = "설문 API")
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyInfoService infoService;

    /**
     * 1. 설문지 목록 조회  GET - /
     *      - 모든 회원이 열람할 수 있는 목록
     *
     * 2. 설문지 하나 조회 (답변 페이지) - GET /info/{srvyNo}
     * 3. 설문지 답변 등록 처리 - POST - /
     *
     * 마이페이지
     * 4. 답변한 설문지 목록
     *      GET - /answers
     *
     * 5. 답변 상세 내용
     *      GET - /answer/{prgrsNo}
     */

    @Operation(summary = "설문지 목록", method = "GET")
    @ApiResponse(responseCode = "200")
    @GetMapping("/list/{srvyNo}")
    public JSONData list(@PathVariable("srvyNo") String srvyNo, @ModelAttribute SurveyQuestionSearch search) {
        ListData<SurveyQuestion> data = infoService.getList(srvyNo, search);

        return new JSONData(data);
    }

    @Operation(summary = "설문지 하나 조회", method = "GET")
    @ApiResponse(responseCode = "200")
    @Parameter(name="srvyNo", required = true, description = "경로변수, 설문지 등록번호")
    @GetMapping("/info/{srvyNo}")
    public JSONData info(@PathVariable("srvyNo") Long srvyNo) {

        return null;
    }

    @Operation(summary = "답변 등록 처리", method = "POST")
    @ApiResponse(responseCode = "201")
    @PostMapping
    public ResponseEntity<Void> answerProcess() {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "답변한 설문지 목록", method = "GET")
    @ApiResponse(responseCode = "200")
    @GetMapping("/answers")
    public JSONData myAnswers() {

        return null;
    }

    @Operation(summary = "답변 상세 내용", method="GET")
    @ApiResponse(responseCode = "200")
    @Parameter(name="prgrsNo", required = true, description = "경로변수, 답변 등록 번호")
    @GetMapping("/answer/{prgrsNo}")
    public JSONData answer(@PathVariable("prgrsNo") Long prgrsNo) {

        return null;
    }

    @Operation(summary = "답변 삭제", method = "DELETE")
    @ApiResponse(responseCode = "200")
    @Parameter(name="prgrsNo", required = true, description = "경로변수, 답변 등록 번호")
    @DeleteMapping("/{prgrsNo}")
    public void delete(@PathVariable("prgrsNo") Long prgrsNo) {

    }
}
