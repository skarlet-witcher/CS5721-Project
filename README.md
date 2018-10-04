# CS5721-Project
## Prerequsite
Make you installed **MySQL** and **java IDE** such as Eclipse on your PC.
## Installation
Execute the **db_schema.sql** in your local database first. Then, import the project folder into your java IDE. <br>
After that, proceed to **hibernate.cfg.xml**. Change the following paratmeters which is selected in blue. <br><br>
<img width="700" alt="_20180929205057" src="https://user-images.githubusercontent.com/26427743/46249932-6317af80-c429-11e8-98fc-2a378119f5f5.png"><br><br>
```
<property name="connection.url">jdbc:mysql://**your local address**/**Name of your schema (cs5721proj)**</property>
<property name="connection.username">**Your username**</property>
<property name="connection.password">**Your password**</property>
```
