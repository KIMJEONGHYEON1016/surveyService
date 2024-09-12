package com.thxforservice.survey.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSurveyInfo is a Querydsl query type for SurveyInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSurveyInfo extends EntityPathBase<SurveyInfo> {

    private static final long serialVersionUID = -406311892L;

    public static final QSurveyInfo surveyInfo = new QSurveyInfo("surveyInfo");

    public final com.thxforservice.global.entities.QBaseMemberEntity _super = new com.thxforservice.global.entities.QBaseMemberEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath criteriaInfo = createString("criteriaInfo");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath srvyExpln = createString("srvyExpln");

    public final StringPath srvyNm = createString("srvyNm");

    public final StringPath srvyNo = createString("srvyNo");

    public final StringPath srvyReqHr = createString("srvyReqHr");

    public final BooleanPath srvyUse = createBoolean("srvyUse");

    public QSurveyInfo(String variable) {
        super(SurveyInfo.class, forVariable(variable));
    }

    public QSurveyInfo(Path<? extends SurveyInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSurveyInfo(PathMetadata metadata) {
        super(SurveyInfo.class, metadata);
    }

}

