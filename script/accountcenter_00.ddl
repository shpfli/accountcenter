drop database if exists accountcenter_00;
create database accountcenter_00;

use accountcenter_00;


drop table if exists tcc_main_transaction_00;
create table tcc_main_transaction_00
(
    tenant_id     varchar(8)   not null comment '租户ID',
    xid           varchar(128) not null comment 'TCC事务 ID',
    account_book  varchar(10)  not null comment '账本',
    status        char         not null comment '事务状态：P-预处理，R-已回滚，C-已提交',
    created_time  bigint       null comment '创建时间（毫秒数）',
    modified_time bigint       null comment '修改时间（毫秒数）',
    primary key (tenant_id, xid, account_book),
    key idx_tcc_main_transaction_00 (tenant_id, status, created_time)
)
    comment 'TCC 主事务表' charset = utf8mb4;

drop table if exists tcc_branch_transaction_00;
create table tcc_branch_transaction_00
(
    id                    bigint unsigned auto_increment comment 'id' primary key,
    tenant_id             varchar(8)     not null comment '租户ID',
    account_book          varchar(16)    not null comment '账本',
    xid                   varchar(128)   not null comment '主事务记录',
    branch_id             bigint                  default null comment '分支事务记录',
    account_no            varchar(32)    not null comment '账号',
    balance_type          varchar(8)     not null default 'DEFAULT' comment '余额类型',
    accounting_time       bigint         not null comment '记账时间',
    accounting_Date       bigint         not null comment '会计日',
    currency              varchar(3)     not null comment '币种',
    action                varchar(8)     not null comment '记账动作: IN, OUT, FREEZE, UNFREEZE, DEBIT, CREDIT',
    amount                decimal(21, 4) not null comment '金额',
    request_unique_id     varchar(32)    not null comment '记账请求唯一ID，用于业务幂等',
    trans_seq_no          varchar(32)    not null comment '交易流水号',
    trans_inst            varchar(8)     null comment '交易机构',
    opposite_account_info varchar(32)    null comment '对手方账户信息',
    product_code          varchar(8)     not null comment '产品码',
    event_code            varchar(16)    not null comment '事件码',
    biz_product_code      varchar(8)     null comment '业务产品码',
    biz_event_code        varchar(16)    null comment '业务事件码',
    cnl_product_code      varchar(8)     null comment '端产品码',
    cnl_event_code        varchar(16)    null comment '端事件码',
    cnl_no                varchar(8)     null comment '产品码',
    memo                  varchar(128)   null comment '备注',
    created_time          bigint         null comment '创建时间（毫秒数）',
    modified_time         bigint         null comment '修改时间（毫秒数）',
    unique key uk_tcc_branch_transaction_00 (tenant_id, request_unique_id),
    key idx_tcc_branch_transaction_00 (tenant_id, account_book, xid)
)
    comment 'TCC 分支事务表' charset = utf8mb4;


drop table if exists tcc_transaction_amount_00;
create table tcc_transaction_amount_00
(
    id            bigint unsigned auto_increment comment 'id' primary key,
    tenant_id     varchar(8)     not null comment '租户ID',
    xid           varchar(128)   not null comment '主事务记录',
    account_book  varchar(10)    not null comment '账本',
    account_no    varchar(50)    not null comment '账号',
    balance_type  varchar(10)    not null comment '余额类型',
    amount_type   varchar(64)    not null comment '金额类型: BR - reserved balance, BU - unreached balance, FR - reserved freeze amount for unfreeze, FU - unreached freeze amount',
    currency      varchar(3)     not null comment 'Currencies',
    amount        decimal(21, 2) not null comment 'amount',
    created_time  bigint         null comment '创建时间（毫秒数）',
    modified_time bigint         null comment '修改时间（毫秒数）',
    unique key uk_tcc_transaction_amount_00 (xid, account_book, account_no, balance_type, amount_type)
)
    comment 'account amount prepare record';


drop table if exists acc_accounting_command_00;
create table acc_accounting_command_00
(
    id                bigint unsigned auto_increment comment 'id' primary key,
    tenant_id         varchar(8)     not null comment '租户ID',
    command_id        varchar(32)    not null comment '指令ID，分布式ID，逻辑主键',
    request_unique_id varchar(128)   not null comment '记账请求唯一ID，用于业务幂等',
    account_book      varchar(16)    not null comment '账本',
    xid               varchar(128)            default null comment '主事务记录',
    branch_id         bigint                  default null comment '分支事务记录',
    account_no        varchar(32)    not null comment '账号',
    balance_type      varchar(8)     not null default 'DEFAULT' comment '余额类型',
    accounting_time   bigint         not null comment '记账时间',
    accounting_Date   bigint         not null comment '会计日',
    currency          varchar(3)     not null comment '币种',
    action            varchar(8)     not null comment '记账动作: IN, OUT, FREEZE, UNFREEZE, DEBIT, CREDIT',
    amount            decimal(21, 4) not null comment '金额',
    trans_seq_no      varchar(32)    not null comment '交易流水号',
    trans_inst        varchar(8)     null comment '交易机构',
    opposite_info     varchar(32)    null comment '对手方信息',
    product_code      varchar(8)     not null comment '产品码',
    event_code        varchar(16)    not null comment '事件码',
    biz_product_code  varchar(8)     null comment '业务产品码',
    biz_event_code    varchar(16)    null comment '业务事件码',
    cnl_product_code  varchar(8)     null comment '端产品码',
    cnl_event_code    varchar(16)    null comment '端事件码',
    cnl_no            varchar(8)     null comment '产品码',
    memo              varchar(128)   null comment '备注',
    created_time      bigint         null comment '创建时间（毫秒数）',
    modified_time     bigint         null comment '修改时间（毫秒数）',
    unique key uk_acc_accounting_command_00 (tenant_id, request_unique_id),
    key idx_acc_accounting_command_00 (tenant_id, account_book, xid)
)
    comment 'TCC 分支事务表' charset = utf8mb4;

drop table if exists acc_account_00;
create table acc_account_00
(
    tenant_id      varchar(8)  not null comment '租户ID',
    account_book   varchar(16) not null comment '账本/账户产品码',
    account_no     varchar(32) not null comment '账号',
    account_status varchar(1)  not null comment '账户状态：A-ACTIVE, I-INACTIVE, C-CANCEL',
    limited_status varchar(2)  null comment '限制状态：00-无限制，10-只进不出，01-只出不进，11-不进不出',
    client_no      varchar(16) null comment '客户号',
    created_time   bigint      null comment '创建时间（毫秒数）',
    modified_time  bigint      null comment '修改时间（毫秒数）',
    unique key uk_acc_account_00 (tenant_id, account_book, account_no)
)
    comment '账户表';


drop table if exists acc_account_rel_00;
create table acc_account_rel_00
(
    id                  bigint auto_increment primary key comment '自增物理主键，业务不得使用',
    tenant_id           varchar(8)  not null comment '租户ID',
    account_book        varchar(16) not null comment '账本',
    account_no          varchar(32) not null comment '账号',
    superior_account_no varchar(32) null comment '上级账户',
    linkage_mode        varchar(16) null comment '联动模式：SYNC-同步联动，ASYNC-异步联动',
    created_time        bigint      null comment '创建时间（毫秒数）',
    modified_time       bigint      null comment '修改时间（毫秒数）',
    unique key uk_acc_account_rel_00 (tenant_id, account_book, account_no),
    key idx_acc_account_rel_00 (tenant_id, account_book, superior_account_no)
)
    comment '账户关系表';

drop table if exists acc_balance_0;
create table acc_balance_0
(
    id                   bigint auto_increment primary key comment '自增物理主键，业务不得使用',
    tenant_id            varchar(8)  not null comment '租户ID',
    account_book         varchar(16) not null comment '账本',
    account_no           varchar(32) not null comment '账号',
    balance_type         varchar(8)  not null default 'DEFAULT' comment '余额类型',
    currency             varchar(3)  not null comment '币种',
    balance              bigint               default 0 comment '余额',
    unreached_amount     bigint               default 0 comment '未达金额',
    reserved_amount      bigint               default 0 comment '预留金额',
    frozen_amount        bigint               default 0 comment '冻结金额',
    overdraft_limit      bigint               default 0 comment '可透支额度',
    has_upper_limit      boolean              default false comment '余额是否有上限，例如记录用信额度时，业务上要控制账户余额不超过授信额度。如果无上限限制，可以不记未达金额，以优化记账速度。',
    balance_direction    varchar(1) comment '余额方向，D-debit, C-credit, 如果为空则不可使用借贷记账法',
    last_accounting_time bigint      null comment '最后一次余额变动时间',
    created_time         bigint      null comment '创建时间（毫秒数）',
    modified_time        bigint      null comment '修改时间（毫秒数）',
    unique key uk_acc_balance_0 (tenant_id, account_book, account_no, balance_type)
)
    comment '账户余额表';

drop table if exists acc_freeze_order_00;
create table acc_freeze_order_00
(
    id                     bigint auto_increment primary key comment '自增物理主键，业务不得使用',
    tenant_id              varchar(8)  not null comment '租户ID',
    account_book           varchar(16) not null comment '账本',
    account_no             varchar(32) not null comment '账号',
    balance_type           varchar(8)  not null default 'DEFAULT' comment '余额类型',
    freeze_type            varchar(8)  not null comment '冻结类型',
    freeze_order_no        varchar(32) not null comment '冻结单号',
    currency               varchar(3)  not null comment '币种',
    freeze_amount          bigint               default 0 comment '冻结金额',
    reserved_freeze_amount bigint               default 0 comment '预留冻结金额，即准备解冻的金额',
    created_time           bigint      null comment '创建时间（毫秒数）',
    modified_time          bigint      null comment '修改时间（毫秒数）',
    unique key uk_acc_freeze_order_00 (tenant_id, account_book, account_no, balance_type, freeze_type, freeze_order_no)
)
    comment '账户余额表';



drop table if exists acc_balance_statistics_00;
create table acc_balance_statistics_00
(
    id                bigint auto_increment primary key comment '自增物理主键，业务不得使用',
    tenant_id         varchar(8)  not null comment '租户ID',
    account_book      varchar(16) not null comment '账本',
    account_no        varchar(32) not null comment '账号',
    balance_type      varchar(8)  not null default 'DEFAULT' comment '余额类型',
    statistics_rule   varchar(8)  not null comment '统计规则：D-按日统计, M-按月统计, Y-按年统计, ……',
    statistics_period varchar(8)  not null comment '统计周期，例如按日统计时记录日期，按年统计时记录年份',
    currency          varchar(3)  not null comment '币种',
    inflow_count      bigint               default 0 comment '流入次数',
    inflow_amount     bigint               default 0 comment '流入金额',
    outflow_count     bigint               default 0 comment '流出次数',
    outflow_amount    bigint               default 0 comment '流出金额',
    end_balance       bigint               default 0 comment '期末余额',
    created_time      bigint      null comment '创建时间（毫秒数）',
    modified_time     bigint      null comment '修改时间（毫秒数）',
    unique key uk_acc_balance_statistics_00 (tenant_id, account_book, account_no, balance_type, statistics_rule, statistics_period)
)
    comment '账户余额变动统计表';


drop table if exists acc_accounting_log_00;
create table acc_accounting_log_00
(
    id                    bigint auto_increment primary key comment '自增物理主键，业务不得使用',
    tenant_id             varchar(8)   not null comment '租户ID',
    accounting_log_id     varchar(32)  not null comment '账务流水号，全局唯一',
    account_book          varchar(16)  not null comment '账本',
    account_no            varchar(32)  not null comment '账号',
    balance_type          varchar(8)   not null default 'DEFAULT' comment '余额类型',
    accounting_time       bigint       not null comment '记账时间',
    accounting_Date       bigint       not null comment '会计日',
    currency              varchar(3)   not null comment '币种',
    changed_amount        bigint                default 0 comment '变动金额，正数表示流入，负数表示流出',
    balance               bigint                default 0 comment '变动后余额',
    request_unique_id     varchar(32)  not null comment '记账请求唯一ID，用于业务幂等',
    trans_seq_no          varchar(32)  not null comment '交易流水号',
    trans_inst            varchar(8)   null comment '交易机构',
    opposite_account_info varchar(32)  null comment '对手方账户信息',
    product_code          varchar(8)   not null comment '产品码',
    event_code            varchar(16)  not null comment '事件码',
    biz_product_code      varchar(8)   null comment '业务产品码',
    biz_event_code        varchar(16)  null comment '业务事件码',
    cnl_product_code      varchar(8)   null comment '端产品码',
    cnl_event_code        varchar(16)  null comment '端事件码',
    cnl_no                varchar(8)   null comment '产品码',
    memo                  varchar(128) null comment '备注',
    created_time          bigint       null comment '创建时间（毫秒数）',
    modified_time         bigint       null comment '修改时间（毫秒数）',
    unique key uk_acc_accounting_log_00 (tenant_id, accounting_log_id),
    unique key uk_acc_accounting_log_req_00 (tenant_id, request_unique_id),
    key idx_acc_accounting_log_00 (tenant_id, account_book, account_no, balance_type, accounting_time),
    key idx_acc_accounting_log_trans_seq_no_00 (tenant_id, trans_seq_no)
)
    comment '账务流水表';


drop table if exists acc_freeze_log_00;
create table acc_freeze_log_00
(
    id                  bigint auto_increment primary key comment '自增物理主键，业务不得使用',
    tenant_id           varchar(8)   not null comment '租户ID',
    freeze_log_id       varchar(32)  not null comment '冻结流水号，全局唯一',
    account_book        varchar(16)  not null comment '账本',
    account_no          varchar(32)  not null comment '账号',
    balance_type        varchar(8)   not null default 'DEFAULT' comment '余额类型',
    freeze_type         varchar(8)   not null comment '冻结类型',
    freeze_order_no     varchar(32)  not null comment '冻结单号',
    freeze_time         bigint       not null comment '冻结/解冻时间',
    currency            varchar(3)   not null comment '币种',
    freeze_amount       bigint                default 0 comment '冻结金额，正数表示冻结，负数表示解冻',
    order_frozen_amount bigint                default 0 comment '订单总冻结金额',
    total_frozen_amount bigint                default 0 comment '总冻结金额',
    request_unique_id   varchar(32)  not null comment '记账请求唯一ID，用于业务幂等',
    trans_seq_no        varchar(32)  null comment '交易流水号',
    trans_inst          varchar(8)   null comment '交易机构',
    product_code        varchar(8)   not null comment '产品码',
    event_code          varchar(16)  not null comment '事件码',
    biz_product_code    varchar(8)   null comment '业务产品码',
    biz_event_code      varchar(16)  null comment '业务事件码',
    cnl_product_code    varchar(8)   null comment '端产品码',
    cnl_event_code      varchar(16)  null comment '端事件码',
    cnl_no              varchar(8)   null comment '产品码',
    memo                varchar(128) null comment '备注',
    created_time        bigint       null comment '创建时间（毫秒数）',
    modified_time       bigint       null comment '修改时间（毫秒数）',
    unique key uk_acc_freeze_log_00 (tenant_id, freeze_log_id),
    unique key uk_acc_freeze_log_req_00 (tenant_id, request_unique_id),
    key idx_acc_freeze_log_00 (tenant_id, account_book, account_no, balance_type, freeze_type, freeze_order_no, freeze_time),
    key idx_acc_freeze_log_trans_seq_no_00 (tenant_id, trans_seq_no)
)
    comment '冻结流水表';