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

   