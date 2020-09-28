/*==============================================================*/
/* DBMS NAME:      MYSQL 5.0                                    */
/* CREATED ON:     2020/09/27 星期日 15:32:42                    */
/* UPDATE ON:      2020/09/27 星期日 15:32:42                    */
/*==============================================================*/

DROP TABLE IF EXISTS account;

DROP INDEX idx_acc_user ON account;

/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
create table account
(
    account_id                   bigint(20) not null comment '账户ID',
    version              int comment '欢乐锁',
    create_time          datetime null default CURRENT_TIMESTAMP comment '创建时间',
    update_time          datetime null default CURRENT_TIMESTAMP comment '更新时间',
    account_type         varchar(30) not null comment '账户类型',
    account_status       varchar(30) not null comment '账户状态',
    balance              double(11,2) not null comment '账户余额',
    transit_bal          double(11,2) not null comment '在途金额',
    freeze_bal           double(11,2) not null comment '冻结金额',
    user_id              bigint(20) not null comment '用户ID',
    user_type            varchar(30) not null comment '用户类型',
    primary key (account_id)
) comment='账户信息';

/*==============================================================*/
/* INDEX: idx_acc_user                                          */
/*==============================================================*/
CREATE UNIQUE INDEX idx_acc_user ON account
(
    user_id,
    user_type,
    account_type
);