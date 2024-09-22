INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.nextval, 100, 'Lagdameo st.', 'Valenzuela City', 'NCR', '1440');
INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.nextval, 101, 'Kapitan Rado st.', 'Manila', 'NCR', '1441');
INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.nextval, 102, 'General De Leon st.', 'Makati City', 'NCR', '1442');

INSERT INTO ROLE VALUES (ROLE_SEQ.nextval, 'Doctor', 'Prevent, diagnose, care for and treat patients with illness, disease and injury and to maintain physical and mental health');
INSERT INTO ROLE VALUES (ROLE_SEQ.nextval, 'Patient', 'Receiving or registered to receive medical treatment');

INSERT INTO ACCESSTABLE VALUES (ACCESS_SEQ.nextval, 'Y', 'Y', 'Y', 'Y', 'Y');
INSERT INTO ACCESSTABLE VALUES (ACCESS_SEQ.nextval, 'N', 'Y', 'Y', 'N', 'N');

INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Gomez', 'Ron Brylle', 'San Gabriel', 'rsgomez1@up.edu.ph',
                              'pw', 'Male', 'Single', TO_DATE('11-09-2002', 'mm-dd-yyyy'), 'Caloocan City', 1, 1, 1, 'Y', 'Active', sysdate, sysdate, null);
INSERT INTO USERTABLE VALUES (USER_SEQ.nextval, 'Callang', 'Nathan', 'B', 'nbcallang@up.edu.ph',
                              'pw', 'Male', 'Single', TO_DATE('08-07-2003', 'mm-dd-yyyy'), 'Oman', 2, 2, 2, 'Y', 'Active', sysdate, sysdate, 1);

SELECT * FROM USERTABLE;
commit;