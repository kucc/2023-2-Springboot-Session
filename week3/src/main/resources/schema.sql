create table Member (
                        userId int not null auto_increment unique,
                        username varchar(20) not null,
                        usertype varchar(20) not null
);