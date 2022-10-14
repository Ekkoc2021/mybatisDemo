
# mybatisDemo
建表语句

```mysql
#建表语句-------------
 create table user(id char(10) primary key , username varchar(32), email varchar(32),password varchar(32));
 create table appetite(food_id char(10),user_id char(10));
 create table foodList (id char(10) primary key,name varchar(32),canteen varchar(32),floor varchar(32));

# test data-------------
 insert into user value
 ("1111111111","ekko","189890049@qq.com","123456"),
 ("1111111112","tom","123456789@qq.com","abcdefg"),
 ("1111111113","ekko","987654321@qq.com","abc12344");
 insert into appetite value
 ("1111111111","0000000001"),
 ("1111111112","0000000002");
 insert into foodList values
 ("0000000001","孜然肉片","二食堂","一楼"),
 ("0000000002","辣椒炒肉","一食堂","一楼");
 
select * from foodList; 
select * from appetite;
select * from user;
select * from user where id="1111111111";
```

