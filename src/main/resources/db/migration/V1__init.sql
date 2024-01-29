CREATE TABLE address
(
    id        BIGINT NOT NULL,
    city      VARCHAR(255) NULL,
    street    VARCHAR(255) NULL,
    number    INT    NOT NULL,
    zipcode   VARCHAR(255) NULL,
    latitude  VARCHAR(255) NULL,
    longitude VARCHAR(255) NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE user
(
    id         BIGINT NOT NULL,
    email      VARCHAR(255) NULL,
    user_name  VARCHAR(255) NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    phone_no   VARCHAR(255) NULL,
    address_id BIGINT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);