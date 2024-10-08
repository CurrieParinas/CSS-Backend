CREATE TABLE ADDRESS (
    ADDRESS_ID NUMBER NOT NULL,
    ADDRESS_NUMBER NUMBER,
    ADDRESS_STREET VARCHAR2(255),
    ADDRESS_CITY VARCHAR2(255),
    ADDRESS_REGION VARCHAR2(255),
    ADDRESS_ZIPCODE VARCHAR2(10),
    CONSTRAINT PK_ADDRESS_ID PRIMARY KEY (ADDRESS_ID)
);
CREATE TABLE ACCESSTABLE (
    ACCESS_ID NUMBER NOT NULL,
    ACCESS_CANENROLLPATIENT CHAR(1),
    ACCESS_CANEDITPATIENTINFO CHAR(1),
    ACCESS_CANVIEWPATIENTINFO CHAR(1),
    ACCESS_CANDELETEUSER CHAR(1),
    ACCESS_CANDELETEPATIENTINFO CHAR(1),
    CONSTRAINT PK_ACCESS_ID PRIMARY KEY (ACCESS_ID)
);

CREATE TABLE ROLE (
    ROLE_ID NUMBER NOT NULL,
    ROLE_NAME VARCHAR2(255),
    ROLE_DESCRIPTION VARCHAR2(1000),
    CONSTRAINT PK_ROLE_ID PRIMARY KEY (ROLE_ID)
);


CREATE TABLE HOSPITAL (
    HOSPITAL_ID NUMBER NOT NULL,
    HOSPITAL_NAME VARCHAR2(255),
    HOSPITAL_ADDRESS NUMBER,
    HOSPITAL_CONTACT_NO VARCHAR2(15),
    CONSTRAINT PK_HOSPITAL_ID PRIMARY KEY (HOSPITAL_ID),
    CONSTRAINT FK_ADDRESS_HOSPITAL FOREIGN KEY (HOSPITAL_ADDRESS) REFERENCES Address(ADDRESS_ID)
);

CREATE TABLE DEPARTMENT (
    DEPARTMENT_ID NUMBER NOT NULL,
    DEPARTMENT_NAME VARCHAR2(255),
    CONSTRAINT PK_DEPARTMENT_ID PRIMARY KEY (DEPARTMENT_ID)
);

CREATE TABLE SPECIALTY (
    SPECIALTY_ID NUMBER NOT NULL,
    SPECIALTY_NAME VARCHAR2(255),
    SPECIALTY_DESCRIPTION VARCHAR2(1000),
    CONSTRAINT PK_SPECIALTY_ID PRIMARY KEY (SPECIALTY_ID)
);
CREATE TABLE USERTABLE (
    USER_ID NUMBER NOT NULL,
    USER_LASTNAME VARCHAR2(255) NOT NULL,
    USER_FIRSTNAME VARCHAR2(255) NOT NULL,
    USER_MIDDLENAME VARCHAR2(255),
    USER_EMAIL VARCHAR2(255) NOT NULL UNIQUE,
    USER_PASSWORD VARCHAR2(255) NOT NULL,
    USER_GENDER VARCHAR2(50) NOT NULL,
    USER_MARITAL_STATUS VARCHAR2(50) NOT NULL,
    USER_BIRTHDATE DATE NOT NULL,
    USER_BIRTHPLACE VARCHAR2(255) NOT NULL,
    USER_ADDRESS NUMBER, -- Foreign key to Address table
    USER_CONTACTNO NUMBER,
    USER_ROLE NUMBER, -- Foreign key to a Role table
    USER_ACCESS NUMBER , -- Foreign key to an Access table
    USER_IS_VERIFIED CHAR(1),
    USER_STATUS VARCHAR2(50),
    USER_CREATED_ON TIMESTAMP,
    USER_UPDATED_ON TIMESTAMP,
    USER_ENCODER NUMBER, -- Foreign key to another User or another table
    CONSTRAINT PK_USER_ID PRIMARY KEY (USER_ID),
    CONSTRAINT FK_ADDRESS_USER FOREIGN KEY (USER_ADDRESS) REFERENCES Address(ADDRESS_ID),
    CONSTRAINT FK_ROLE_USER FOREIGN KEY (USER_ROLE) REFERENCES Role(ROLE_ID),
    CONSTRAINT FK_ACCESS_USER FOREIGN KEY (USER_ACCESS) REFERENCES ACCESSTABLE(ACCESS_ID),
    CONSTRAINT FK_ENCODER_USER FOREIGN KEY (USER_ENCODER) REFERENCES USERTABLE(USER_ID)
);

CREATE TABLE PATIENT (
    PATIENT_ID NUMBER NOT NULL,
    USER_ID NUMBER,
    PATIENT_CREATED_ON TIMESTAMP,
    PATIENT_UPDATED_ON TIMESTAMP,
    CONSTRAINT PK_PATIENT_ID PRIMARY KEY (PATIENT_ID),
    CONSTRAINT FK_USER_PATIENT FOREIGN KEY (USER_ID) REFERENCES USERTABLE(USER_ID)
);

CREATE TABLE DOCTOR (
    DOCTOR_ID NUMBER NOT NULL,
    USER_ID NUMBER NOT NULL,
    DOCTOR_HOSPITAL NUMBER NOT NULL, -- Foreign key to a Hospital table
    DOCTOR_DEPARTMENT NUMBER NOT NULL, -- Foreign key to a Department table
    DOCTOR_SPECIALTY NUMBER NOT NULL, -- Foreign key to a Specialty table
    DOCTOR_E_SIGNATURE BLOB,
    DOCTOR_LICENSE_NUMBER VARCHAR2(8) NOT NULL,
    DOCTOR_LICENSE_EXP_DATE DATE NOT NULL,
    DOCTOR_SCHEDULE NUMBER NOT NULL, -- Foreign key to a Schedule table
    CONSTRAINT PK_DOCTOR_ID PRIMARY KEY (DOCTOR_ID),
    CONSTRAINT FK_USER_DOCTOR FOREIGN KEY (user_ID) REFERENCES USERTABLE(USER_ID),
    CONSTRAINT FK_HOSPITAL_DOCTOR FOREIGN KEY (DOCTOR_HOSPITAL) REFERENCES Hospital(HOSPITAL_ID),
    CONSTRAINT FK_DEPARTMENT_DOCTOR FOREIGN KEY (DOCTOR_DEPARTMENT) REFERENCES Department(DEPARTMENT_ID),
    CONSTRAINT FK_SPECIALTY_DOCTOR FOREIGN KEY (DOCTOR_SPECIALTY) REFERENCES Specialty(SPECIALTY_ID)--,
    --CONSTRAINT fk_schedule_doctor FOREIGN KEY (DOCTOR_SCHEDULE) REFERENCES Schedule(schedule_ID)
);

CREATE TABLE ONBOARD (
    RELATION_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER NOT NULL,
    DOCTOR_ID NUMBER NOT NULL,
    DOCTOR_ROLE VARCHAR2(255),
    CONSTRAINT PK_RELATION_ID PRIMARY KEY (RELATION_ID),
    CONSTRAINT FK_PATIENT_ONBOARD FOREIGN KEY (PATIENT_ID) REFERENCES Patient(PATIENT_ID),
    CONSTRAINT FK_DOCTOR_ONBOARD FOREIGN KEY (DOCTOR_ID) REFERENCES Doctor(DOCTOR_ID)
);

CREATE TABLE BODYSITE (
    BODYSITE_ID NUMBER NOT NULL,
    BODYSITE_NAME VARCHAR2(255),
    CONSTRAINT PK_BODYSITE_ID PRIMARY KEY (BODYSITE_ID)
);

CREATE TABLE BASIS (
    BASIS_ID NUMBER NOT NULL,
    CATEGORY VARCHAR2(255) NOT NULL,
    SUBCATEGORY VARCHAR2(255) NOT NULL,
    CONSTRAINT PK_BASIS_ID PRIMARY KEY (BASIS_ID)
);

CREATE TABLE DISEASESTATUS (
    DXSTATUS_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    DXSTATUS_ALIVE CHAR(1) NOT NULL,
    DXSTATUS_SYMPTOMS CHAR(1) NOT NULL,
    DXSTATUS_RECURRENCE CHAR(1) NOT NULL,
    DXSTATUS_METASTATIC CHAR(1) NOT NULL,
    DXSTATUS_CURATIVE CHAR(1) NOT NULL,
    DXSTATUS_CREATED_ON TIMESTAMP,
    CONSTRAINT PK_DXSTATUS_ID PRIMARY KEY (DXSTATUS_ID),
    CONSTRAINT FK_PATIENT_DISEASESTATUS FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID)
);

CREATE TABLE HISTOLOGY (
    HISTOLOGY_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    HISTO_PATHOLOGY NUMBER NOT NULL, -- Foreign key to a PATHOLOGY table
    HISTO_TUMOR_SIZE NUMBER NOT NULL,
    HISTO_TUMOR_EXTENSION CHAR(1)  NOT NULL,
    HISTO_GRADE NUMBER NOT NULL,
    HISTO_NODE_POSITIVE NUMBER NOT NULL,
    HISTO_NODE_HARVEST NUMBER NOT NULL,
    HISTO_MARGINS_NEGATIVE CHAR(1) NOT NULL,
    HISTO_POSITIVE_MARGINS VARCHAR2(255) NOT NULL,
    HISTO_STAGE VARCHAR2(50) NOT NULL,
    HISTO_CREATED_ON TIMESTAMP,
    HISTO_UPDATED_ON TIMESTAMP,
    HISTO_ENCODER NUMBER, -- Foreign key to USER table or similar
    CONSTRAINT PK_HISTOLOGY_ID PRIMARY KEY (HISTOLOGY_ID),
    CONSTRAINT FK_PATIENT_HISTOLOGY FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID),
    --CONSTRAINT FK_PATHOLOGY FOREIGN KEY (PATHOLOGY) REFERENCES PATHOLOGY(PATHOLOGY_ID),
    CONSTRAINT FK_ENCODER_HISTOLOGY FOREIGN KEY (HISTO_ENCODER) REFERENCES USERTABLE(USER_ID)
);

CREATE TABLE METASTATICSITE (
    METS_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    METS_DISTANTLN CHAR(1),
    METS_BONE CHAR(1),
    METS_LIVER CHAR(1),
    METS_LUNG CHAR(1),
    METS_BRAIN CHAR(1),
    METS_OVARY CHAR(1),
    METS_SKIN CHAR(1),
    METS_INTESTINE CHAR(1),
    METS_OTHERS CHAR(1),
    METS_UNKNOWN CHAR(1),
    METS_NOTES VARCHAR2(2000),
    METS_CREATED_ON TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    METS_UPDATED_ON TIMESTAMP,
    METS_ENCODER NUMBER, -- Foreign key to PATIENT table
    CONSTRAINT PK_METASTATICSITE_ID PRIMARY KEY (METS_ID),
    CONSTRAINT FK_PATIENT_METS FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID),
    CONSTRAINT FK_ENCODER_METS FOREIGN KEY (METS_ENCODER) REFERENCES USERTABLE(USER_ID)
);

CREATE TABLE DISEASE (
    DISEASE_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    DISEASE_PRIMARY_SITE NUMBER NOT NULL, -- Foreign key to BODYSITE table
    DISEASE_DIAGNOSIS_DATE DATE NOT NULL,
    DISEASE_BASIS NUMBER NOT NULL, -- Foreign key to BASIS table
    DISEASE_LATERALITY VARCHAR2(50) NOT NULL, -- Enum values should be managed by a check constraint or a separate lookup table
    DISEASE_HISTOLOGY NUMBER NOT NULL, -- Foreign key to HISTOLOGY table
    DISEASE_EXTENT VARCHAR2(50) NOT NULL, -- Enum values should be managed by a check constraint or a separate lookup table
    DISEASE_TUMOR_SIZE NUMBER NOT NULL,
    DISEASE_LYMPH_NODE NUMBER NOT NULL,
    DISEASE_METASTATIC CHAR(1) NOT NULL,
    DISEASE_METASTATIC_SITE NUMBER, -- Foreign key to METASTATICSITE table
    DISEASE_MULTIPLE_PRIMARY NUMBER NOT NULL,
    DISEASE_OTHER_SITE NUMBER, -- Foreign key to another table (BODYSITE, for example)
    DISEASE_TSTAGE NUMBER NOT NULL,
    DISEASE_NSTAGE NUMBER NOT NULL,
    DISEASE_MSTAGE NUMBER NOT NULL,
    DISEASE_GSTAGE NUMBER,
    DISEASE_STAGE VARCHAR2(50) NOT NULL,
    DISEASE_STAGE_TYPE VARCHAR2(50) NOT NULL, -- Enum values should be managed by a check constraint or a separate lookup table
    DISEASE_STATUS NUMBER NOT NULL, -- Foreign key to DISEASESTATUS table
    DISEASE_CREATED_ON TIMESTAMP,
    DISEASE_UPDATED_ON TIMESTAMP,
    DISEASE_ENCODER NUMBER, -- Foreign key to USER table or similar
    CONSTRAINT PK_DISEASE_ID PRIMARY KEY (DISEASE_ID),
    CONSTRAINT FK_PATIENT_DISEASE FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID),
    CONSTRAINT FK_PRIMARY_SITE_DISEASE FOREIGN KEY (DISEASE_PRIMARY_SITE) REFERENCES BODYSITE(BODYSITE_ID),
    CONSTRAINT FK_BASIS_DISEASE FOREIGN KEY (DISEASE_BASIS) REFERENCES BASIS(BASIS_ID),
    CONSTRAINT FK_HISTOLOGY_DISEASE FOREIGN KEY (DISEASE_HISTOLOGY) REFERENCES HISTOLOGY(HISTOLOGY_ID),
    CONSTRAINT FK_METASTATIC_SITE_DISEASE FOREIGN KEY (DISEASE_METASTATIC_SITE) REFERENCES METASTATICSITE(METS_ID),
    CONSTRAINT FK_OTHER_SITE_DISEASE FOREIGN KEY (DISEASE_OTHER_SITE) REFERENCES BODYSITE(BODYSITE_ID),
    CONSTRAINT FK_STATUS_DISEASE FOREIGN KEY (DISEASE_STATUS) REFERENCES DISEASESTATUS(DXSTATUS_ID),
    CONSTRAINT FK_ENCODER_DISEASE FOREIGN KEY (DISEASE_ENCODER) REFERENCES USERTABLE(USER_ID)
);

CREATE SEQUENCE ADDRESS_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE ACCESS_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE ROLE_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE HOSPITAL_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE DEPARTMENT_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE SPECIALTY_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE USER_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE PATIENT_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE DOCTOR_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE ONBOARD_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE BASIS_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE BODYSITE_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;


CREATE SEQUENCE DISEASESTATUS_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE HISTOLOGY_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE METASTATICSITE_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE DISEASE_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;