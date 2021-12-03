drop table if exists interview_has_tag;
drop table if exists thumb;
drop table if exists pre_answer;
drop table if exists comment;
drop table if exists interview;
drop table if exists user;
drop table if exists tag;

create table tag
(
    id   bigint auto_increment
        primary key,
    type varchar(10) not null,
    name varchar(20) not null,
    constraint name
        unique (name)
);

create table user
(
    id         bigint auto_increment
        primary key,
    email      varchar(50)          not null,
    password   varchar(40)          null,
    nickname   varchar(20)          not null,
    role       varchar(12)          not null,
    provider   varchar(10)          not null,
    deleted    tinyint(1) default 0 not null,
    created_at datetime             not null,
    updated_at datetime             not null,
    constraint email
        unique (email, nickname)
);

create table interview
(
    id         bigint auto_increment
        primary key,
    user_id    bigint       not null,
    question   varchar(150) not null,
    answer     varchar(300) not null,
    created_at datetime     not null,
    updated_at datetime     not null,
    constraint FK_user_TO_interview_1
        foreign key (user_id) references user (id)
);

create table comment
(
    id           bigint auto_increment
        primary key,
    interview_id bigint       not null,
    user_id      bigint       not null,
    comment_id   bigint       null,
    content      varchar(100) not null,
    created_at   datetime     not null,
    updated_at   datetime     not null,
    constraint FK_comment_TO_comment_1
        foreign key (comment_id) references comment (id),
    constraint FK_interview_TO_comment_1
        foreign key (interview_id) references interview (id),
    constraint FK_user_TO_comment_1
        foreign key (user_id) references user (id)
);

create table interview_has_tag
(
    id           bigint auto_increment
        primary key,
    interview_id bigint not null,
    tag_id       bigint not null,
    constraint FK_interview_TO_interview_has_tag_1
        foreign key (interview_id) references interview (id),
    constraint FK_tag_TO_interview_has_tag_1
        foreign key (tag_id) references tag (id)
);

create table pre_answer
(
    id           bigint auto_increment
        primary key,
    user_id      bigint       not null,
    interview_id bigint       not null,
    content      varchar(300) not null,
    created_at   datetime     not null,
    updated_at   datetime     not null,
    constraint FK_interview_TO_pre_answer_1
        foreign key (interview_id) references interview (id),
    constraint FK_user_TO_pre_answer_1
        foreign key (user_id) references user (id)
);

create table thumb
(
    id           bigint auto_increment
        primary key,
    user_id      bigint   not null,
    interview_id bigint   not null,
    created_at   datetime not null,
    constraint FK_interview_TO_like_1
        foreign key (interview_id) references interview (id),
    constraint FK_user_TO_like_1
        foreign key (user_id) references user (id)
);

