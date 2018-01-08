----------------
-- SKILL TABLE
----------------
CREATE TABLE SKILL 
   (	id integer primary key, 
	active integer, 
	name VARCHAR(255)
   );
ALTER TABLE SKILL ADD CONSTRAINT UNIQUE_NAME UNIQUE (name);
ALTER TABLE SKILL ALTER COLUMN "name" SET NOT NULL;
ALTER TABLE SKILL ALTER COLUMN "id" SET NOT NULL;

Insert into SKILL (ID,ACTIVE,NAME) values (47,1,'Core SDET');
Insert into SKILL (ID,ACTIVE,NAME) values (50,1,'Java Servlets');
Insert into SKILL (ID,ACTIVE,NAME) values (51,1,'JSP');
Insert into SKILL (ID,ACTIVE,NAME) values (91,1,'Pega');
Insert into SKILL (ID,ACTIVE,NAME) values (115,0,'b');
Insert into SKILL (ID,ACTIVE,NAME) values (126,1,'Unity5');
Insert into SKILL (ID,ACTIVE,NAME) values (128,0,'mySkill');
Insert into SKILL (ID,ACTIVE,NAME) values (4,1,'AngularJS');
Insert into SKILL (ID,ACTIVE,NAME) values (1,1,'Core Java');
Insert into SKILL (ID,ACTIVE,NAME) values (2,1,'JUnit');
Insert into SKILL (ID,ACTIVE,NAME) values (5,1,'Selenium/WebDriver');
Insert into SKILL (ID,ACTIVE,NAME) values (3,1,'Spring');
Insert into SKILL (ID,ACTIVE,NAME) values (78,1,'C++');
Insert into SKILL (ID,ACTIVE,NAME) values (25,1,'Oracle SQL');
Insert into SKILL (ID,ACTIVE,NAME) values (48,1,'JDBC');
Insert into SKILL (ID,ACTIVE,NAME) values (49,1,'HTML');
Insert into SKILL (ID,ACTIVE,NAME) values (52,1,'Freemarker');
Insert into SKILL (ID,ACTIVE,NAME) values (53,1,'CSS');
Insert into SKILL (ID,ACTIVE,NAME) values (54,1,'jQuery');
Insert into SKILL (ID,ACTIVE,NAME) values (55,1,'Hibernate');
Insert into SKILL (ID,ACTIVE,NAME) values (56,1,'REST');
Insert into SKILL (ID,ACTIVE,NAME) values (57,1,'SOAP');
Insert into SKILL (ID,ACTIVE,NAME) values (59,1,'ASP.NET MVC');
Insert into SKILL (ID,ACTIVE,NAME) values (60,1,'ASP.NET WEB API');
Insert into SKILL (ID,ACTIVE,NAME) values (58,1,'C#');
Insert into SKILL (ID,ACTIVE,NAME) values (66,1,'ADO.NET');
Insert into SKILL (ID,ACTIVE,NAME) values (62,1,'MSTest');
Insert into SKILL (ID,ACTIVE,NAME) values (67,1,'T-SQL');
Insert into SKILL (ID,ACTIVE,NAME) values (65,1,'Entity Framework');
Insert into SKILL (ID,ACTIVE,NAME) values (63,1,'xUnit');
Insert into SKILL (ID,ACTIVE,NAME) values (64,1,'NLog');
Insert into SKILL (ID,ACTIVE,NAME) values (61,1,'IIS');
Insert into SKILL (ID,ACTIVE,NAME) values (69,1,'TestNG');
Insert into SKILL (ID,ACTIVE,NAME) values (72,1,'Manual Testing');
Insert into SKILL (ID,ACTIVE,NAME) values (70,1,'Pyhton');
Insert into SKILL (ID,ACTIVE,NAME) values (71,1,'UFT');
Insert into SKILL (ID,ACTIVE,NAME) values (68,1,'Cucumber');
Insert into SKILL (ID,ACTIVE,NAME) values (73,1,'C');
Insert into SKILL (ID,ACTIVE,NAME) values (86,1,'Selenium webdriver');
Insert into SKILL (ID,ACTIVE,NAME) values (90,1,'Nightwatch');
Insert into SKILL (ID,ACTIVE,NAME) values (106,0,'Doing Backflips');
Insert into SKILL (ID,ACTIVE,NAME) values (108,1,'Java');
Insert into SKILL (ID,ACTIVE,NAME) values (127,1,'Unreal');
Insert into SKILL (ID,ACTIVE,NAME) values (46,1,'Core .NET');
Insert into SKILL (ID,ACTIVE,NAME) values (110,1,'Java Core');
Insert into SKILL (ID,ACTIVE,NAME) values (111,0,'a');
Insert into SKILL (ID,ACTIVE,NAME) values (146,1,'qwe');
Insert into SKILL (ID,ACTIVE,NAME) values (6,null,'Java but better');
Insert into SKILL (ID,ACTIVE,NAME) values (21,1,'Ruby');
Insert into SKILL (ID,ACTIVE,NAME) values (22,1,'PHP');
Insert into SKILL (ID,ACTIVE,NAME) values (23,1,'Angular 4');

ALTER TABLE skill alter column active type boolean USING active::boolean;

-----------------------
-- SEQUENCE
-----------------------
CREATE SEQUENCE  SKILL_SEQ  MINVALUE 1 MAXVALUE 9999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 ;
