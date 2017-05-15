package com.nandemokaki.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QEmailAck is a Querydsl query type for EmailAck
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmailAck extends EntityPathBase<EmailAck> {

    private static final long serialVersionUID = 333504219L;

    public static final QEmailAck emailAck = new QEmailAck("emailAck");

    public final StringPath motoJpgNm = createString("motoJpgNm");

    public final NumberPath<Integer> recvCnt = createNumber("recvCnt", Integer.class);

    public final DateTimePath<java.sql.Timestamp> recvTime = createDateTime("recvTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> sendNo = createNumber("sendNo", Integer.class);

    public final DateTimePath<java.sql.Timestamp> sendTime = createDateTime("sendTime", java.sql.Timestamp.class);

    public QEmailAck(String variable) {
        super(EmailAck.class, forVariable(variable));
    }

    public QEmailAck(Path<? extends EmailAck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmailAck(PathMetadata<?> metadata) {
        super(EmailAck.class, metadata);
    }

}

