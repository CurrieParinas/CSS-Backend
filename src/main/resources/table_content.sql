INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.nextval, 100, 'Lagdameo st.', 'Valenzuela City', 'NCR', '1440');
INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.nextval, 101, 'Kapitan Rado st.', 'Manila', 'NCR', '1441');
INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.nextval, 102, 'General De Leon st.', 'Makati City', 'NCR', '1442');

INSERT INTO ROLE VALUES (ROLE_SEQ.nextval, 'Admin', 'Maintains the system database');
INSERT INTO ROLE VALUES (ROLE_SEQ.nextval, 'Doctor', 'User with medical license');
INSERT INTO ROLE VALUES (ROLE_SEQ.nextval, 'Patient', 'User undergoing treatment');
INSERT INTO ROLE VALUES (ROLE_SEQ.nextval, 'Encoder', 'Staff from the hospital who encodes user details');

INSERT INTO ACCESSTABLE VALUES (ACCESS_SEQ.nextval, 'Y', 'Y', 'Y', 'Y', 'Y');
INSERT INTO ACCESSTABLE VALUES (ACCESS_SEQ.nextval, 'N', 'N', 'N', 'N', 'N');

INSERT INTO HOSPITAL VALUES (HOSPITAL_SEQ.nextval, 'Philippine General Hospital', 2, null);
INSERT INTO HOSPITAL VALUES (HOSPITAL_SEQ.nextval, 'Manila Medical Center', 2, null);
INSERT INTO HOSPITAL VALUES (HOSPITAL_SEQ.nextval, 'Capitol Medical Center', 2, null);
INSERT INTO HOSPITAL VALUES (HOSPITAL_SEQ.nextval, 'Asian Hospital', 2, null);
INSERT INTO HOSPITAL VALUES (HOSPITAL_SEQ.nextval, 'St. Luke''s Global', 2, null);

INSERT INTO DEPARTMENT VALUES (DEPARTMENT_SEQ.nextval, 'Medicine');
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_SEQ.nextval, 'Surgery');
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_SEQ.nextval, 'Pathology');
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_SEQ.nextval, 'Radiology');
INSERT INTO DEPARTMENT VALUES (DEPARTMENT_SEQ.nextval, 'Family Medicine');

INSERT INTO SPECIALTY VALUES (SPECIALTY_SEQ.nextval, 'Surgical Oncology', 'Surgeon specialized in cancer operation');
INSERT INTO SPECIALTY VALUES (SPECIALTY_SEQ.nextval, 'Medical Oncology', 'Internist specialized in cancer medication');
INSERT INTO SPECIALTY VALUES (SPECIALTY_SEQ.nextval, 'Radiation Oncology', 'Doctor specialized in administering radiation medicine');
INSERT INTO SPECIALTY VALUES (SPECIALTY_SEQ.nextval, 'Pathology', 'Doctor specialized in identifying pathology from tissue samples');
INSERT INTO SPECIALTY VALUES (SPECIALTY_SEQ.nextval, 'Colorectal Surgery', 'Surgeon specialized in colon and rectal cancer');


INSERT INTO USERTABLE VALUES (0, 'Admin', 'Admin', 'Admin', 'cancersurveillancesystem@gmail.com',
                              'Adminpassword', 'Male', 'Single', TO_DATE('12/12/2024', 'mm/dd/yyyy'), 'Manila', 2, 9239929384, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Smith', 'James', 'Gomez', 'smithjames@gmail.com',
                              'smj022078', 'Male', 'Single', TO_DATE('02/20/1978', 'mm/dd/yyyy'), 'Manila', 2, 9239929384, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Johnson', 'Micheal', 'Phillips', 'jmphilips@gmail.com',
                              'jmp030489', 'Male', 'Single', TO_DATE('03/04/1989', 'mm/dd/yyyy'), 'Bicol', 2, 9281094839, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Williams', 'Robert', 'Evans', 'rewillams@gmail.com',
                              'wre051093', 'Male', 'Single', TO_DATE('05/10/1993', 'mm/dd/yyyy'), 'Manila', 2, 9170293544, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Brown', 'John', 'Turner', 'bjturner@gmail.com',
                              'bjt102000', 'Male', 'Single', TO_DATE('10/20/2000', 'mm/dd/yyyy'), 'Negros Occidental', 2, 9281984545, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Jones', 'David', 'Diaz', 'jddiaz@gmail.com',
                              'jdd043967', 'Male', 'Single', TO_DATE('04/29/1967', 'mm/dd/yyyy'), 'Manila', 2, 9180398474, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Garcia', 'William', 'Parker', 'gwparker@gmail.com',
                              'gwp030677', 'Male', 'Single', TO_DATE('03/06/1977', 'mm/dd/yyyy'), 'Laguna', 2, 9170927823, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Miller', 'Richard', 'Cruz', 'mrcruz@gmail.com',
                              'mrc101488', 'Male', 'Single', TO_DATE('10/14/1988', 'mm/dd/yyyy'), 'Cavite', 2, 9160293849, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Davis', 'Joseph', 'Edwards', 'jedavis@gmail.com',
                              'dje092369', 'Male', 'Single', TO_DATE('09/23/1969', 'mm/dd/yyyy'), 'Batangas', 2, 9270946748, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Rodriguez', 'Thomas', 'Morris', 'tmrodriguez@gmail.com',
                              'rtm072383', 'Male', 'Single', TO_DATE('07/23/1983', 'mm/dd/yyyy'), 'Manila', 2, 9180238943, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Martinez', 'Christopher', 'Collins', 'ccmartinez@gmail.com',
                              'mcc091973', 'Male', 'Single', TO_DATE('09/19/1973', 'mm/dd/yyyy'), 'Quezon', 2, 9170293437, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Fernandez', 'Charles', 'Reyes', 'crfernandez@gmail.com',
                              'fcr010587', 'Male', 'Single', TO_DATE('01/05/1987', 'mm/dd/yyyy'), 'Gensan', 2, 9140294623, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Lopez', 'Daniel', 'Stewart', 'sdLopez@gmail.com',
                              'lds040881', 'Male', 'Single', TO_DATE('04/08/1981', 'mm/dd/yyyy'), 'Iloilo', 2, 9176233647, 4, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Gonzalez', 'Matthew', 'Cook', 'mcgonzalez@gmail.com',
                              'gmc091075', 'Male', 'Single', TO_DATE('09/10/1975', 'mm/dd/yyyy'), 'Cebu', 2, 9179204738, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Wilson', 'Anthony', 'Rogers', 'arwilson@gmail.com',
                              'war101172', 'Male', 'Single', TO_DATE('10/11/1972', 'mm/dd/yyyy'), 'Manila', 2, 9182059283, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Anderson', 'Mark', 'Gutierrez', 'mganderson@gmail.com',
                              'amg052669', 'Male', 'Single', TO_DATE('05/26/1969', 'mm/dd/yyyy'), 'Ilocos Norte', 2, 9180293842, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Thomas', 'Olivia', 'Ortiz', 'ooThomas@gmail.com',
                              'too080284', 'Female', 'Single', TO_DATE('08/02/1984', 'mm/dd/yyyy'), 'Pangasinan', 2, 9162933478, 1, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Taylor', 'Emma', 'Morgan', 'emTaylor@gmail.com',
                              'tem090273', 'Female', 'Single', TO_DATE('09/02/1973', 'mm/dd/yyyy'), 'Tarlac', 2, 9279827383, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Moore', 'Charlotte', 'Cooper', 'ccmoore@gmail.com',
                              'mcc102975', 'Female', 'Single', TO_DATE('10/29/1975', 'mm/dd/yyyy'), 'Manila', 2, 9207665765, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Jackson', 'Amelia', 'Peterson', 'apjackson@gmail.com',
                              'jap091777', 'Female', 'Single', TO_DATE('09/17/1977', 'mm/dd/yyyy'), 'Bicol', 2, 9283443563, 1, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Martinez', 'Sophia', 'Bailey', 'sbmartinez@gmail.com',
                              'msb120964', 'Female', 'Single', TO_DATE('12/09/1964', 'mm/dd/yyyy'), 'Manila', 2, 9134887283, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Lee', 'Mia', 'Reed', 'mrlee@gmail.com',
                              'lmr111969', 'Female', 'Single', TO_DATE('11/19/1969', 'mm/dd/yyyy'), 'Negros Occidental', 2, 9187230837, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Perez', 'Isabella', 'Howard', 'ihperez@gmail.com',
                              'pih052362', 'Female', 'Single', TO_DATE('05/23/1962', 'mm/dd/yyyy'), 'Manila', 2, 9172093433, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Thompson', 'Ava', 'Ramos', 'avthompson@gmail.com',
                              'tar112675', 'Female', 'Single', TO_DATE('11/26/1975', 'mm/dd/yyyy'), 'Cebu', 2, 9177293024, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'White', 'Evelyn', 'Kim', 'ekwhite@gmail.com',
                              'wek020387', 'Female', 'Single', TO_DATE('02/03/1987', 'mm/dd/yyyy'), 'Cavite', 2, 9162034766, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Harris', 'Luna', 'Cox', 'lcharris@gmail.com',
                              'hlc010174', 'Female', 'Single', TO_DATE('01/01/1974', 'mm/dd/yyyy'), 'Batangas', 2, 9172893728, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Sanchez', 'Andrew', 'Ward', 'awsanchez@gmail.com',
                              'saw082981', 'Male', 'Single', TO_DATE('08/29/1981', 'mm/dd/yyyy'), 'Manila', 2, 9182936723, 2, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Clark', 'Paul', 'Richardson', 'prclark@gmail.com',
                              'cpr022865', 'Male', 'Single', TO_DATE('02/28/1965', 'mm/dd/yyyy'), 'Quezon', 2, 9482938911, 4, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Ramirez', 'Joshua', 'Watson', 'jwramirez@gmail.com',
                              'rjw071473', 'Male', 'Single', TO_DATE('07/14/1973', 'mm/dd/yyyy'), 'Gensan', 2, 9281726378, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Lewis', 'Patricia', 'Brooks', 'pblewis@gmail.com',
                              'lpb091967', 'Female', 'Single', TO_DATE('09/19/1967', 'mm/dd/yyyy'), 'Iloilo', 2, 9283744377, 3, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Robinson', 'Katrina', 'Chavez', 'kcrobinson@gmail.com',
                              'rkc101001', 'Female', 'Single', TO_DATE('10/10/2001', 'mm/dd/yyyy'), 'Cebu', 2, 9283498289, 3, 1, 'Y', 'Active', sysdate, sysdate, null);

INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 14, 1, 1, 2, null, '123040', TO_DATE('09/20/2028', 'mm/dd/yyyy'), 1);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 22, 1, 1, 2, null, '110324', TO_DATE('08/18/2029', 'mm/dd/yyyy'), 2);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 7, 3, 4, 3, null, '100450', TO_DATE('07/12/2027', 'mm/dd/yyyy'), 3);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 17, 3, 4, 3, null, '118945', TO_DATE('04/05/2025', 'mm/dd/yyyy'), 4);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 8, 2, 3, 4, null, '137028', TO_DATE('09/18/2028', 'mm/dd/yyyy'), 5);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 26, 5, 3, 4, null, '108934', TO_DATE('10/12/2026', 'mm/dd/yyyy'), 6);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 23, 3, 2, 1, null, '100982', TO_DATE('12/03/2027', 'mm/dd/yyyy'), 7);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 6, 4, 2, 1, null, '119034', TO_DATE('11/11/2027', 'mm/dd/yyyy'), 8);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 21, 2, 1, 2, null, '128934', TO_DATE('04/29/2028', 'mm/dd/yyyy'), 9);
INSERT INTO DOCTOR VALUES (DOCTOR_SEQ.nextval, 13, 3, 2, 5, null, '101997', TO_DATE('05/28/2027', 'mm/dd/yyyy'), 10);

INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 25, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 29, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 28, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 1, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 4, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 10, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 2, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 9, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 11, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 15, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 18, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 5, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 3, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 30, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 20, sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 24, sysdate, sysdate);

INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 1, 7, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 1, 3, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 2, 2, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 3, 9, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 4, 8, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 4, 2, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 5, 1, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 6, 2, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 7, 2, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 8, 10, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 8, 9, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 8, 4, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 9, 9, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 10, 2, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 11, 8, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 11, 4, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 12, 1, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 13, 7, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 14, 7, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 14, 4, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 15, 9, null);
INSERT INTO ONBOARD VALUES (ONBOARD_SEQ.nextval, 16, 8, null);

INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Colon');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Brain');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Urinary Bladder');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Gall Bladder');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Thyroid');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Uterine Cervix');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Liver');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Corpus Uteri');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Breast');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Blood');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Ovary');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Lung');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Esophagus');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Kidney');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Oral Cavity');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Stomach');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Pancreas');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Skin');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Nasopharynx');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Testis');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Prostate');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Rectum');
INSERT INTO BODYSITE VALUES (BODYSITE_SEQ.nextval, 'Others');

INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Death Certificates only', 'Non-Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Clinical Investigation', 'Non-Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Clinical Only', 'Non-Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Specific Tumor Markers', 'Non-Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Cytology or Hematology', 'Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Histology of Metastasis', 'Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Histology of Primary', 'Microscopic');
INSERT INTO BASIS VALUES (BASIS_SEQ.nextval, 'Unknown', 'Unknown');

INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 1, 412, 3, 'N', 0, 0, 12, 'Y', 'None', 'II', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 2, 285, 5, 'Y', 1, 3, 15, 'Y', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 4, 73, 4, 'N', 1, 1, 0, 'Y', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 5, 412, 3.5, 'Y', 0, 5, 18, 'Y', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 6, 105, 5.5, 'N', 0, 3, 10, 'Y', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 8, 285, 5, 'N', 1, 2, 13, 'N', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 11, 285, 5.5, 'N', 3, 5, 14, 'Y', 'None', 'IV', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 13, 530, 3.5, 'N', 1, 2, 12, 'Y', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 14, 512, 4, 'N', 1, 2, 11, 'Y', 'None', 'III', sysdate, sysdate, null);
INSERT INTO HISTOLOGY VALUES (HISTOLOGY_SEQ.nextval, 16, 105, 3.5, 'N', 2, 0, 0, 'N', 'None', 'II', sysdate, sysdate, null);

INSERT INTO METASTATICSITE VALUES (METASTATICSITE_SEQ.nextval, 7, 'N', 'N', 'Y', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'None', sysdate, sysdate, null);
INSERT INTO METASTATICSITE VALUES (METASTATICSITE_SEQ.nextval, 11, 'N', 'N', 'N', 'Y', 'N', 'N', 'N', 'N', 'N', 'N', 'None', sysdate, sysdate, null);
INSERT INTO METASTATICSITE VALUES (METASTATICSITE_SEQ.nextval, 12, 'N', 'N', 'Y', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'None', sysdate, sysdate, null);

INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 1, 'Y', 'N', 'N', 'N', 'Y', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 2, 'Y', 'Y', 'N', 'N', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 3, 'Y', 'Y', 'N', 'N', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 4, 'Y', 'N', 'N', 'N', 'Y', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 5, 'Y', 'Y', 'N', 'N', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 6, 'Y', 'N', 'N', 'N', 'Y', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 7, 'Y', 'N', 'N', 'Y', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 8, 'Y', 'N', 'N', 'N', 'Y', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 9, 'Y', 'Y', 'N', 'N', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 10, 'Y', 'N', 'N', 'N', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 11, 'Y', 'N', 'N', 'Y', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 12, 'Y', 'Y', 'N', 'Y', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 13, 'Y', 'N', 'N', 'N', 'Y', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 14, 'Y', 'N', 'N', 'N', 'Y', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 15, 'Y', 'Y', 'N', 'N', 'N', sysdate);
INSERT INTO DISEASESTATUS VALUES (DISEASESTATUS_SEQ.nextval, 16, 'Y', 'N', 'N', 'N', 'Y', sysdate);

INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 1, 9, TO_DATE('08/29/2020', 'MM/DD/YYYY'), 7, 'Left', 1, 'Localized', 3, 0, 'N', null, 0, 2, 0, 0, 0, 'II', 'Pathologic', 1, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 2, 16, TO_DATE('06/19/2016', 'MM/DD/YYYY'), 7, 'Right', 2, 'Direct_Extension', 5, 1, 'N', null, 0, 2, 3, 1, 0, 'III', 'Clinical', 2, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 3, 12, TO_DATE('09/23/2021', 'MM/DD/YYYY'), 2, 'Right', NULL, 'Direct_Extension', 5.1, 1, 'N', null, 0, 2, 3, 1, 0, 'III', 'Clinical', 3, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 4, 9, TO_DATE('10/02/2018', 'MM/DD/YYYY'), 7, 'Right', 3, 'Regional Lymph Node', 4, 2, 'N', null, 0, 2, 2, 2, 0, 'III', 'Pathologic', 4, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 5, 16, TO_DATE('09/28/2023', 'MM/DD/YYYY'), 7, 'Right', 4, 'Direct_Extension and Regional Lymph Node', 3.5, 2, 'N', null, 0, 2, 2, 2, 0, 'III', 'Pathologic', 5, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 6, 19, TO_DATE('02/03/2018', 'MM/DD/YYYY'), 7, 'Left', 5, 'Direct_Extension', 5.5, 1, 'N', null, 0, 2, 3, 1, 0, 'III', 'Clinical', 6, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 7, 12, TO_DATE('05/06/2020', 'MM/DD/YYYY'), 2, 'Bilateral', NULL, 'Distant Metastasis', 6, 2, 'Y', 1, 0, 2, 3, 2, 1, 'IV', 'Clinical', 7, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 8, 1, TO_DATE('09/24/2022', 'MM/DD/YYYY'), 7, 'Right', 6, 'Regional Lymph Node', 5, 1, 'N', null, 0, 2, 3, 1, 0, 'III', 'Pathologic', 8, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 9, 7, TO_DATE('08/19/2019', 'MM/DD/YYYY'), 2, 'Right', NULL, 'Direct_Extension', 6, 0, 'N', null, 0, 2, 3, 0, 0, 'II', 'Clinical', 9, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 10, 10, TO_DATE('10/19/2018', 'MM/DD/YYYY'), 5, 'Not Stated', NULL, 'Regional Lymph Node', 5, 1, 'N', null, 0, 2, 3, 1, 0, 'II', 'Clinical', 10, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 11, 16, TO_DATE('11/19/2023', 'MM/DD/YYYY'), 7, 'Right', 7, 'Distant Metastasis', 5.5, 2, 'Y', 2, 0, 2, 3, 2, 1, 'IV', 'Clinical', 11, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 12, 12, TO_DATE('12/02/2018', 'MM/DD/YYYY'), 2, 'Right', NULL, 'Distant Metastasis', 3, 2, 'Y', 3, 0, 2, 2, 2, 1, 'IV', 'Clinical', 12, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 13, 5, TO_DATE('03/04/2019', 'MM/DD/YYYY'), 5, 'Right', 8, 'Regional Lymph Node', 3.5, 1, 'N', null, 0, 2, 2, 1, 0, 'III', 'Clinical', 13, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 14, 9, TO_DATE('02/02/2017', 'MM/DD/YYYY'), 7, 'Left', 9, 'Regional Lymph Node', 4, 1, 'N', null, 0, 2, 2, 1, 0, 'III', 'Clinical', 14, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 15, 13, TO_DATE('12/30/2017', 'MM/DD/YYYY'), 7, 'Right', NULL, 'Regional Lymph Node', 4, 1, 'N', null, 0, 2, 2, 1, 0, 'III', 'Clinical', 15, sysdate, sysdate, null);
INSERT INTO DISEASE VALUES (DISEASE_SEQ.nextval, 16, 15, TO_DATE('03/17/2019', 'MM/DD/YYYY'), 7, 'Left', 10, 'In-Situ', 3.5, 0, 'N', null, 0, 2, 2, 0, 0, 'II', 'Clinical', 16, sysdate, sysdate, null);

INSERT INTO NOTIFICATIONSTATUS (NOTIFSTATUS_ID, NOTIFSTATUS_NAME)
VALUES (NOTIFICATIONSTATUS_SEQ.NEXTVAL, 'Read');
INSERT INTO NOTIFICATIONSTATUS (NOTIFSTATUS_ID, NOTIFSTATUS_NAME)
VALUES (NOTIFICATIONSTATUS_SEQ.NEXTVAL, 'Unread');

INSERT INTO BODYSITE(BODYSITE_ID, BODYSITE_NAME) VALUES (BODYSITE_SEQ.nextval, 'Negative') ;
INSERT INTO BODYSITE(BODYSITE_ID, BODYSITE_NAME) VALUES (BODYSITE_SEQ.nextval, 'All') ;


INSERT INTO SYMPTOMCATEGORY(SYMPTOMCATEGORY_ID, SYMPTOM_CATEGORY) VALUES (SYMPTOMCATEGORY_SEQ.nextval, 'Local Symptom');
INSERT INTO SYMPTOMCATEGORY(SYMPTOMCATEGORY_ID, SYMPTOM_CATEGORY) VALUES (SYMPTOMCATEGORY_SEQ.nextval, 'Systemic Symptom');
INSERT INTO SYMPTOMCATEGORY(SYMPTOMCATEGORY_ID, SYMPTOM_CATEGORY) VALUES (SYMPTOMCATEGORY_SEQ.nextval, 'Quality of Life');
INSERT INTO SYMPTOMCATEGORY(SYMPTOMCATEGORY_ID, SYMPTOM_CATEGORY) VALUES (SYMPTOMCATEGORY_SEQ.nextval, 'Treatment Side Effect');

INSERT INTO NOTIFICATIONTYPE (NOTIFTYPE_ID, NOTIFICATIONTYPE_NAME) VALUES (1, 'Symptom Survey');
INSERT INTO NOTIFICATIONTYPE (NOTIFTYPE_ID, NOTIFICATIONTYPE_NAME) VALUES (2, 'Laboratory Submission');
INSERT INTO NOTIFICATIONTYPE (NOTIFTYPE_ID, NOTIFICATIONTYPE_NAME) VALUES (3, 'Checkup Scheduling');
INSERT INTO NOTIFICATIONTYPE (NOTIFTYPE_ID, NOTIFICATIONTYPE_NAME) VALUES (4, 'Treatment Info Update');


INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,24,'No new local symptom',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,24,'No new systemic symptom',NULL,2,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,24,'Good function in daily living',NULL,3,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,24,'No observed side effects',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Breast pain',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Arm swelling',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Skin thickening',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Breast mass',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Nipple discharge',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Bone pain',NULL,2,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Fatigue',NULL,2,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Weight loss',NULL,2,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Shortness of breath',NULL,2,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Persistent cough',NULL,2,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Abdominal pain',NULL,2,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Jaundice',NULL,2,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Personality or behavioral change',NULL,2,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Depression',NULL,3,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,25,'Anxiety',NULL,3,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Arms and legs numbness',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,9,'Easy fatiguability',NULL,4,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Neck mass',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Hoarseness',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Voice changes',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Difficulty swallowing (dysphagia)',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Neck tightness',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Cold intolerance',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Constipation',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Dry skin and hair',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Memory or concentration issues',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Heart palpitation',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,5,'Tremors',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Sensation food stuck after swallowing',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Pain on swallowing',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Regurgitation of food',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Chest pain',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Voice changes',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Chronic cough',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Frequent hiccups',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Muscle weakness',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Tingling of hands and feet',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Balance problem in walking',NULL,4,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Memory loss concentration problem',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Shortness of breath',NULL,4,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Recurrent lips ulcer',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,13,'Sore tongue',NULL,4,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Upper abdominal pain',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Nausea',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Vomiting after food intake',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Early satiety',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Heartburn',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Difficulty swallowing',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Black stools',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,16,'Vomiting blood',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Abdominal pain',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Abdominal mass',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Smaller caliber stool',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Bloody stools',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Incomplete bowel evacuation',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Vomiting',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Bloating',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Severe constipation',NULL,1,NULL,NULL);
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Abdominal enlargement',NULL,1,NULL,'1');
INSERT INTO SYMPTOMSURVEY(SYMPTOMSURVEY_ID,cancer_type,symptom_name,symptom_filipino,symptom_category,symptom_medicalTerm,symptom_alertable) VALUES (SYMPTOMSURVEY_SEQ.nextval,1,'Watery stools',NULL,1,NULL,'1');


INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,9,'Mammogram',12,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,9,'MRI breast',0,'Imaging','High-risk',0,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,9,'MRI breast',0,'Imaging','Genetic mutation',0,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,9,'Bone density testing',0,'Imaging','Aromatase inhibitor',0,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,9,'2D Echo',0,'Imaging','Post-treatment  trastuzumab',0,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,9,'2D Echo',0,'Imaging','Doxorubicin post-treatment',0,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'Thyroglobulin',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'Neck ultrasound',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'Thyroid stimulating hormone',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'Free T4',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'RAI Scan',12,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'Bone density testing',0,'Imaging','TSH suppression medication',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,5,'12L-ECG',0,'Cardiac Test','Hyperthyroidism Symptom',0,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'Esophagogastroduodenoscopy',6,'Endoscopy','Routine',24,'Gastroenterologist');
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'Chest CT scan with IV contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'CT scan abdomen and chest with contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'Nutritional assessment',6,'Clinical Test','Routine',24,'Nutritionist');
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'Complete blood count (CBC)',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'Creatinine',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'AST',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,13,'ALT',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'CT scan abdomen and chest with contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'cbc',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'AST',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'ALT',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'Chest CT with IV contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'Abdominopelvic CT with oral and IV contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,16,'esophagogastroduodenoscopyE',6,'Endoscopy','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'Abdominopelvic CT with oral and IV contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'Chest CT with IV contrast',6,'Imaging','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'Carcinoembryonic Antigen (CEA)',3,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'Complete blood count (CBC)',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'AST',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'ALT',6,'Blood Testing','Routine',24,NULL);
INSERT INTO WORKUP(WORKUP_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (WORKUP_SEQ.nextval,1,'Colonoscopy',12,'Endoscopy','Routine',24,'Gastroenterologist');

--
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (1,9,1,12,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (2,9,2,0,'imaging','high-risk',0,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (3,9,2,0,'imaging','genetic mutation',0,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (4,9,3,0,'imaging','aromatase inhibitor',0,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (5,9,4,0,'imaging','post-treatment  trastuzumab',0,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (6,9,4,0,'imaging','doxorubicin post-treatment',0,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (7,5,5,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (8,5,6,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (9,5,7,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (10,5,8,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (11,5,9,12,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (12,5,10,0,'imaging','TSH suppression medication',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (13,5,11,0,'cardiac test','hyperthyroidism symptom',0,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (14,13,12,6,'endoscopy','routine',24,'gastroenterologist');
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (15,13,13,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (16,13,14,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (17,13,15,6,'clinicalTest','routine',24,'nutritionist');
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (18,13,16,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (19,13,17,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (20,13,18,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (21,13,19,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (22,16,14,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (23,16,16,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (24,16,18,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (25,16,19,6,'blood_testing','routine', 24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (26,16,13,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (27,16,21,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (28,16,12,6,'endoscopy','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (29,1,21,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (30,1,14,6,'imaging','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (31,1,22,3,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (32,1,16,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (33,1,18,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (34,1,19,6,'blood_testing','routine',24,NULL);
-- INSERT INTO LABMONITOR(LABMONITOR_ID,cancer_type,workup_name,workup_frequency,workup_type,workup_indication,workup_duration,workup_referral) VALUES (35,1,23,12,'endosocpy','routine',24,'gastroenterology');

insert into CHECKUPSTATUS(checkupstatus_id, notifstatus_name) VALUES (CHECKUPSTATUS_SEQ.nextval, 'Request');
insert into CHECKUPSTATUS(checkupstatus_id, notifstatus_name) VALUES (CHECKUPSTATUS_SEQ.nextval, 'Confirmed');
insert into CHECKUPSTATUS(checkupstatus_id, notifstatus_name) VALUES (CHECKUPSTATUS_SEQ.nextval, 'Done');
insert into CHECKUPSTATUS(checkupstatus_id, notifstatus_name) VALUES (CHECKUPSTATUS_SEQ.nextval, 'Cancelled');

insert into RAD_DETAILS values  (RAD_DETAILS_SEQ.nextval, 'TEST1');
INSERT INTO CHEMOPROTOCOL (CHEMOPROTOCOL_ID, CHEMODRUGS, CHEMODOSAGE, CHEMONOCYCLE, CHEMODILUENT)
VALUES (CHEMOPROTOCOL_SEQ.NEXTVAL, 'Doxorubicin', 50, 6, 'Saline');
INSERT INTO CHEMOPROTOCOL (CHEMOPROTOCOL_ID, CHEMODRUGS, CHEMODOSAGE, CHEMONOCYCLE, CHEMODILUENT)
VALUES (CHEMOPROTOCOL_SEQ.NEXTVAL, 'Cisplatin', 75, 4, 'Water');
INSERT INTO CHEMOPROTOCOL (CHEMOPROTOCOL_ID, CHEMODRUGS, CHEMODOSAGE, CHEMONOCYCLE, CHEMODILUENT)
VALUES (CHEMOPROTOCOL_SEQ.NEXTVAL, 'Paclitaxel', 100, 6, 'D5W');

COMMIT;

SELECT * FROM USERTABLE;