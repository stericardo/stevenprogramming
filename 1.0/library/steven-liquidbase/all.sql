[[1;34mINFO[m] Scanning for projects...
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--------------< [0;36mcom.stevenprogramming:steven-liquidbase[0;1m >---------------[m
[[1;34mINFO[m] [1mBuilding steven-liquidbase 1.0-SNAPSHOT[m
[[1;34mINFO[m] [1m--------------------------------[ jar ]---------------------------------[m
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mliquibase-maven-plugin:3.6.3:update[m [1m(default-cli)[m @ [36msteven-liquidbase[0;1m ---[m
[[1;34mINFO[m] ------------------------------------------------------------------------
[[1;34mINFO[m] Parsing Liquibase Properties File
[[1;34mINFO[m]   File: liquibase/liquibase-test.properties
[[1;34mINFO[m] ------------------------------------------------------------------------
[[1;34mINFO[m] Starting Liquibase at Tue, 11 Jun 2019 20:21:37 CST (version 3.6.3 built at 2019-01-29 11:34:48)
[[1;34mINFO[m] Executing on Database: jdbc:mysql://localhost:3306/spring-test
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] SELECT `LOCKED` FROM DATABASECHANGELOGLOCK WHERE ID=1
[[1;34mINFO[m] Successfully acquired change log lock
[[1;34mINFO[m] Dropping Database Objects in schema: spring-test.spring-test
[[1;34mINFO[m] SELECT MD5SUM FROM DATABASECHANGELOG WHERE MD5SUM IS NOT NULL LIMIT 1
[[1;34mINFO[m] SELECT @@FOREIGN_KEY_CHECKS
[[1;34mINFO[m] SET FOREIGN_KEY_CHECKS=0
[[1;34mINFO[m] DROP TABLE `person`
[[1;34mINFO[m] DROP TABLE `state`
[[1;34mINFO[m] SET FOREIGN_KEY_CHECKS=1
[[1;34mINFO[m] SELECT COUNT(*) FROM `DATABASECHANGELOG`
[[1;34mINFO[m] DROP TABLE `DATABASECHANGELOG`
[[1;34mINFO[m] SELECT COUNT(*) FROM `DATABASECHANGELOGLOCK`
[[1;34mINFO[m] DROP TABLE `DATABASECHANGELOGLOCK`
[[1;34mINFO[m] Successfully deleted all supported object types in schema spring-test.spring-test.
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] Successfully released change log lock
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] CREATE TABLE DATABASECHANGELOGLOCK (ID INT NOT NULL, `LOCKED` BIT(1) NOT NULL, LOCKGRANTED datetime NULL, LOCKEDBY VARCHAR(255) NULL, CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID))
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] DELETE FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] INSERT INTO DATABASECHANGELOGLOCK (ID, `LOCKED`) VALUES (1, 0)
[[1;34mINFO[m] SELECT `LOCKED` FROM DATABASECHANGELOGLOCK WHERE ID=1
[[1;34mINFO[m] Successfully acquired change log lock
[[1;34mINFO[m] Creating database history table with name: DATABASECHANGELOG
[[1;34mINFO[m] CREATE TABLE DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED datetime NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35) NULL, `DESCRIPTION` VARCHAR(255) NULL, COMMENTS VARCHAR(255) NULL, TAG VARCHAR(255) NULL, LIQUIBASE VARCHAR(20) NULL, CONTEXTS VARCHAR(255) NULL, LABELS VARCHAR(255) NULL, DEPLOYMENT_ID VARCHAR(10) NULL)
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOG
[[1;34mINFO[m] Reading from DATABASECHANGELOG
[[1;34mINFO[m] SELECT * FROM DATABASECHANGELOG ORDER BY DATEEXECUTED ASC, ORDEREXECUTED ASC
[[1;34mINFO[m] SELECT COUNT(*) FROM DATABASECHANGELOGLOCK
[[1;34mINFO[m] CREATE TABLE person (id INT AUTO_INCREMENT NOT NULL, firstname VARCHAR(50) NULL, lastname VARCHAR(50) NOT NULL, state CHAR(2) NULL, CONSTRAINT PK_PERSON PRIMARY KEY (id))
[[1;34mINFO[m] Table person created
[[1;34mINFO[m] ChangeSet liquibase/db-changelog-1.0.json::1::Steven Mendez ran successfully in 16ms
[[1;34mINFO[m] SELECT MAX(ORDEREXECUTED) FROM DATABASECHANGELOG
[[1;34mINFO[m] INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'Steven Mendez', 'liquibase/db-changelog-1.0.json', NOW(), 1, '8:f022085620a9dd87ae9ca1f93da51fd0', 'createTable tableName=person', '', 'EXECUTED', NULL, NULL, '3.6.3', '0306098847')
[[1;34mINFO[m] ALTER TABLE person ADD username VARCHAR(8) NULL
[[1;34mINFO[m] Columns username(varchar(8)) added to person
[[1;34mINFO[m] ChangeSet liquibase/db-changelog-1.0.json::2::Steven Mendez ran successfully in 24ms
[[1;34mINFO[m] INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('2', 'Steven Mendez', 'liquibase/db-changelog-1.0.json', NOW(), 2, '8:e3f0f50eb245f66c68ec504db93b6717', 'addColumn tableName=person', '', 'EXECUTED', NULL, NULL, '3.6.3', '0306098847')
[[1;34mINFO[m] CREATE TABLE state AS SELECT DISTINCT state AS id FROM person WHERE state IS NOT NULL
[[1;34mINFO[m] ALTER TABLE state MODIFY id CHAR(2) NOT NULL
[[1;34mINFO[m] ALTER TABLE state ADD PRIMARY KEY (id)
[[1;34mINFO[m] ALTER TABLE person ADD CONSTRAINT FK_PERSON_STATE FOREIGN KEY (state) REFERENCES state (id)
[[1;34mINFO[m] Lookup table added for person.state
[[1;34mINFO[m] ChangeSet liquibase/db-changelog-1.0.json::3::Steven Mendez ran successfully in 116ms
[[1;34mINFO[m] INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('3', 'Steven Mendez', 'liquibase/db-changelog-1.0.json', NOW(), 3, '8:12a8bb9e438047d9332c8aec4f90a76e', 'addLookupTable existingColumnName=state, existingTableName=person, newColumnName=id, newTableName=state', '', 'EXECUTED', NULL, NULL, '3.6.3', '0306098847')
[[1;34mINFO[m] Successfully released change log lock
[[1;34mINFO[m] ------------------------------------------------------------------------
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] [1;32mBUILD SUCCESS[m
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] Total time:  2.785 s
[[1;34mINFO[m] Finished at: 2019-06-11T20:21:39-06:00
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
