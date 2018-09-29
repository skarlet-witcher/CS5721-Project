# CS5721-Project
## Prerequsite
Make you installed **MySQL** and **java IDE** such as Eclipse on your PC.
## Installation
Execute the **db_schema.sql** in your local database first. Then, import the project folder into your java IDE. <br>
After that, proceed to **hibernate.cfg.xml**. Change the following paratmeters which is selected in blue. <br><br>
<img width="626" alt="_20180926214727" src="https://user-images.githubusercontent.com/26427743/46108345-c8736280-c1d5-11e8-8a15-2fd920ce4e82.png"> <br><br>
```
<property name="connection.url">jdbc:mysql://**your local address**/**Name of your schema (cs5721proj)**</property>
<property name="connection.username">**Your username**</property>
<property name="connection.password">**Your password**</property>
```
