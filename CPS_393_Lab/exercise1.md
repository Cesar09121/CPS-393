C:\sqlite>sqlite3
SQLite version 3.51.2 2026-01-09 17:27:48
Enter ".help" for usage hints.
Connected to a transient in-memory database.
Use ".open FILENAME" to reopen on a persistent database.
sqlite> .mode csv
sqlite> .headers on
sqlite> CREATE TABLE bmi_info("lastName" TEXT, "firstName" TEXT, "height" REAL, "weight" REAL);
sqlite> .import namesWithHeightWeight.csv bmi_info (Read csv file)
sqlite>

Execute SQL query to list first 10 table entries

sqlite> SELECT \* FROM bmi_info LIMIT 10;
lastName,firstName,height,weight
"LAST NAME","FIRST NAME",HEIGHT(in.),WEIGHT(lbs.)
Abbott," Bradley J.",58.0,136.2
Abbott," Brent U.",60.0,160.1
Acevedo," Ayanna U.",71.0,143.2
Acevedo," Blythe M.",65.0,148.7
Acevedo," Dawn E.",71.0,124.0
Acevedo," Glenna A.",68.0,165.2
Acevedo," Hyacinth V.",59.0,160.4
Acevedo," Keiko N.",64.0,172.1
Acevedo," Xyla I.",66.0,121.1

Save the data into a file-based database file
sqlite> .save bmiInfo.db
sqlite>

sqlite> .open bmiInfo.db
sqlite> .schema (schema shows the table with its attributes)
CREATE TABLE bmi_info("lastName" TEXT, "firstName" TEXT, "height" REAL, "weight" REAL);

sqlite> SELECT _ FROM bmi_info LIMIT 10;
LAST NAME|FIRST NAME|HEIGHT(in.)|WEIGHT(lbs.)
Abbott| Bradley J.|58.0|136.2
Abbott| Brent U.|60.0|160.1
Acevedo| Ayanna U.|71.0|143.2
Acevedo| Blythe M.|65.0|148.7
Acevedo| Dawn E.|71.0|124.0
Acevedo| Glenna A.|68.0|165.2
Acevedo| Hyacinth V.|59.0|160.4
Acevedo| Keiko N.|64.0|172.1
Acevedo| Xyla I.|66.0|121.1
sqlite> SELECT _ FROM bmi_info LIMIT 10;
