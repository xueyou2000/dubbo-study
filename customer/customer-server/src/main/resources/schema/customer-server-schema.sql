/*==============================================================*/
/* DBMS NAME:      MYSQL 5.0                                    */
/* CREATED ON:     2020/09/27 星期日 15:32:42                    */
/* UPDATE ON:      2020/09/27 星期日 15:32:42                    */
/*==============================================================*/

DROP TABLE IF EXISTS customer;

/*==============================================================*/
/* Table: customer                                               */
/*==============================================================*/
create table customer
(
    customer_id          bigint(20) not null comment '商户id',
    version              int comment '欢乐锁',
    create_time          datetime null default CURRENT_TIMESTAMP comment '创建时间',
    update_time          datetime null default CURRENT_TIMESTAMP comment '更新时间',
    full_name            varchar(60) not null comment '商户全称',
    sort_name            varchar(60) not null comment '商户简称',
    business_address     varchar(60) not null comment '营业地址',
    link_name            varchar(30) not null comment '联系人名称',
    link_phone            varchar(20) not null comment '联系人手机号',
    primary key (customer_id)
) comment='商户信息';
