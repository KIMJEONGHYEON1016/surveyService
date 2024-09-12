package com.thxforservice.survey.entities;

import com.thxforservice.global.entities.BaseMemberEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="SRVY_QITEM_INFO")
public class SurveyQuestion extends BaseMemberEntity {
    @Id @GeneratedValue
    @Column(name="srvyQitemNo")
    private Long itemNo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="srvyNo")
    private SurveyInfo surveyInfo;

    @Column(name="srvyQItemTTL")
    private String title;

    @Column(name="srvyQItemNowUseYN")
    private Boolean use;

    // 문항1....^^1||문항2......^^2||문항3...^^3
    @Lob
    private String questions; // 문항
}


