------------------------------------------------------
-- QUERIES FOR POSGRE SQL (ELEPHANT SQL)
------------------------------------------------------

-----------------------------------------------------
-- CURRICULUM TABLE
-----------------------------------------------------
  CREATE TABLE CURRICULUM 
   (	"id" INTEGER Primary Key, 
	"active" INTEGER, 
	"core" INTEGER, 
	"name" VARCHAR(255)
   ) ;
ALTER TABLE CURRICULUM ADD PRIMARY KEY ("id");
ALTER TABLE CURRICULUM ADD CONSTRAINT "UK_23YYYB6FC6IB2CRJ9NEIHOGNA" UNIQUE ("name");
ALTER TABLE CURRICULUM ALTER COLUMN "name" SET NOT NULL;
ALTER TABLE CURRICULUM ALTER COLUMN "id" SET NOT NULL;



Insert into CURRICULUM ("id","active","core","name") values (4,0,0,'Capital One');
Insert into CURRICULUM ("id","active","core","name") values (124,1,0,'Microservices');
Insert into CURRICULUM ("id","active","core","name") values (2,1,1,'.NET');
Insert into CURRICULUM ("id","active","core","name") values (1,1,1,'Java');
Insert into CURRICULUM ("id","active","core","name") values (3,1,1,'SDET');
Insert into CURRICULUM ("id","active","core","name") values (64,0,0,'Testing');
Insert into CURRICULUM ("id","active","core","name") values (265,0,1,'Demo');
Insert into CURRICULUM ("id","active","core","name") values (264,0,1,'Demo2');
Insert into CURRICULUM ("id","active","core","name") values (284,0,1,'test');
Insert into CURRICULUM ("id","active","core","name") values (184,0,1,'New Core');
Insert into CURRICULUM ("id","active","core","name") values (253,1,1,'IntelliJ');
Insert into CURRICULUM ("id","active","core","name") values (252,0,1,'Hibernate');
Insert into CURRICULUM ("id","active","core","name") values (267,0,1,'Core java 2');
Insert into CURRICULUM ("id","active","core","name") values (268,1,1,'Test Curricula');
Insert into CURRICULUM ("id","active","core","name") values (24,0,0,'Name');
Insert into CURRICULUM ("id","active","core","name") values (84,1,0,'Pega');
Insert into CURRICULUM ("id","active","core","name") values (105,0,1,'Custom');
Insert into CURRICULUM ("id","active","core","name") values (149,1,0,'Informatica');
Insert into CURRICULUM ("id","active","core","name") values (150,1,1,'Salesforce');
Insert into CURRICULUM ("id","active","core","name") values (104,0,0,'Ninja Master');
Insert into CURRICULUM ("id","active","core","name") values (144,1,0,'Oracle Fusion');
Insert into CURRICULUM ("id","active","core","name") values (164,0,1,'big data');
Insert into CURRICULUM ("id","active","core","name") values (248,0,1,'Core Name');
Insert into CURRICULUM ("id","active","core","name") values (250,0,1,'Angular Js');
Insert into CURRICULUM ("id","active","core","name") values (251,0,1,'Angular');


----------------------------
ALTER TABLE curriculum alter column core type boolean USING core::boolean;
ALTER TABLE curriculum alter column active type boolean USING active::boolean;


----------------------------------------------------------
-- CURRICULUM_SKILL_JT TABLE
----------------------------------------------------------
CREATE TABLE CURRICULUM_SKILL_JT 
   (	"curriculum_id" INTEGER, 
	"skill_id" INTEGER
   );
   
ALTER TABLE CURRICULUM_SKILL_JT ADD CONSTRAINT fk_curriculumid
FOREIGN KEY ("curriculum_id") REFERENCES CURRICULUM("id");


  ALTER TABLE CURRICULUM_SKILL_JT ALTER COLUMN "skill_id" SET NOT NULL;
  ALTER TABLE CURRICULUM_SKILL_JT ALTER COLUMN "curriculum_id" SET NOT NULL;
  


Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (284,115);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (284,58);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (284,73);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (24,47);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (24,50);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (24,51);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (24,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (24,1);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (267,60);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,50);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,1);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (105,51);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (105,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (105,59);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (105,66);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,1);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,53);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,106);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,2);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,3);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,48);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,49);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,53);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,55);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,55);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,49);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,108);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,110);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,50);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,48);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,54);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,2);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,25);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,56);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (84,91);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,86);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,57);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,3);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (1,69);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (252,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,56);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (124,57);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,59);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,59);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,60);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,60);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,58);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,66);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,66);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,62);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,67);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,65);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,63);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,64);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,61);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,46);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (2,111);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (252,115);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (253,108);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (267,111);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (267,66);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,47);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,5);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (4,3);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,69);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,72);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,70);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,71);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (3,68);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (149,46);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (149,65);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (149,86);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (4,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (4,55);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (4,56);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (150,66);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (150,111);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (150,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (104,90);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (104,106);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (104,108);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (144,1);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (144,25);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (164,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (164,59);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (164,60);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (250,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (251,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (248,4);
Insert into CURRICULUM_SKILL_JT ("curriculum_id","skill_id") values (248,59);

-------------------------------------------------------------
-- SEQUENCE
-------------------------------------------------------------
CREATE SEQUENCE  "curriculum_seq"  MINVALUE 1 MAXVALUE 999999999999999999 INCREMENT BY 1 START WITH 150 CACHE 20 ;
