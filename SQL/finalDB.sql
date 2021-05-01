create database finalDB;
use finalDB;

/*user_info table
role: 0 for customer; 1 for admin*/
create table user_info
(userID integer primary key auto_increment,
 uname varchar(80) not null,
 password varchar(225) not null,
 email varchar(225) not null,
 phone varchar(225) ,
 birthday varchar(20) ,
 sex varchar(32) ,
 roleID int not null,
 createTime timestamp not null default current_timestamp,
 updateTime timestamp not null default current_timestamp
 );
 
 
 
 drop table user_info;
 
 select * from user_info;
 
 alter table user_info
 modify column updateTime timestamp not null on update current_timestamp comment 'last update';
 
 update user_info set sex = 'Male' where userID = 11;
 update user_info set updateTime= current_timestamp() where userID =11;

 insert into user_info(uname,password,email,phone,birthday,sex,roleID)
 values('Djin','Djin123','jin.do@northeastern.edu','6178882020','1998-12-07','Female',0);
 
insert into user_info(uname,password,email,phone,birthday,sex,roleID)
 values('root','root123','jindou0826@outlook.com','6178889999','1998-12-07','Female',1);

update user_info 
set updateTime = '2021-03-31 19:54:00' where userID = 1;

/*ticket_info table
tFlag varchar(30): availability
categoryID 1: Activities & Games
		   2: art & culture
           3: at home
           4: trips
*/
create table ticket_info(
ticketID integer primary key auto_increment,
ticketName varchar(80) not null,
price double not null,
tIntroduce varchar(225),
tFlag varchar(30), 
sellingDate date not null,
collect integer,
categoryID integer not null,
timage varchar(225) 
);

drop table ticket_info;

select * from ticket_info;

select * from ticket_info where categoryID = '2';
update ticket_info set tFlag = 'false' where ticketID = 14;

update ticket_info set collect = collect+1 where ticketID = 1;

insert into ticket_info(ticketID,ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values(1,'Candlelight: Chopins Best Works', 20.00, 'An intimate ambience in a beautiful venue bathed in candlelight','true','2021-04-01',100,1,'images/candlelight.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Van Gogh:The Immersive Experience', 16.20, 'Van Gogh: The Immersive Experience is a 360º digital art exhibition in Boston that invites you to step into the universe of the Dutch genius, Vincent van Gogh.','true','2021-03-25',1000,2,'images/vanG.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Dining in The Dark in Boston', 90.00, 'Surprise your senses and test out your taste buds. Just choose your favourite colour, and we will take care of the rest.','true','2021-02-25',500,1,'images/dating.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Nailed it! At Home Experience - Double', 54.00, 'Featuring a recipe inspired by the new season of the hit Netflix baking show - Nailed It! Double Trouble!','true','2021-04-01',200,3,'images/Nailed.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Downloadable Clue Game', 30.00, 'Downloadable Clue Game: Anniversary of the Fischers Wedding','true','2021-04-01',1000,3,'images/clue.jpg');

insert into ticket_info(ticketID,ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values(6,'Crown & Prophet', 30.00, 'Virtual Epic Fantasy Tour of the MET','true','2021-03-01',10,2,'images/clue.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Adult Bingo!', 6.00, ' Streaming Party & Complimentary. Enjoy forbidden and naughty online bingo','true','2021-03-25',2000,3,'images/bingo.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('The Wonder Cave: A Virtual Escape Room', 7.50, 'Think you are better than a common thief?','true','2021-03-05',2000,3,'images/wonder.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Pride and Prejudice', 19.99, 'A New Jane Austen Musical','true','2021-02-25',1500,3,'images/pride.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Isabella Stewart Gardner Museum', 15.00, 'Isabella was drawn to the intellectual life of Boston and Cambridge.','true','2021-02-25',5000,2,'images/isabella.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Museum of Fine Art', 30.00, 'The MFA is one of the most comprehensive art museums in the world.','true','2021-02-25',5000,2,'images/mfa.jpg');

insert into ticket_info(ticketName, price, tIntroduce, tFlag, sellingDate, collect, categoryID, timage)
values('Sightseeing Day Sail around Boston Harbor',51.50,'You will sail past the seaport district, Castle Island, Fort Independence, Spectacle Island, and Long Island Head Light.','false','2021-05-01',0,4,'images/sail.jpg');

update ticket_info set ticketName = 'Sightseeing Day Sail around Boston' where ticketID = 12;
/*restaurant_info table
rCategory: 1 for asian, 2 for american, 3 for Italian, 4 for Brazilian, 5 for French*/
create table restaurant_info(
restaurantID integer primary key auto_increment,
restaurantName varchar(80) not null,
average_price varchar(20) not null,
rIntroduce varchar(225),
rCategory integer not null, 
collect integer,
contact varchar(225),
address varchar(225),
timage varchar(225) 
);

drop table restaurant_info;

select * from restaurant_info;

insert into restaurant_info(restaurantName, average_price, rIntroduce, rCategory, collect, contact, address, timage)
values('La Voile', 100, 'La Voile, “the sail” in French, is an authentic French brasserie and an import from the South of France.',5,299,'617-587-4200','261 Newbury St','images/voile.jpg');

insert into restaurant_info(restaurantName, average_price, rIntroduce, rCategory, collect, contact, address, timage)
values('Fogo De Chao', 50, 'Brazilian Steakhouse',4,500,'617-585-6300','200 Dartmouth St, Boston, MA 02116','images/fogo1.jpeg');

insert into restaurant_info(restaurantName, average_price, rIntroduce, rCategory, collect, contact, address, timage)
values('Bacco Ristorante & Bar', 69, 'Homemade pastas & floor-to-ceiling windows are highlights at this romantic Italian restaurant.',3,450,'617-624-0454','107 Salem St, Boston, MA 02113','images/bacco.jpg');

insert into restaurant_info(restaurantName, average_price, rIntroduce, rCategory, collect, contact, address, timage)
values('Bambara Cambridge', 80, 'Sophisticated Hotel Marlowe eatery for creative American cuisine & craft cocktails in stylish digs.',2,299,'617-868-4444','25 Edwin H Land Blvd, Cambridge, MA 02141','images/bambara.png');

insert into restaurant_info(restaurantName, average_price, rIntroduce, rCategory, collect, contact, address, timage)
values('Pho Basil', 20, 'A bright, minimalistic eatery with a mix of Thai & Vietnamese dishes, spiced to order.',1,1332,'617-262-5377','177 Massachusetts Ave, Boston, MA 02115','images/basil.jpg');

/*order table
*category: 2 for ticket; 1 for restaurant */
create table order_info(
orderID integer primary key auto_increment,
itemID integer not null,
userID integer not null,
category integer not null, 
selectedDate varchar(80) not null,
selectedTime varchar(80) not null,
itemAmount integer,
party integer,
totalPrice double,
contact varchar(80),
orderStatus varchar(30) not null,
orderDate timestamp not null default current_timestamp,
modifyDate timestamp not null default current_timestamp);

select * from order_info;

alter table order_info
modify column modifyDate timestamp not null on update current_timestamp comment 'last update';

alter table order_info
modify column userID integer default null;

alter table order_info
add constraint fk_orderInfo_userID foreign key (userID) references user_info(userID);

alter table order_info
drop constraint FKq1pyd73pnc4pixpggyecjqs1o;
 
update order_info set orderStatus ="pending" where orderID =1;
update order_info set modifyDate =current_timestamp() where orderID =1;
drop table order_info;

drop table favorite_info;

create table favorite_info(
productID integer primary key auto_increment,
restaurantID integer,
ticketID integer,
userID integer,
collectedDate date not null);



select * from favorite_info
where userID = 1;

delete from favorite_info
where productID = 7;

insert into favorite_info(productID,restaurantID,userID,collectedDate)
values(1,1,1,'04-06-2021');

select * from 
(select favorite_info.productID, favorite_info.ticketID, ticket_info.ticketName, ticket_info.price, ticket_info.sellingDate,ticket_info.collect from favorite_info
inner join ticket_info on favorite_info.ticketID = ticket_info.ticketID ) as temp_table;

SELECT *
FROM  ticket_info t
inner JOIN favorite_info f
ON (f.ticketID = t.ticketID AND (t.ticketName like '%Van%' and t.price > 0 and t.price < 999) )
group by f.ProductID;

select * from favorite_info order by price desc;

SELECT * FROM favorite_info f inner JOIN  ticket_info t on t.ticketID = f.ticketID group by f.productID order by t.collect desc ;

SELECT * FROM favorite_info f inner JOIN ticket_info t on t.ticketID = f.ticketID and f.userID =4 group by f.productID order by t.price;
SELECT * FROM favorite_info f inner JOIN restaurant_info t on t. restaurantID = f. restaurantID and f.userID =4 group by f.productID order by t.average_price
