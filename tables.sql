create table ers_reimb (
  reimb_id serial primary key,
  reimb_amt real not null,
  reimb_submitted timestamp,
  reimb_resolved timestamp,
  reimb_description varchar(250) not null,
  reimb_receipt varchar(50),
  reimb_author integer not null references ers_usrs(ers_usrs_id),
  reimb_resolver integer references ers_usrs(ers_usrs_id),
  reimb_stat_id integer references ers_reimb_stat,
  reimb_type_id integer references ers_reimb_type
);

create table ers_reimb_type (
  reimb_type_id serial primary key,
  reimb_type varchar(10) unique not null
);

create table ers_reimb_stat (
  reimb_stat_id serial primary key,
  reimb_stat varchar(10) unique not null
);

create table ers_usrs (
	ers_usrs_id serial primary key,
	ers_usrnm varchar(50) unique not null,
	ers_pswd varchar (50) not null,
	usr_fst_nm varchar(100) not null,
	usr_lst_nm varchar(100) not null,
	usr_eml varchar(150) unique not null,
	usr_role_id integer references ers_usr_roles
);

create table ers_usr_roles (
  ers_usr_role_id serial primary key,
  usr_role varchar(10) unique not null 
);

