create table addresses (
    id uuid not null,
    city varchar(255),
    public_place varchar(255),
    state varchar(255),
    zip_code varchar(255),
    primary key (id)
);
