create database sampleCollecting;

use sampleCollecting;

CREATE TABLE user_account
(
    user_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user_account PRIMARY KEY (user_id)
);

CREATE TABLE project
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    project_name VARCHAR(255)       NULL,
    project_desc VARCHAR(255)       NULL,
    owner_id     VARCHAR(255)       NULL,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

ALTER TABLE project
    ADD CONSTRAINT FK_PROJECT_ON_OWNER FOREIGN KEY (owner_id) REFERENCES user_account (user_id);

CREATE TABLE stage
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    start_date date               NULL,
    end_date   date               NULL,
    project_id BIGINT                NULL,
    CONSTRAINT pk_stage PRIMARY KEY (id)
);

ALTER TABLE stage
    ADD CONSTRAINT FK_STAGE_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);

CREATE TABLE sample
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    image_path VARCHAR(255)       NULL,
    stage_id   BIGINT                NULL,
    CONSTRAINT pk_sample PRIMARY KEY (id)
);

ALTER TABLE sample
    ADD CONSTRAINT FK_SAMPLE_ON_STAGE FOREIGN KEY (stage_id) REFERENCES stage (id);

CREATE TABLE sample_field
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    field_name  VARCHAR(255)       NULL,
    field_value VARCHAR(255)       NULL,
    sample_id   BIGINT                NULL,
    CONSTRAINT pk_sample_field PRIMARY KEY (id)
);

ALTER TABLE sample_field
    ADD CONSTRAINT FK_SAMPLE_FIELD_ON_SAMPLE FOREIGN KEY (sample_id) REFERENCES sample (id);

insert into user_account value ('bang123');
insert into project value (1, 'testProjectName', 'testProjectDesc', 'bang123');
insert into stage value(1, DATE('2024-05-16'), Date('2024-05-30'), 1);
insert into sample value (1, 'vsdfv/sfdbfdsb/agergerg', 1);
insert into sample_field value (1, 'testFieldName', 'testFieldValue', 1);