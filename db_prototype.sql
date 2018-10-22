CREATE TABLE user (
  id              BIGINT                 AUTO_INCREMENT PRIMARY KEY,
  user_id         bigint UNIQUE not null
  comment 'user visible, for login. get by auto-generated',
  pin             varchar(6)    not null
  comment 'get by auto-generated 6 digit',
  login_pin_digit varchar(3) comment '3 digit, represent which 3 of 6 digit user has to input. get by auto-generated',
  first_name      varchar(255)  not null,
  last_name       varchar(255)  not null,
  gender          int           not null
  comment '0. woman 1.man',
  birth_date      datetime      not null,
  address         varchar(255)  not null,
  email           varchar(255)  not null,
  phone           varchar(20)   not null,
  status          int           not null default 1
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
  status         int          not null default 1
  comment '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE user_card (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  card_number   bigint   NOT NULL,
  card_type     int        not null                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             default 1
  comment '1.debit card 2.credit card(Not supported yet)',
  pin           varchar(6) not null
  comment 'get by auto-generated 6 digit',
  balance       double,
  currency_type int        not null                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             default 0
  comment '0.euro 1.....',
  expired_date  datetime not null,
  account_id    BIGINT   not null,
  status        int      not null default 1
  comment '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  FOREIGN KEY (account_id) REFERENCES user_account (id)
);

create table user_payee (
  id      bigint AUTO_INCREMENT PRIMARY KEY,
  name    varchar(255) not null,
  iban    varchar(255) not null,
  user_id bigint comment 'whose payee',
  FOREIGN KEY (user_id) REFERENCES user (id)
);

create table bank_apply (
  id                bigint                        AUTO_INCREMENT PRIMARY KEY,
  first_name        varchar(255) not null,
  last_name         varchar(255) not null,
  identity_id       varchar(50)  not null
  comment 'passport/license id number',
  identity_id_type  int          not null
  comment '1.passport 2.driver license',
  account_type      int          not null
  comment '1.current account 2.student current account 3.young saver account 4.golden older account',
  card_type         int          not null
  comment '1.debit card 2.credit card(Not supported yet)',
  graduate_date     datetime
  comment 'if the account type is student current account',
  university        varchar(255)
  comment 'if the account type is student current account',
  student_id        varchar(50)
  comment 'if the account type is student current account',
  parent_user_id    bigint
  comment 'if the account type is young savers account',
  parent_first_name varchar(255)
  comment 'if the account type is young savers account',
  parent_last_name  varchar(255)
  comment 'if the account type is young savers account',
  birth_date        datetime     not null,
  gender            int          not null
  comment '0.woman 1.man',
  address           varchar(255) not null,
  email             varchar(255) not null,
  phone             varchar(20)  not null,
  apply_time        datetime     not null,
  status            int          not null         default 0
  comment '0.pending for being approved 1.pass 2.deny',
  remark            varchar(255) not null         default ''
  comment 'Approved / reason for being denied.',
  user_id           bigint
  comment 'after being approved, get connected to user id'
);

CREATE TABLE bank_staff (
  id         BIGINT AUTO_INCREMENT PRIMARY KEY,
  staff_id   bigint UNIQUE not null
  comment 'staff visible, for login. get by auto-generated',
  password   varchar(255)  not null,
  first_name varchar(255)  not null,
  last_name  varchar(255)  not null,
  email      varchar(255)  not null,
  status     int           not null
  comment '0.invalid 1.valid'
);

create table bank_admin (
  id             bigint                AUTO_INCREMENT PRIMARY KEY,
  username       varchar(255) not null,
  password       varchar(255) not null,
  email_host     varchar(255) not null default '',
  email_port     varchar(255) not null default '',
  email_account  varchar(255) not null default '',
  email_password varchar(255) not null default ''
);

CREATE TABLE user_operation_history (
  id             BIGINT            AUTO_INCREMENT PRIMARY KEY,
  operate_no     varchar(255)   not null
  comment 'long int. get by auto-generated',
  operate_type   int comment '0.charge 1.deposit 2.withdraw 3.transfer sent 4.transfer received 5.change_profile 6.login 7.create 8.remove',
  operate_time   datetime not null,
  operate_source int comment '1.self-service 2.ATM 3.other',
  amount         double,
  currency_type  int
  comment '0.euro 1......',
  balance        double,
  description    varchar(500),
  status         int      not null
  comment '0.pending 1.fail 2.success',
  user_id        BIGINT,
  to_payee_id    BIGINT,
  account_id     BIGINT,
  FOREIGN KEY (user_id) REFERENCES user (id),
  foreign key (to_payee_id) references user_payee (id),
  FOREIGN KEY (account_id) REFERENCES user_account (id)
);
