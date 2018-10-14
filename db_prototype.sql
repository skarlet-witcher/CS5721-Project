CREATE TABLE user (
  id               BIGINT                 AUTO_INCREMENT PRIMARY KEY,
  user_id          bigint UNIQUE not null
  comment 'user visible, for login. get by auto-generated',
  pin              int           not null
  comment 'get by auto-generated 6 digit',
  login_pin_digit  int comment '3 digit, represent which 3 of 6 digit user has to input. get by auto-generated',
  first_name       varchar(32)   not null,
  last_name        varchar(32)   not null,
  identity_id      varchar(50)   not null
  comment 'passport/license id number',
  identity_id_type int           not null
  comment '1.passport 2.driver license',
  gender           int           not null
  comment '0. woman 1.man',
  birth_date       datetime      not null,
  address          varchar(255)  not null,
  email            varchar(255)  not null,
  phone            varchar(20)   not null,
  status           int           not null default 1
  comment '0.blocked 1.normal 2.pending for being deleted 3.deleted.'
);

create table user_account (
  id             bigint                AUTO_INCREMENT PRIMARY KEY,
  account_number bigint       not null
  comment 'account number, the last 8 digit of iban',
  account_type   int          not null
  comment '1.current account 2.student current account',
  bic            varchar(255) not null default 'BOFIIE2DXXX',
  iban           varchar(255) not null
  comment 'iban, get by auto-generated.',
  user_id        bigint,
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE user_card (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  card_number   bigint   NOT NULL,
  card_type     int      not null                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             default 1
  comment '1.debit card 2.credit card(Not supported yet)',
  pin           int      not null
  comment 'get by auto-generated 6 digit',
  balance       double,
  currency_type int      not null                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             default 0
  comment '0.euro 1.....',
  expired_date  datetime not null,
  account_id    BIGINT,
  FOREIGN KEY (account_id) REFERENCES user_account (id)
);

CREATE TABLE user_card_transfer (
  id                 BIGINT          AUTO_INCREMENT PRIMARY KEY,
  transfer_no        BIGINT NOT NULL
  comment 'long int. get by auto-generated',
  from_card_id       bigint,
  to_payee_id        bigint,
  amount             double,
  currency_type      int    not null default 0
  comment '0.euro 1......',
  transaction_status INT,
  description        varchar(500),
  FOREIGN KEY (from_card_id) REFERENCES user_card (id),
  FOREIGN KEY (to_payee_id) REFERENCES user_payee (id)
);

create table user_payee (
  id      bigint AUTO_INCREMENT PRIMARY KEY,
  name    varchar(255) not null,
  iban    varchar(255) not null,
  user_id bigint comment 'whose payee',
  FOREIGN KEY (user_id) REFERENCES user (id)
);

create table bank_apply (
  id               bigint                AUTO_INCREMENT PRIMARY KEY,
  first_name       varchar(32)  not null,
  last_name        varchar(32)  not null,
  identity_id      varchar(50)  not null
  comment 'passport/license id number',
  identity_id_type int          not null
  comment '1.passport 2.driver license',
  account_type     int          not null
  comment '1.current account 2.student current account',
  graduate_date    datetime comment 'if the type is 2',
  birth_date       datetime     not null,
  gender           int          not null
  comment '0.woman 1.man',
  address          varchar(255) not null,
  email            varchar(128) not null,
  phone            varchar(20)  not null,
  apply_time       datetime     not null,
  status           int          not null default 0
  comment '0.pending for being approved 1.pass 2.deny',
  remark           varchar(255)          default ''
  comment 'Approved / reason for being denied.'
);

CREATE TABLE bank_staff (
  id             BIGINT AUTO_INCREMENT PRIMARY KEY,
  staff_id       varchar(20) UNIQUE
  comment 'staff visible, for login. get by auto-generated',
  password       varchar(20),
  first_name     varchar(32),
  last_name      varchar(32),
  email_host     varchar(255),
  email_port     varchar(255),
  email          varchar(255),
  email_password varchar(255)
);

create table bank_admin (
  id       bigint AUTO_INCREMENT PRIMARY KEY,
  username varchar(255),
  password varchar(255)
);

CREATE TABLE user_operate (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
  operate_type        int comment '1.deposit 2.withdraw 3.transfer 4.change_phone 5.change_address 6.change_email 7.create 8.remove 9.login',
  operate_time        datetime not null,
  balance             double   not null,
  operate_description varchar(500),
  user_id             BIGINT,
  FOREIGN KEY (user_id) REFERENCES user (id)
);
