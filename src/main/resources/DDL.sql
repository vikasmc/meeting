create table user_detail(
user_id serial PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR(355) NOT NULL,
created_on TIMESTAMP NOT NULL,
last_login TIMESTAMP
);


create table role_list(
role_id serial PRIMARY KEY,
role_name VARCHAR(300) UNIQUE NOT NULL
);


create table room_list(
room_id serial PRIMARY KEY,
room_name VARCHAR(200) UNIQUE NOT NULL,
room_location VARCHAR(200) NOT NULL,
allocation_size INTEGER NOT NULL
);

create table user_roles(
user_role_id serial PRIMARY KEY,
role_id INTEGER NOT NULL,
user_id INTEGER NOT NULL,
FOREIGN KEY(role_id) REFERENCES role_list(role_id),
FOREIGN KEY(user_id) REFERENCES user_detail(user_id)
);

create table scheduler(
scheduler_id serial PRIMARY KEY,
room_id INTEGER NOT NULL,
user_Id INTEGER NOT NULL,
start_time TIMESTAMP NOT NULL,
end_time TIMESTAMP NOT NULL,
topic_name VARCHAR(100) NOT NULL,
topic_description VARCHAR(500) NOT NULL,
FOREIGN KEY(room_id) REFERENCES room_list(room_id),
FOREIGN KEY(user_id) REFERENCES user_detail(user_id)
);

create table enrollment(
scheduler_id INTEGER NOT NULL,
user_Id INTEGER NOT NULL,
FOREIGN KEY(scheduler_id) REFERENCES scheduler(scheduler_id),
FOREIGN KEY(user_id) REFERENCES user_detail(user_id)
);


CREATE SEQUENCE public.usersequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.usersequence
OWNER TO postgres;