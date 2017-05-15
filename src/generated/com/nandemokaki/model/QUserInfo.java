package com.nandemokaki.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = -694417753L;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final StringPath birthDay = createString("birthDay");

    public final DateTimePath<java.sql.Timestamp> createdTime = createDateTime("createdTime", java.sql.Timestamp.class);

    public final StringPath createdUser = createString("createdUser");

    public final DateTimePath<java.sql.Timestamp> lastLogin = createDateTime("lastLogin", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastUpdate = createDateTime("lastUpdate", java.sql.Timestamp.class);

    public final StringPath location = createString("location");

    public final StringPath loginIp = createString("loginIp");

    public final NumberPath<Integer> sex = createNumber("sex", Integer.class);

    public final StringPath updateUser = createString("updateUser");

    public final StringPath userId = createString("userId");

    public final StringPath userPass = createString("userPass");

    public QUserInfo(String variable) {
        super(UserInfo.class, forVariable(variable));
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfo(PathMetadata<?> metadata) {
        super(UserInfo.class, metadata);
    }

}

