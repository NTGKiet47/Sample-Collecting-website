drop database if exists scPostService;
create database scPostService;

use scPostService;
CREATE TABLE post
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    content VARCHAR(255)          NULL,
    CONSTRAINT pk_post PRIMARY KEY (id)
);

CREATE TABLE sample
(
    id         BIGINT       NOT NULL,
    image_path VARCHAR(255) NULL,
    post_id    BIGINT       NULL,
    CONSTRAINT pk_sample PRIMARY KEY (id)
);

ALTER TABLE sample
    ADD CONSTRAINT FK_SAMPLE_ON_POST FOREIGN KEY (post_id) REFERENCES post (id);

CREATE TABLE sample_field
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    field_name  VARCHAR(255)          NULL,
    field_value VARCHAR(255)          NULL,
    sample_id   BIGINT                NULL,
    CONSTRAINT pk_sample_field PRIMARY KEY (id)
);

ALTER TABLE sample_field
    ADD CONSTRAINT FK_SAMPLE_FIELD_ON_SAMPLE FOREIGN KEY (sample_id) REFERENCES sample (id);
