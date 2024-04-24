create EXTENSION citext;

create DOMAIN email_type AS citext
CHECK ( value ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' );

create DOMAIN text_login AS citext
CHECK (LENGTH(value) >= 6 AND LENGTH(value) <= 20 AND value !~ '\s' AND value ~* '^[A-Z]*$');

create DOMAIN text_name AS citext
CHECK (LENGTH(value) <= 20 AND value !~ '\s' AND value ~* '^[А-ЯA-Z]*$');

-- CREATE TABLE IF NOT EXISTS email (
-- 	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
-- 	email_name email_type NOT NULL UNIQUE,
-- 	applyLink varchar
-- );

create TABLE IF NOT EXISTS users (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	first_name text_name,
	last_name text_name,
	email email_type NOT NULL UNIQUE,
-- 	email integer REFERENCES email (id) NOT NULL,
	username text_login UNIQUE NOT NULL,
	user_password varchar NOT NULL,
	user_role varchar NOT NULL
-- 	created_at timestamp NOT NULL,
-- 	updated_at timestamp NOT NULL,
-- 	archive_at timestamp
);

create TABLE IF NOT EXISTS company (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL,
	number_inn integer UNIQUE, 
	number_kpp integer, 
	business_address varchar, 
	full_name varchar, 
	short_name varchar,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS company_source_link (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	source_link varchar NOT NULL,
	company integer REFERENCES company (id) NOT NULL
);

create TABLE IF NOT EXISTS region (
	id integer PRIMARY KEY,
	title varchar NOT NULL
);

create TABLE IF NOT EXISTS country (
	id integer PRIMARY KEY,
	title varchar NOT NULL
);

create TABLE IF NOT EXISTS trade_card (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL CHECK (title !~ '\s'),
	generated_description varchar,
	terms_contract varchar, 	
	
	start_price double precision,
	publication_datetime timestamp NOT NULL, 
	finish_datetime timestamp NOT NULL,
	last_update_datetime timestamp NOT NULL,
	currency_type varchar, 
	source_link varchar NOT NULL,
	region integer REFERENCES region (id) NOT NULL,
	country integer REFERENCES country (id) NOT NULL, 
	trade_status varchar NOT NULL,
	trade_type varchar NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS documents (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL,
	source_description varchar,
	generated_description varchar,
	source_link varchar NOT NULL,
	trade_card integer REFERENCES trade_card (id)
);

create TABLE IF NOT EXISTS purchase_object (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL,
	description varchar
);

create TABLE IF NOT EXISTS trade_card_purchase_object (
	trade_card integer REFERENCES trade_card (id),
	purchase_object integer REFERENCES purchase_object (id), 
	PRIMARY KEY(trade_card, purchase_object),
	count_of real NOT NULL, 
	measure_unit varchar NOT NULL, 
	delivery_address varchar
);

create TABLE IF NOT EXISTS trade_card_company (
	trade_card integer REFERENCES trade_card (id),
	company integer REFERENCES company (id), 
	PRIMARY KEY(trade_card, company),
	company_role varchar NOT NULL
);

create TABLE IF NOT EXISTS task (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL CHECK (title !~ '\s'),
	description varchar,
	status varchar NOT NULL,
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS task_users (
	task integer REFERENCES task (id), 
	user_obj integer REFERENCES users (id),
	PRIMARY KEY(task, user_obj),
	access_level varchar NOT NULL,
	task_relation varchar NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS team (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL,
	description varchar,
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS team_users (
	team integer REFERENCES team (id), 
	user_obj integer REFERENCES users (id),
	PRIMARY KEY(team, user_obj),
	default_access_level varchar NOT NULL,
	hr_access varchar NOT NULL,
	team_role varchar NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS invite (
	team integer REFERENCES team (id),
	user_obj integer REFERENCES users (id),
	invite_message varchar(500),
	PRIMARY KEY(team, user_obj),
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp	
);

create TABLE IF NOT EXISTS collection (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	shareLink varchar UNIQUE,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS collection_task (
	collection integer REFERENCES collection (id), 
	task integer REFERENCES task (id),
	PRIMARY KEY(collection, task),
	title varchar,
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS trade_card_collection (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	trade_card integer REFERENCES trade_card (id) NOT NULL, 
	collection integer REFERENCES collection (id) NOT NULL,
	UNIQUE(trade_card, collection),
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS sorting_field (
	id integer PRIMARY KEY,
	title varchar NOT NULL
);

create TABLE IF NOT EXISTS filters (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	trade_type varchar,
	sorting_field integer REFERENCES sorting_field (id),
	sorting_direction varchar,
	start_price_from double precision,
	start_price_up_to double precision,
	publication_date_from date,
	publication_date_up_to date,
	finish_date_from date,
	finish_date_up_to date
);

create TABLE IF NOT EXISTS thread (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL,
	task integer REFERENCES task (id) NOT NULL, 
	shareLink varchar UNIQUE,
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
	
);

create TABLE IF NOT EXISTS message_query (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
-- 	send_by integer REFERENCES users (id) NOT NULL,
	user_query varchar NOT NULL,	
	filters integer REFERENCES filters (id),
	thread integer REFERENCES thread (id) NOT NULL,
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS message_query_collection (
	message_query integer REFERENCES message_query (id),
	collection integer REFERENCES collection (id),
	PRIMARY KEY (message_query, collection)
);

create TABLE IF NOT EXISTS message_answer (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	message_query integer REFERENCES message_query (id) NOT NULL,
	answer_description varchar,
	thread integer REFERENCES thread (id) NOT NULL,
	created_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS message_answer_collection (
	message_answer integer REFERENCES message_answer (id),
	collection integer REFERENCES collection (id),
	PRIMARY KEY (message_answer, collection)
);

create TABLE IF NOT EXISTS commentary (
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	description varchar(2000) NOT NULL,
	created_by integer REFERENCES users (id) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	archive_at timestamp
);

create TABLE IF NOT EXISTS trade_card_collection_commentary (
	trade_card_collection integer REFERENCES trade_card_collection (id), 
	commentary integer REFERENCES commentary (id),
	PRIMARY KEY(trade_card_collection, commentary)	
);