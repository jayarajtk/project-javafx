# How to run

This project depends on `javafx_registration` database running in mysql.

  - Make sure you have a database `javafx_registration`
  - Configure the database user and password in `application.properties` in resources folder or cfg folder (create new in the application path). Default username/password is root/root
  - Install [maven] `mvn clean install` (https://maven.apache.org/)
  - RUN `tables.sql` in that database for seeding `customer` table (only if necessary)
  - execute run.sh *(linux/mac)* or run.bat*(window)*

![image](https://user-images.githubusercontent.com/20223097/211223160-e3b4ba7a-e4ce-4f5f-b2b0-524473ab72c2.png)

Double clicking on the cells make them editable. 'Enter' will save your new data.
