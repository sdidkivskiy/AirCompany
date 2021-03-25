insert into aircompany.country (id, name)
values  (3, 'France'),
        (1, 'Germany'),
        (5, 'Spain'),
        (4, 'UK'),
        (2, 'Ukraine');

insert into aircompany.air_company (id, founded_at, name, type)
values  (1, '2016-01-13', 'AirCompany1', 'UNIVERSE'),
        (2, '2016-01-13', 'AirCompany2', 'UNIVERSE'),
        (3, '2016-01-13', 'AirCompany3', 'UNIVERSE'),
        (4, '2017-02-20', 'AirCompany4', 'UNIVERSE'),
        (5, '2020-05-07', 'AirCompany5', 'UNIVERSE');

insert into aircompany.airplane (id, created_at, flight_distance, fuel_capacity, name, number_of_flights, serial_number, type, air_company_id)
values  (1, '2020-01-20', 0, 1111, 'Airplane1', 0, 'Airplane1', 'PASSENGER', 1),
        (2, '2015-05-20', 0, 1000, 'Airplane2', 0, 'Airplane2', 'PASSENGER', 1),
        (3, '2017-06-21', 0, 1200, 'Airplane3', 0, 'Airplane3', 'PASSENGER', 1),
        (4, '2018-08-15', 0, 1150, 'Airplane4', 0, 'Airplane4', 'PASSENGER', 1),
        (5, '2019-08-21', 6750, 1500, 'Airplane5', 10, 'Airplane5', 'CARGO', 2),
        (6, '2019-08-21', 5150, 1300, 'Airplane6', 6, 'Airplane6', 'CARGO', 3),
        (7, '2019-08-21', 7173, 1300, 'Airplane7', 11, 'Airplane7', 'CARGO', 4),
        (8, '2019-08-21', 7173, 1300, 'Airplane8', 15, 'Airplane8', 'PASSENGER', 1),
        (9, '2019-01-21', 15431, 1500, 'Airplane9', 21, 'Airplane9', 'PASSENGER', 1);

insert into aircompany.flight (id, created_at, delay_started_at, distance, ended_at, estimated_time, started_at, status, air_company_id, airplane_id, departure_country_id, destination_country_id)
values  (1, '2021-03-17 16:44:34.396000', null, 3000, null, '40:00:00', '2021-03-16 09:00:00', 'ACTIVE', 1, 1, 4, 2),
        (2, '2021-03-17 17:39:24.345000', null, 2500, null, '36:00:00', '2021-03-16 09:00:00', 'ACTIVE', 2, 2, 4, 2),
        (3, '2021-03-17 19:01:14.340000', null, 2500, null, '36:00:00', null, 'PENDING', 1, 3, 1, 2),
        (4, '2021-03-17 21:13:45.681000', null, 5000, '2021-03-18 22:14:32.932000', '25:00:00', '2021-03-17 21:14:32.932000', 'COMPLETED', 1, 4, 4, 2);