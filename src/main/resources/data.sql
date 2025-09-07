insert into users(date_of_birth, id, full_name )
values
       (current_date(),1, 'Jon depp'),
       (current_date(),2, 'Brad pitt');

insert into orders(order_Id, user_Id, order_Name)
values (1, 1, 'Macbook Pro'),
        (2, 1, 'Iphone 14'),
        (3, 2, 'Rich dad poor dad'),
        (4, 2, 'psychology of money');