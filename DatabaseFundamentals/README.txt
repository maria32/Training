1. Sa se creeze urmatoarele tabele: Tari, Judete, Orase (Exista judete care nu au orase) + Scripturi de insert date.
	::::database backup: fisierul "database" + inserturile in baza de date:
		CREATE sequence id_sequence START WITH 1;


		INSERT INTO countries("ID", "Name") VALUES (nextval('id_sequence'), 'Romania');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'Anglia');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'Germania');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'Franta');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'USA');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'Polonia');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'Rusia');
		INSERT INTO Countries("ID", "Name") VALUES (nextval('id_sequence'), 'China');

		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Dambovita', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Ilfov', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Arges', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Olt', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Timis', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Constanta', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Tulcea', (SELECT "ID" FROM countries WHERE "Name" = 'Romania'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Mayenne', (SELECT "ID" FROM countries WHERE "Name" = 'Franta'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Yvelines', (SELECT "ID" FROM countries WHERE "Name" = 'Franta'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Essonne', (SELECT "ID" FROM countries WHERE "Name" = 'Franta'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Gwynedd', (SELECT "ID" FROM countries WHERE "Name" = 'Anglia'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Hampshire', (SELECT "ID" FROM countries WHERE "Name" = 'Anglia'));
		INSERT INTO districts("ID", "Name", "Country_ID") VALUES (nextval('id_sequence'), 'Essex', (SELECT "ID" FROM countries WHERE "Name" = 'Anglia'));

		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Pucioasa', 15000, (SELECT "ID" FROM districts WHERE "Name" = 'Dambovita'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Targoviste', 20000, (SELECT "ID" FROM districts WHERE "Name" = 'Dambovita'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Fieni', 900, (SELECT "ID" FROM districts WHERE "Name" = 'Dambovita'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Moroeni', 300, (SELECT "ID" FROM districts WHERE "Name" = 'Dambovita'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Constanta', 30000, (SELECT "ID" FROM districts WHERE "Name" = 'Constanta'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Mayenne', 20000, (SELECT "ID" FROM districts WHERE "Name" = 'Mayenne'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Laval', 30000, (SELECT "ID" FROM districts WHERE "Name" = 'Mayenne'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Château-Gontier', 90000, (SELECT "ID" FROM districts WHERE "Name" = 'Mayenne'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Versailles', 120000, (SELECT "ID" FROM districts WHERE "Name" = 'Yvelines'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Bangor', 200, (SELECT "ID" FROM districts WHERE "Name" = 'Gwynedd'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Caernarfon', 300, (SELECT "ID" FROM districts WHERE "Name" = 'Gwynedd'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Tywyn', 367, (SELECT "ID" FROM districts WHERE "Name" = 'Gwynedd'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Waterlooville', 999, (SELECT "ID" FROM districts WHERE "Name" = 'Hampshire'));
		INSERT INTO cities("ID", "Name", "locuitori", "district_id") VALUES (nextval('id_sequence'), 'Winchester', 800, (SELECT "ID" FROM districts WHERE "Name" = 'Hampshire'));

2. Judete fara orase:

		SELECT COUNT(*)
		FROM districts d
		WHERE d."ID" NOT IN (SELECT "district_id" FROM cities)

3. Sa se afiseze tarile care au orase cu peste o mie de locuitori, dar cele care au mai putin de o mie?

	::::tari care au orase cu peste 1000 locuitori:

		SELECT c."Name"
		FROM countries c INNER JOIN districts d ON c."ID" = d."Country_ID"
		INNER JOIN cities ci ON d."ID" = ci."district_id"
		WHERE ci."locuitori" > 1000
		GROUP BY c."Name"
		
	::::tari care au orase cu mai putin de 1000 locutiori
	
		SELECT c."Name"
		FROM countries c INNER JOIN districts d ON c."ID" = d."Country_ID"
		INNER JOIN cities ci ON d."ID" = ci."district_id"
		WHERE ci."locuitori" < 1000
		GROUP BY c."Name"
		
4. Sa se afiseze toate tarile care contin ‘RO’ in nume.
		
		SELECT c."Name"
		FROM countries c
		WHERE c."Name" LIKE '%RO%'
