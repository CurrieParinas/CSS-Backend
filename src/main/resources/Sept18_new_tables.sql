CREATE TABLE BODYSITE (
    BODYSITE_ID NUMBER NOT NULL,
    BODYSITE_NAME VARCHAR2(255),
    CONSTRAINT PK_BODYSITE PRIMARY KEY (BODYSITE_ID)
);

CREATE TABLE BASIS (
    BASIS_ID NUMBER NOT NULL,
    CATEGORY VARCHAR2(255) NOT NULL,
    SUBCATEGORY VARCHAR2(255) NOT NULL,
    CONSTRAINT PK_BASIS PRIMARY KEY (BASIS_ID)
);

CREATE TABLE DISEASESTATUS (
    DXSTATUS_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    DXSTATUS_ALIVE CHAR(1) NOT NULL,
    DXSTATUS_SYMPTOMS CHAR(1) NOT NULL,
    DXSTATUS_RECURRENCE CHAR(1) NOT NULL,
    DXSTATUS_METASTATIC CHAR(1) NOT NULL,
    DXSTATUS_CURATIVE CHAR(1) NOT NULL,
    DXSTATUS_CREATEDON TIMESTAMP,
    CONSTRAINT PK_DISEASE_STATUS PRIMARY KEY (DXSTATUS_ID),
    CONSTRAINT FK_PATIENT_DISEASESTATUS FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID)
);

CREATE TABLE HISTOLOGY (
    HISTOLOGY_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    HISTO_PATHOLOGY NUMBER NOT NULL, -- Foreign key to a PATHOLOGY table
    HISTO_TUMORSIZE NUMBER NOT NULL,
    HISTO_TUMOREXTENSION CHAR(1)  NOT NULL,
    HISTO_GRADE NUMBER NOT NULL,
    HISTO_NODEPOSITIVE NUMBER NOT NULL,
    HISTO_NODEHARVEST NUMBER NOT NULL,
    HISTO_MARGINS_NEGATIVE CHAR(1) NOT NULL,
    HISTO_POSITIVEMARGINS VARCHAR2(255) NOT NULL,
    HISTO_STAGE VARCHAR2(50) NOT NULL,
    HISTO_CREATEDON TIMESTAMP,
    HISTO_UPDATEDON TIMESTAMP,
    HISTO_ENCODER NUMBER, -- Foreign key to USER table or similar
    CONSTRAINT PK_HISTOLOGY PRIMARY KEY (HISTOLOGY_ID),
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
    METS_CREATEDON TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    METS_UPDATEDON TIMESTAMP,
    METS_ENCODER NUMBER, -- Foreign key to PATIENT table
    CONSTRAINT PK_METASTATICSITE PRIMARY KEY (METS_ID),
    CONSTRAINT FK_PATIENT_METS FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID),
    CONSTRAINT FK_ENCODER_METS FOREIGN KEY (METS_ENCODER) REFERENCES USERTABLE(USER_ID)
);

CREATE TABLE DISEASE (
    DISEASE_ID NUMBER NOT NULL,
    PATIENT_ID NUMBER, -- Foreign key to PATIENT table
    DISEASE_PRIMARY_SITE NUMBER NOT NULL, -- Foreign key to BODYSITE table
    DISEASE_DIAGNOSISDATE DATE NOT NULL,
    DISEASE_BASIS NUMBER NOT NULL, -- Foreign key to BASIS table
    DISEASE_LATERALITY VARCHAR2(50) NOT NULL, -- Enum values should be managed by a check constraint or a separate lookup table
    DISEASE_HISTOLOGY NUMBER NOT NULL, -- Foreign key to HISTOLOGY table
    DISEASE_EXTENT VARCHAR2(50) NOT NULL, -- Enum values should be managed by a check constraint or a separate lookup table
    DISEASE_TUMORSIZE NUMBER NOT NULL,
    DISEASE_LYMPHNODE NUMBER NOT NULL,
    DISEASE_METASTATIC CHAR(1) NOT NULL,
    DISEASE_METASTATICSITE NUMBER, -- Foreign key to METASTATICSITE table
    DISEASE_MULTIPLEPRIMARY NUMBER NOT NULL,
    DISEASE_OTHERSITE NUMBER, -- Foreign key to another table (BODYSITE, for example)
    DISEASE_TSTAGE NUMBER NOT NULL,
    DISEASE_NSTAGE NUMBER NOT NULL,
    DISEASE_MSTAGE NUMBER NOT NULL,
    DISEASE_GSTAGE NUMBER,
    DISEASE_STAGE VARCHAR2(50) NOT NULL,
    DISEASE_STAGETYPE VARCHAR2(50) NOT NULL, -- Enum values should be managed by a check constraint or a separate lookup table
    DISEASE_STATUS NUMBER NOT NULL, -- Foreign key to DISEASESTATUS table
    DISEASE_CREATEDON TIMESTAMP,
    DISEASE_UPDATEDON TIMESTAMP,
    DISEASE_ENCODER NUMBER, -- Foreign key to USER table or similar
    CONSTRAINT PK_DISEASE PRIMARY KEY (DISEASE_ID),
    CONSTRAINT FK_PATIENT_DISEASE FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID),
    CONSTRAINT FK_PRIMARY_SITE FOREIGN KEY (DISEASE_PRIMARY_SITE) REFERENCES BODYSITE(BODYSITE_ID),
    CONSTRAINT FK_BASIS FOREIGN KEY (DISEASE_BASIS) REFERENCES BASIS(BASIS_ID),
    CONSTRAINT FK_HISTOLOGY FOREIGN KEY (DISEASE_HISTOLOGY) REFERENCES HISTOLOGY(HISTOLOGY_ID),
    CONSTRAINT FK_METASTATIC_SITE FOREIGN KEY (DISEASE_METASTATICSITE) REFERENCES METASTATICSITE(METS_ID),
    CONSTRAINT FK_OTHER_SITE FOREIGN KEY (DISEASE_OTHERSITE) REFERENCES BODYSITE(BODYSITE_ID),
    CONSTRAINT FK_STATUS FOREIGN KEY (DISEASE_STATUS) REFERENCES DISEASESTATUS(DXSTATUS_ID),
    CONSTRAINT FK_ENCODER_DISEASE FOREIGN KEY (DISEASE_ENCODER) REFERENCES USERTABLE(USER_ID)
);


CREATE SEQUENCE BASIS_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE SEQUENCE BODYSITE_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;