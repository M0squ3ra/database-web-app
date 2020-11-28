-- need to create these tables because spring boot doesn't have default schema for postgresql

CREATE TABLE users(
   username varchar(50) NOT NULL,
   password varchar(70) NOT NULL,
   enabled boolean NOT NULL DEFAULT FALSE,
   primary key(username)
);

create table authorities (
--   user_role_id SERIAL PRIMARY KEY,
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  UNIQUE (username,authority),
  FOREIGN KEY (username) REFERENCES users (username)
);