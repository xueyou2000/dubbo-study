DELETE FROM account;

INSERT INTO account (account_id, version, create_time, update_time, account_type, account_status, balance, transit_bal, freeze_bal, user_id, user_type)
    VALUES (00000001, 0, '2019-12-30 17:59:17.347000', '2019-12-30 17:59:17.347000', 'CASH', 'NORMAL', 0, 0, 0, 00000001, 'CUSTOMER');