CREATE TABLE MapImage(
	Id int(7) unsigned NOT NULL auto_increment PRIMARY KEY,
	ImgData longblob NOT NULL DEFAULT '',
	ImgType varchar(50) UNIQUE NOT NULL DEFAULT '',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;


CREATE TABLE ClassCategory(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Class varchar(25) NULL DEFAULT '',	
	Description text NOT NULL,	
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO ClassCategory
	(Id,Class,Description) 
VALUES 
	(1,'Hauptstrasse','Strassen 1. Klasse sind meistens blau signalisierte Hauptstrassen. Sie sind mindestens 6 Meter breit, so dass zwei Lastwagen sich ungehindert kreuzen k�nnen, und f�r den gemischten Verkehr (Velos, Traktoren) gestattet. Sie bestehen aus einem Hartbelag und Steigungen sind nicht h�her als 10%. Diese Strassen haben oft einen Velostreifen und Trottoir. Sie dienen vorwiegend dem Durchgangsverkehr.'),
	(2,'Hauptstrasse','Strassen 2. Klasse sind meistens weiss signalisierte Nebenstrassen. Sie sind mindestens 4 Meter breit, so dass zwei Autos sich ungehindert kreuzen k�nnen. Sie bestehen aus einem Hartbelag und Steigungen sind nicht h�her als 15%. Sie sind Ortsverbindungsstrassen oder wichtige Strassen innerorts. Zur Erh�hung der Sicherheit solcher Strassen k�nnen sie als Kernfahrbahn gestaltet werden.'),
	(3,'Strasse','Strassen 3. Klasse sind mindestens 2,80 Meter breit. Sie haben nicht zwingend einen Hartbelag. Gew�hnlich sind sie mit Lastwagen befahrbar, gekreuzt wird an Ausweichstellen. Diese Strassen dienen der Erschliessung von Siedlungen oder wichtigen Einzelgeb�uden sowie der Land- und Forstwirtschaft.'),
	(4,'Fahrweg','Fahrwege 4. Klasse sind mindestens 1,80 Meter breit. Diese Naturstrassen k�nnen in der Mitte Gras haben. Bei normalen Verh�ltnissen sind sie mit Personenwagen befahrbar. Sie k�nnen mit einem Fahrverbot hinterlegt sein.'),
	(5,'Feldweg','Wege der 5. Klasse sind Feld- und Waldwege ohne ausreichenden Unterbau und oft nur mit Gel�ndefahrzeugen oder Traktoren befahrbar. Velowege wiederum k�nnen mit Hartbelag ausgestattet sein. Sie f�hren oft parallel zu h�herklassierten Strassen, sind aber getrennt angelegt.'),
	(6,'Fussweg','Wege der 6. Klasse sind Fussg�ngern vorbehalten. Es kann sich dabei von Bergpfaden bis zu breiten Spazierwegen handeln. Sie sind oft Teil von Wanderwegen (gelb, weiss-rot-weiss oder weiss-blau-weiss markiert).'),
	(7,'Autobahn','Eine kreuzungsfreie Strasse f�r den Schnellverkehr mit Mittelstreifen, auf denen der Langsamverkehr nicht gestattet ist. Es ist mit dem gr�nen Autobahnsymbol gekennzeichnet.'),
	(8,'Autostrasse','Eine kreuzungsfreie Strasse f�r den Schnellverkehr mit zwei oder mehr Fahrbahnen ohne Mittelstreifen, auf denen der Langsamverkehr nicht gestattet ist. Es ist mit dem gr�nen Autostrassensymbol gekennzeichnet.'),
	(9,'Quartierstrasse','Quartierstrassen sind ebenfalls mindestens 4 Meter breit und immer mit Hartbelag. Sie k�nnen verkehrsberuhigt sein und sind ohne Bedeutung f�r den Durchgangsverkehr. Ausserorts dienen Strassen dieser Klasse der Zufahrt zu wichtigen Anlagen oder Objekten.');


CREATE TABLE DistanceUnit(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Unit varchar(50) NULL DEFAULT 'neue Einheit',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO DistanceUnit
	(Id,Unit) 
VALUES 
	(1,'cm'),
	(2,'m'),
	(3,'km');


CREATE TABLE WayPoint(
	Id int(7) unsigned NOT NULL auto_increment PRIMARY KEY,
	XAxis int(7) NOT NULL DEFAULT '0',
	YAxis int(7) NOT NULL DEFAULT '0',
	Name varchar(50) NULL DEFAULT '',	
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;



CREATE TABLE Way(
	Id int(7) unsigned NOT NULL auto_increment PRIMARY KEY,
	StartPoint int(7) unsigned NOT NULL DEFAULT '0',
	FOREIGN KEY (StartPoint) REFERENCES WayPoint(Id),
	EndPoint int(7) unsigned NOT NULL DEFAULT '0',
	FOREIGN KEY (EndPoint) REFERENCES WayPoint(Id),
	Distance int(7) NOT NULL DEFAULT '0',
	DistanceUnitId int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (DistanceUnitId) REFERENCES DistanceUnit(Id),
	ClassCategoryId int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (ClassCategoryId) REFERENCES ClassCategory(Id),	
	Toll boolean NOT NULL DEFAULT '0',
	Speed int(3) NOT NULL DEFAULT '0',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;


CREATE TABLE RoutingMap(
	Id int(7) unsigned NOT NULL auto_increment PRIMARY KEY,
	MapImageId int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (MapImageId) REFERENCES MapImage(Id),
	WayId int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (WayId) REFERENCES Way(Id),	
	Description varchar(50) NOT NULL DEFAULT 'Neuer Eintrag',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;




/* Testdaten abf�llen */


INSERT INTO MapImage
	(Id,ImgData,ImgType)
VALUES 
	(1,1,'jpg');

INSERT INTO WayPoint
	(Id,XAxis,YAxis,Name) 
VALUES 
	(1,1,2,'Startpunkt 1/2'),
	(2,3,4,'Startpunkt 3/4'),
	(3,5,6,'Startpunkt 5/6'),
	(4,7,8,'Startpunkt 7/8');


INSERT INTO Way
	(Id,StartPoint,EndPoint,Distance,DistanceUnitId,ClassCategoryId,Toll) 
VALUES 
	(1,1,2,10,3,4,0),
	(2,3,4,15,2,5,0);

INSERT INTO RoutingMap
	(Id,MapImageId,WayId,Description)
VALUES 
	(1,1,1,'Teststrecke 1');
