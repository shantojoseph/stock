DROP TABLE USERS;
DROP TABLE subscription_model;
DROP TABLE stock_limit_model;
DROP TABLE call_limit_model;
CREATE TABLE IF NOT EXISTS users
  (
     id                    NUMBER,
     NAME                  VARCHAR,
     subscription_model_id NUMBER,
     PRIMARY KEY(id)
  );

CREATE TABLE IF NOT EXISTS  subscription_model
  (
     id                   NUMBER,
     NAME                 VARCHAR,
     stock_limit_model_id NUMBER,
     call_limit_model_id  NUMBER,
     PRIMARY KEY(id)
  );

CREATE TABLE  IF NOT EXISTS  stock_limit_model
  (
     id            NUMBER,
     max_stock     NUMBER,
     unit_model_id NUMBER,
     multiplier    NUMBER,
     PRIMARY KEY(id)
  );

CREATE TABLE IF NOT EXISTS  call_limit_model
  (
     id            NUMBER,
     max_calls     NUMBER,
     unit_model_id NUMBER,
     multiplier    NUMBER,
     PRIMARY KEY(id)
  );

CREATE TABLE  IF NOT EXISTS  unit_model
  (
     id   NUMBER,
     unit VARCHAR,
     PRIMARY KEY(id)
  );

CREATE TABLE IF NOT EXISTS  user_activity
  (
     id            NUMBER,
     userid        NUMBER,
     stock_symbol  VARCHAR,
     activity_date DATE
  );

