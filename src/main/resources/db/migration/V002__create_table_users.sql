create table users (
    id uuid not null,
    github varchar(255),
    linked_in varchar(255),
    name varchar(255),
    address_id uuid,
    primary key (id)
);

alter table users add constraint fk_users_addresses foreign key (address_id) references addresses;
