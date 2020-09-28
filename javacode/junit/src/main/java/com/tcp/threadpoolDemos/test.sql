        CREATE TABLE'city'(
        'city_id' int(11)NOT NULL AUTO_INCREMENT,
        'city _name' varchar(50)NOT NULL,
        'country_id' int(11)NOT NULL,
        PRIMARY KEY('city_id'),
        )ENGINE=InnoDB DEFAULT CHARSET=utf8;


        CREATE TABLE 'country'(
        'country_id' int(11)NOT NULL AUTO_INCREMENT,
        'country_name' varchar(100)NOT NULL,
        PRIMARY KEY('country_id'),
        )ENGINE=InnoDB DEFAULT CHARSET=utf8;

        insert into'city'('city_id','city_ name','country_id')values(1,'西安',1);
        insert into'city'('city_id','city_ name','country_id')values(2,'NewYork',2);
        insert into'city'('city_id','city_ name','country_id')values(3,'北京',1);
        insert into'city'('city_id','city_ name','country_id')values(4,'上海';1);
        insert into'country'('country_id','country_name')values(1,'China');
        insert into'country'('country_id','country_name')values(2,'America');
        insert into'country'('country_id','country_name')values(3,'Japan');
        insert into'country'('country_id','country_name')values(4,'UK');
