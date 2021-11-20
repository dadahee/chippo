DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `user_id`	bigint	NOT NULL,
    `interview_id`	bigint	NOT NULL,
    `created_at`	datetime	NOT NULL
);

DROP TABLE IF EXISTS `pre_answer`;

CREATE TABLE `pre_answer` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `user_id`	bigint	NOT NULL,
    `interview_id`	bigint	NOT NULL,
    `content`	varchar(300)	NOT NULL,
    `created_at`	datetime	NOT NULL,
    `updated_at`	datetime	NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `interview_id`	bigint	NOT NULL,
    `user_id`	bigint	NOT NULL,
    `comment_id`	bigint	NULL,
    `content`	varchar(100)	NOT NULL,
    `created_at`	datetime	NOT NULL,
    `updated_at`	datetime	NOT NULL
);

DROP TABLE IF EXISTS `interview_has_tag`;

CREATE TABLE `interview_has_tag` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `interview_id`	bigint	NOT NULL,
    `tag_id`	bigint	NOT NULL
);

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `type`	varchar(10)	NOT NULL,
    `name`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `interview`;

CREATE TABLE `interview` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `user_id`	bigint	NOT NULL,
    `question`	varchar(150)	NOT NULL,
    `answer`	varchar(300)	NOT NULL,
    `visible`	boolean	NOT NULL	DEFAULT 1,
    `created_at`	datetime	NOT NULL,
    `updated_at`	datetime	NOT NULL
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id`	bigint	PRIMARY KEY AUTO_INCREMENT,
    `email`	varchar(50)	NOT NULL,
    `password`	varchar(40)	NULL,
    `nickname`	varchar(20)	NOT NULL,
    `role`	varchar(12)	NOT NULL,
    `provider`	varchar(10)	NOT NULL,
    `activated`	boolean	NOT NULL	DEFAULT 1,
    `deleted`	boolean	NOT NULL	DEFAULT 0,
    `created_at`	datetime	NOT NULL,
    `updated_at`	datetime	NOT NULL
);


ALTER TABLE `interview` ADD CONSTRAINT `FK_user_TO_interview_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`);

ALTER TABLE `interview_has_tag` ADD CONSTRAINT `FK_interview_TO_interview_has_tag_1`
    FOREIGN KEY (`interview_id`)
    REFERENCES `interview` (`id`);

ALTER TABLE `interview_has_tag` ADD CONSTRAINT `FK_tag_TO_interview_has_tag_1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `tag` (`id`);

ALTER TABLE `comment` ADD CONSTRAINT `FK_interview_TO_comment_1`
    FOREIGN KEY (`interview_id`)
    REFERENCES `interview` (`id`);

ALTER TABLE `comment` ADD CONSTRAINT `FK_user_TO_comment_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`);

ALTER TABLE `comment` ADD CONSTRAINT `FK_comment_TO_comment_1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `comment` (`id`);

ALTER TABLE `pre_answer` ADD CONSTRAINT `FK_user_TO_pre_answer_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`);

ALTER TABLE `pre_answer` ADD CONSTRAINT `FK_interview_TO_pre_answer_1`
    FOREIGN KEY (`interview_id`)
    REFERENCES `interview` (`id`);

ALTER TABLE `like` ADD CONSTRAINT `FK_user_TO_like_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`);

ALTER TABLE `like` ADD CONSTRAINT `FK_interview_TO_like_1`
    FOREIGN KEY (`interview_id`)
    REFERENCES `interview` (`id`);

ALTER TABLE `user` ADD UNIQUE (email, nickname);
ALTER TABLE `tag` ADD UNIQUE (name);