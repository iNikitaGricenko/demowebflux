create table public.user_entity
(
    id            bigint default nextval('user_id_seq'::regclass) not null
        constraint user_pkey
            primary key,
    deleted       boolean,
    deleted_at    timestamp(6),
    email         varchar(255)
        constraint uk_ob8kqyqqgmefl0aco34akdtpe
            unique,
    first_name    varchar(255),
    last_name     varchar(255),
    online_at     timestamp(6),
    password      varchar(255),
    registered_at date,
    role          varchar(255)
        constraint user_role_check
            check ((role)::text = ANY
                   ((ARRAY ['ADMIN'::character varying, 'USER'::character varying, 'MANAGER'::character varying])::text[]))
);

alter table public.user_entity
    owner to root;