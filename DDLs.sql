use kogi19;

-- CREATING TABLES
create table admin (
	username varchar (100) primary key,
	pass varchar(100) not null,
	usertype varchar(1) not null
);
create table individual (
	person_id varchar (7) primary key,
	pname varchar (255) not null,
	gender varchar (1) not null,
	birthdate date not null,
	address varchar (255) not null,
	contact varchar (11) unique
);
create table location (
	location_id int primary key auto_increment,
	location_name varchar (255) not null,
	location_address varchar (255) not null,
    si_person_id varchar (7),
    foreign key (si_person_id) references source_individual (si_person_id)
);
create table clinic (
	clinic_id int primary key auto_increment,
	name varchar(255) not null,
    address varchar(255) not null
);
create table results (
    person_id  varchar (7) primary key,
	clinic_id int not null,
	result varchar(1) not null, /* p-positive; n-negative */
	testing_date date not null,
	foreign key (person_id) references individual (person_id),
    foreign key (clinic_id) references clinic (clinic_id)
);
create table source_individual ( 
    si_person_id varchar (7) primary key,
	p_condition varchar(1) not null, /* a-asymptomatic; s-symptomatic*/
	clinic_id int,
    foreign key (si_person_id) references individual (person_id),
	foreign key (clinic_id) references clinic (clinic_id)
);
create table exposed_individual (
	ei_person_id varchar (7) primary key,
	si_person_id varchar (7),
	location_id int,
	exposure_date date,
    foreign key (ei_person_id) references individual (person_id),
	foreign key (si_person_id) references source_individual (si_person_id),
    foreign key (location_id) references location (location_id)
);

-- GENERATING THE LIST OF EXPOSED INDIVIDUALS BY SOURCE PERSON

select a.si_person_id as source, c.pname, 
a.ei_person_id as exposed, b.pname,
YEAR(CURDATE()) - YEAR(b.birthdate) AS age,
b.contact as phone,
a.exposure_date,
d.location_name as location
from exposed_individual a, individual b, individual c, location d
where b.person_id = a.ei_person_id and
a.si_person_id = c.person_id and
a.location_id = d.location_id
order by a.si_person_id
;

/*ADDING INITIAL ADMINS*/
-- insert into admin values ('superuser',md5('superuser'),'s');
-- insert into admin values ('adminKoji',md5('adminKoji'),'r');

select * from admin where pass = md5('adminKoji');
SELECT usertype FROM ADMIN WHERE username = 'adminKoji' and pass = md5('adminKoji');