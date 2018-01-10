--------------------------------------------------------
--  File created - Friday-December-15-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CURRICULUM
--------------------------------------------------------

  CREATE TABLE CURRICULUM 
   (	"ID" NUMBER(10,0), 
	"ACTIVE" NUMBER(1,0), 
	"CORE" NUMBER(1,0), 
	"NAME" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into CURRICULUM
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C007846
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007846" ON CURRICULUM ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_23YYYB6FC6IB2CRJ9NEIHOGNA
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_23YYYB6FC6IB2CRJ9NEIHOGNA" ON CURRICULUM ("NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CURRICULUM
--------------------------------------------------------

  ALTER TABLE CURRICULUM ADD CONSTRAINT "UK_23YYYB6FC6IB2CRJ9NEIHOGNA" UNIQUE ("NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE CURRICULUM ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE CURRICULUM MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE CURRICULUM MODIFY ("ID" NOT NULL ENABLE);
  commit;
  
  

---------------------------------------------
-- DATA
----------------------------------------------
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (4,0,0,'Capital One');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (124,1,0,'Microservices');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (2,1,1,'.NET');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (1,1,1,'Java');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (3,1,1,'SDET');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (64,0,0,'Testing');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (265,0,1,'Demo');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (264,0,1,'Demo2');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (284,0,1,'test');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (184,0,1,'New Core');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (253,1,1,'IntelliJ');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (252,0,1,'Hibernate');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (267,0,1,'Core java 2');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (268,1,1,'Test Curricula');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (24,0,0,'Name');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (84,1,0,'Pega');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (105,0,1,'Custom');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (149,1,0,'Informatica');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (150,1,1,'Salesforce');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (104,0,0,'Ninja Master');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (144,1,0,'Oracle Fusion');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (164,0,1,'big data');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (248,0,1,'Core Name');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (250,0,1,'Angular Js');
Insert into CURRICULUM (ID,ACTIVE,CORE,NAME) values (251,0,1,'Angular');
COMMIT;



------------------------------------------------------
-- QUERIES FOR POSGRE SQL (ELEPHANT SQL)
------------------------------------------------------
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



--------------------------------------------------------
--  File created - Friday-December-15-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CURRICULUM_SKILL_JT
--------------------------------------------------------

  CREATE TABLE CURRICULUM_SKILL_JT 
   (	"CURRICULUM_ID" NUMBER(10,0), 
	"SKILL_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into CURRICULUM_SKILL_JT
SET DEFINE OFF;
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (284,115);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (284,58);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (284,73);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (24,47);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (24,50);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (24,51);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (24,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (24,1);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (267,60);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,50);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,1);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (105,51);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (105,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (105,59);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (105,66);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,1);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,53);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,106);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,2);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,3);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,48);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,49);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,53);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,55);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,55);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,49);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,108);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,110);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,50);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,48);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,54);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,2);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,25);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,56);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (84,91);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,86);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,57);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,3);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (1,69);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (252,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,56);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (124,57);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,59);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,59);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,60);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,60);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,58);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,66);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,66);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,62);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,67);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,65);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,63);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,64);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,61);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,46);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (2,111);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (252,115);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (253,108);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (267,111);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (267,66);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,47);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,5);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (4,3);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,69);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,72);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,70);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,71);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (3,68);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (149,46);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (149,65);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (149,86);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (4,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (4,55);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (4,56);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (150,66);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (150,111);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (150,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (104,90);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (104,106);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (104,108);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (144,1);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (144,25);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (164,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (164,59);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (164,60);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (250,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (251,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (248,4);
Insert into CURRICULUM_SKILL_JT (CURRICULUM_ID,SKILL_ID) values (248,59);
--------------------------------------------------------
--  Constraints for Table CURRICULUM_SKILL_JT
--------------------------------------------------------

  ALTER TABLE CURRICULUM_SKILL_JT MODIFY ("SKILL_ID" NOT NULL ENABLE);
  ALTER TABLE CURRICULUM_SKILL_JT MODIFY ("CURRICULUM_ID" NOT NULL ENABLE);
  
  commit;


--------------
-- ALTER to add foreign key
--------------
ALTER TABLE CURRICULUM_SKILL_JT ADD CONSTRAINT FK_CURRICULUMID
FOREIGN KEY (CURRICULUM_ID) REFERENCES CURRICULUM(ID);
COMMIT;




-----------------------
-- ELEPHANT SQL 
------------------------
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



--------------------------------------------------------
--------------------------------------------------------
--  File created - Tuesday-December-26-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence CURRICULUM_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CURRICULUM_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE   ;


---------------------------------------------------------------------------------
-- ELEPHANT SQL
----------------------------------------------------------------------------------
   CREATE SEQUENCE  "curriculum_seq"  MINVALUE 1 MAXVALUE 999999999999999999 INCREMENT BY 1 START WITH 150 CACHE 20 ;

   