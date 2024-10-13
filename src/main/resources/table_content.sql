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
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 1,  sysdate, sysdate);
INSERT INTO PATIENT VALUES (PATIENT_SEQ.nextval, 4,  sysdate, sysdate);
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

COMMIT;

SELECT * FROM USERTABLE;
