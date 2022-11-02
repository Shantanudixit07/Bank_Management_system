select database() BankManagementSystem;
show databases;
use BankManagementSystem;
create table signup1(formNo varchar(20), name varchar(20), fName  varchar(20), Dob  varchar(20), gender  varchar(20), email  varchar(40), marital_status  varchar(20), address  varchar(40),city  varchar(20),pin  varchar(20), state  varchar(20));
show tables;
create table signin(formno varchar(20),cardNo varchar(30),pin varchar(20));
select * from signin;
select * from signup1;
create table signUp2(formNo varchar(20), Religion  varchar(20), Category  varchar(20), Income  varchar(20), educationalQualification  varchar(20),Occupation  varchar(20), aadhar  varchar(20),pan  varchar(20), seniorcitizen  varchar(20),existingAccount  varchar(20));
select * from signup2;
create table signup3(formNo varchar(20),accountType  varchar(20), CardNo  varchar(20),PIN  varchar(20),Facility varchar(20) );
select * from signup3;
create table bank(pin varchar(20),date varchar(50),type varchar(20),amount varchar(20));
drop table bank;
select * from bank;


