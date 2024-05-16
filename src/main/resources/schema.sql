drop database if exists scPostService;
create database scPostService;

use scPostService;

CREATE TABLE user_account
(
    user_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user_account PRIMARY KEY (user_id)
);

CREATE TABLE post
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    owner_id VARCHAR(255)          NULL,
    CONSTRAINT pk_post PRIMARY KEY (id)
);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_OWNER FOREIGN KEY (owner_id) REFERENCES user_account (user_id);

CREATE TABLE comment
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    content      VARCHAR(255)          NULL,
    post_time    datetime              NULL,
    post_id      BIGINT                NULL,
    user_account VARCHAR(255)          NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_POST FOREIGN KEY (post_id) REFERENCES post (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_USER_ACCOUNT FOREIGN KEY (user_account) REFERENCES user_account (user_id);