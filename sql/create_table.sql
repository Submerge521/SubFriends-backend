create database subfriends;
use subfriends;

create table if not exists subfriends.blog
(
    id           bigint auto_increment comment '主键'
        primary key,
    user_id      bigint                                   not null comment '用户id',
    title        varchar(255) collate utf8mb4_unicode_ci  not null comment '标题',
    images       varchar(2048)                            null comment '图片，最多9张，多张以","隔开',
    content      varchar(2048) collate utf8mb4_unicode_ci not null comment '文章',
    liked_num    int unsigned default '0'                 null comment '点赞数量',
    comments_num int unsigned default '0'                 null comment '评论数量',
    create_time  timestamp    default CURRENT_TIMESTAMP   not null comment '创建时间',
    update_time  timestamp    default CURRENT_TIMESTAMP   not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    collate = utf8mb4_general_ci;

create table if not exists subfriends.blog_comments
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_id     bigint                                 not null comment '用户id',
    blog_id     bigint                                 not null comment '博文id',
    parent_id   bigint unsigned                        null comment '关联的1级评论id，如果是一级评论，则值为0',
    answer_id   bigint unsigned                        null comment '回复的评论id',
    content     varchar(255)                           not null comment '回复的内容',
    liked_num   int unsigned default '0'               null comment '点赞数',
    status      tinyint unsigned                       null comment '状态，0：正常，1：被举报，2：禁止查看',
    create_time timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    collate = utf8mb4_general_ci;

create table if not exists subfriends.blog_like
(
    id          bigint auto_increment comment '主键'
        primary key,
    blog_id     bigint                             not null comment '博文id',
    user_id     bigint                             not null comment '用户id',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete   tinyint  default 0                 null comment '逻辑删除'
)
    charset = utf8mb3;

create table if not exists subfriends.chat
(
    id          bigint auto_increment comment '聊天记录id'
        primary key,
    from_id     bigint                                  not null comment '发送消息id',
    to_id       bigint                                  null comment '接收消息id',
    text        varchar(512) collate utf8mb4_unicode_ci null,
    chat_type   tinyint                                 not null comment '聊天类型 1-私聊 2-群聊',
    create_time datetime default CURRENT_TIMESTAMP      null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP      null,
    team_id     bigint                                  null,
    is_delete   tinyint  default 0                      null
)
    comment '聊天消息表' collate = utf8mb4_general_ci;

create table if not exists subfriends.comment_like
(
    id          bigint auto_increment comment '主键'
        primary key,
    comment_id  bigint                             not null comment '评论id',
    user_id     bigint                             not null comment '用户id',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete   tinyint  default 0                 null comment '逻辑删除'
)
    collate = utf8mb4_general_ci;

create table if not exists subfriends.follow
(
    id             bigint auto_increment comment '主键'
        primary key,
    user_id        bigint                              not null comment '用户id',
    follow_user_id bigint                              not null comment '关注的用户id',
    create_time    timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time    timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete      tinyint   default 0                 null comment '逻辑删除'
)
    charset = utf8mb3;

create table if not exists subfriends.friends
(
    id          bigint auto_increment comment '好友申请id'
        primary key,
    from_id     bigint                             not null comment '发送申请的用户id',
    receive_id  bigint                             null comment '接收申请的用户id ',
    is_read     tinyint  default 0                 not null comment '是否已读(0-未读 1-已读)',
    status      tinyint  default 0                 not null comment '申请状态 默认0 （0-未通过 1-已同意 2-已过期 3-已撤销）',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null,
    is_delete   tinyint  default 0                 not null comment '是否删除',
    remark      varchar(214)                       null comment '好友申请备注信息'
)
    comment '好友申请管理表' collate = utf8mb4_general_ci;

create table if not exists subfriends.message
(
    id          bigint auto_increment comment '主键'
        primary key,
    type        tinyint                            null comment '类型-1 点赞',
    from_id     bigint                             null comment '消息发送的用户id',
    to_id       bigint                             null comment '消息接收的用户id',
    data        varchar(255)                       null comment '消息内容',
    is_read     tinyint  default 0                 null comment '已读-0 未读 ,1 已读',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete   tinyint  default 0                 null comment '逻辑删除'
)
    collate = utf8mb4_general_ci;

create table if not exists subfriends.sign
(
    id        bigint auto_increment comment '主键'
        primary key,
    user_id   bigint           not null comment '用户id',
    year      year             not null comment '签到的年',
    month     tinyint          not null comment '签到的月',
    date      date             not null comment '签到的日期',
    is_backup tinyint unsigned null comment '是否补签'
)
    charset = utf8mb3;

create table if not exists subfriends.tag
(
    id         bigint auto_increment comment 'id'
        primary key,
    tagName    varchar(256)                       null comment '标签名称',
    userId     bigint                             null comment '用户 id',
    parentId   bigint                             null comment '父标签 id',
    isParent   tinyint                            null comment '0 - 不是, 1 - 父标签',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0                 not null comment '是否删除',
    constraint uniIdx_tagName
        unique (tagName)
)
    comment '标签';

create index idx_userId
    on subfriends.tag (userId);

create table if not exists subfriends.team
(
    id          bigint auto_increment comment 'id'
        primary key,
    name        varchar(256)                       not null comment '队伍名称',
    description varchar(1024)                      null comment '描述',
    maxNum      int      default 1                 not null comment '最大人数',
    expireTime  datetime                           null comment '过期时间',
    userId      bigint                             null comment '用户id（队长 id）',
    status      int      default 0                 not null comment '0 - 公开，1 - 私有，2 - 加密',
    password    varchar(512)                       null comment '密码',
    createTime  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete    tinyint  default 0                 not null comment '是否删除'
)
    comment '队伍';

create table if not exists subfriends.user
(
    username     varchar(256)                       null comment '用户昵称',
    id           bigint auto_increment comment 'id'
        primary key,
    userAccount  varchar(256)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '用户头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(512)                       not null comment '密码',
    phone        varchar(128)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '状态 0 - 正常',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    stuCode      varchar(512)                       null comment '学号编号',
    tags         varchar(1024)                      null comment '标签 json 列表'
)
    comment '用户';

create table if not exists subfriends.user_team
(
    id         bigint auto_increment comment 'id'
        primary key,
    userId     bigint                             null comment '用户id',
    teamId     bigint                             null comment '队伍id',
    joinTime   datetime                           null comment '加入时间',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0                 not null comment '是否删除'
)
    comment '用户队伍关系';



