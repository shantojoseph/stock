
delete unit_model;
insert into  unit_model values(1,'second');
insert into  unit_model values(2,'minute');
insert into  unit_model values(3,'hour');
insert into  unit_model values(4,'day');
insert into  unit_model values(5,'month');
insert into  unit_model values(0,'unlimited');

delete call_limit_model;
insert into call_limit_model values(1,6,2,1);
insert into call_limit_model values(2,1,1,1);
insert into call_limit_model values(3,1000,5,1);

delete stock_limit_model;
insert into stock_limit_model values( 1,99999999999999,0,1);
insert into stock_limit_model values( 2,100,5,1);
insert into stock_limit_model values( 3,10,5,1);

delete subscription_model;
insert into subscription_model values(1,'GOLD',1,1);

insert into subscription_model values(2,'SILVER',2,2);

insert into subscription_model values(3,'DEMO',3,3);
