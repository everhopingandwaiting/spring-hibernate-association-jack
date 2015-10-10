DROP TABLE IF EXISTS NUMBERS;
CREATE TABLE NUMBERS (
  ID     INT     NOT NULL AUTO_INCREMENT,
  PREFIX CHAR(7) NOT NULL,
  SUFFIX CHAR(3) NOT NULL,
  PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS CLASSES;
CREATE TABLE CLASSES (
  ID   INT         NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20) NOT NULL,
  PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS STUDENTS;
CREATE TABLE STUDENTS (
  ID        INT         NOT NULL AUTO_INCREMENT,
  NAME      VARCHAR(20) NOT NULL,
  NUMBER_ID INT         NOT NULL,
  CLASS_ID  INT         NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_NUMBER FOREIGN KEY (NUMBER_ID) REFERENCES NUMBERS (ID),
  CONSTRAINT FK_CLASS FOREIGN KEY (CLASS_ID) REFERENCES CLASSES (ID)
);

DROP TABLE IF EXISTS COURSES;
CREATE TABLE COURSES (
  ID   INT         NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(30) NOT NULL,
  PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS STUDENTS_COURSES;
CREATE TABLE STUDENTS_COURSES (
  STUDENT_ID INT NOT NULL,
  COURSE_ID  INT NOT NULL,
  PRIMARY KEY (STUDENT_ID, COURSE_ID),
  CONSTRAINT FK_STUDENT FOREIGN KEY (STUDENT_ID) REFERENCES STUDENTS (ID),
  CONSTRAINT FK_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSES (ID)
);

