
INSERT INTO users (id, email, password, first_name, last_name, image_url, is_active )
VALUES (1, 'buza@_abv.bg', '643702b338d8b9c54c78a97f81437180aa13715cdf1b431f9b6944631374ef6c7eae347ea501bd3b', 'Balev', 'Buzov', null, false);

INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, 2023, 1, 'https://www.evanshalshaw.com/-/media/evanshalshaw/ford/car-models/fiesta/road-tests/st-line/ford-fiesta-st-line-720x405px.ashx?mh=1440&la=en&h=405&w=720&mw=2560&hash=E364A53E3FB66A41E1EA333458150DCE'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://cdn4.focus.bg/fakti/photos/16x9/a88/prodava-se-nai-specialnia-ford-escort-1.jpg'),
       (3, 'Yaris', 'CAR', 1999, 2023, 2, 'https://upload.wikimedia.org/wikipedia/commons/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');