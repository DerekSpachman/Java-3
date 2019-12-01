/* 
 * 
 *
 * Author:  Derek Spachman
 * Created: Sep 30, 2019
 */

create table user (
    uid int auto_increment primary key,
    aid int not null,
    first_name varchar(15) not null,
    last_name varchar(15) not null,
    email varchar(40) not null,
    username varchar(15) not null,
    password varchar(15),
    foreign key(aid)
        references account(aid)
);


create table account (
    aid int auto_increment primary key,
    uid int not null,
    savings double null,
    checking double null,
    money_market double null,
    savings_transactions varchar(50) null,
    checking_transactions varchar(50) null,
    money_market_transactions varchar(50) null,
    foreign key(uid)
        references user(uid)
);