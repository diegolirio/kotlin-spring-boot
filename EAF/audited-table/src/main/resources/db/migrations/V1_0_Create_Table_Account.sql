CREATE TABLE account
(
    "id"         uuid PRIMARY KEY         NOT NULL,
    "name"       varchar(200)             NOT NULL,
    "company"    varchar(200)             NOT NULL,
    "groups"     varchar(1000)            NOT NULL,
    "email"      varchar(100)             NOT NULL,
    "email_sent" BOOLEAN                  NOT NULL,
    "phone"      varchar(100)             NOT NULL,
    "status"     varchar(10)              NOT NULL,
    "created_at" timestamp with time zone NOT NULL DEFAULT NOW(),
    "updated_at" timestamp with time zone
);

CREATE TABLE account_audit
(
    "id"             uuid PRIMARY KEY         NOT NULL,
    "employee_email" varchar(100)             NOT NULL,
    "account_id"     uuid                     NOT NULL,
    "name"           varchar(200)             NOT NULL,
    "company"        varchar(200)             NOT NULL,
    "groups"         varchar(1000)            NOT NULL,
    "email"          varchar(100)             NOT NULL,
    "email_sent"     BOOLEAN                  NOT NULL,
    "phone"          varchar(100)             NOT NULL,
    "status"         varchar(10)              NOT NULL,
    "created_at"     timestamp with time zone NOT NULL DEFAULT NOW(),
    "updated_at"     timestamp with time zone
);