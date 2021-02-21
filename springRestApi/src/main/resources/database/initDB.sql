create table if not exists account
(
    id bigint auto_increment
        primary key,
    account_data varchar(255) null,
    account_status varchar(10) null
);

create table if not exists file
(
    id bigint auto_increment
        primary key,
    name_file varchar(255) null,
    uri_file varchar(255) null,
    file_status varchar(10) null
);

create table if not exists event
(
    id bigint auto_increment
        primary key,
    name_event varchar(100) null,
    file_id bigint null,
    constraint event_file_id_fk
        foreign key (file_id) references file (id)
);

create table if not exists user
(
    id bigint auto_increment
        primary key,
    first_name varchar(100) null,
    last_name varchar(100) null,
    account_id bigint null,
    constraint FKc3b4xfbq6rbkkrddsdum8t5f0
        foreign key (account_id) references account (id)
);

create table if not exists user_event_list
(
    user_id bigint not null,
    event_list_id bigint not null
)
    engine=MyISAM;

create index FKcokyscks6fuyx4uk40ffbhffr
    on user_event_list (user_id);

create index FKlavkdri1ql5f88g6d9ry7y1i
    on user_event_list (event_list_id);

create table if not exists user_file_list
(
    user_id bigint not null,
    file_list_id bigint not null
)
    engine=MyISAM;

create index FK74c7t0vun8nw1nilii2op6ibx
    on user_file_list (file_list_id);

create index FKklk12reigttb6ol5ficp993lm
    on user_file_list (user_id);

