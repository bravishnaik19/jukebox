create database jukebox;
use jukebox;
create table song(songid int auto_increment primary key,
songname varchar(50),
albumname varchar(50) not null,
genres varchar(50) not null,
artist varchar(50) not null,
url varchar(200) not null,
songdur time not null);

create table prodcast(prodcastid int auto_increment primary key,
prodcastname  varchar(50) not null,
artist varchar(50) not null,
Prodcastdate date not null); 

create table user1(userid int auto_increment primary key,
username varchar(50 ) not null,
pass varchar(20) not null);

create table audio(audioid int auto_increment primary key,
actionper varchar(50),
songid int references song(songid),
prodcastid int references prodcast(prodcastid));

create table playlist(playlistid int auto_increment primary key,
audioid int references audio(audioid),
userid int references user1(userid));


 select * from prodcAST;
 insert into song values(1,"Frinds","frds","sad","Ross","htttps/frinds.mp3",'00:01:2');
 insert into song values(2,"ye duriyan","yariya","sad","Arjit","htttps/yarinya .mp3",'00:02:2');
 insert into song(songname,albumname,genres,artist,url,songdur) values("kehndi hu menu","ap","punjabi","APdhillon","https://apsongs.mp3",'00:3:4');

insert into user1 values(1,"bravish","king@123");
insert into audio value(1,"adding song",1,1);


select * from Playlist;	
insert into Prodcast values(1,"Action","AK",'2022-04-23');
insert into Prodcast values(2,"winner","srk",'2022-04-01');

insert into audio(audioid,actionper,songid) values(1,"adding song",1);
insert into audio(actionper,songid) values("adding song",2);
insert into audio(actionper,prodcastid) values("Adding procast",1);
insert into audio(actionper,songid,prodcastid) values("Adding song/podcast",3,2);

update song set url="D:\\NIIT\\file2.wav" where songid=2;



select audioid from audio inner join song on song.songid= audio.songid where song.songname="Frinds";

select * from song;



update song set url="D:\\NIIT\\file_example_WAV_2MG.wav" where songid=1;
insert into Playlist(audioid,userid) values (2,2);

select song.songid,song.songname,song.albumname,song.genres,song.artist,song.url from song inner join audio inner join playlist on song.songid=audio.songid and audio.audioid=playlist.audioid where userid=2;