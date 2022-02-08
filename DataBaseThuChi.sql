create database Assignment
use assignment
create table thu( IDThu int primary key,
ngay date,
soTT bigint, GhiChu nvarchar(200),
DanhMuc nvarchar(150))
create table chi(IDChi int primary key,
ngay date,SoTC bigint, GhiChu nvarchar(200),
DanhMuc nvarchar(150), 
IDThu int foreign key references thu(IDThu))
