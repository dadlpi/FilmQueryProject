# FilmQueryProject
The intended purpose of this project is to show the ability to connect to a SQL database using JDBC connectivity and write a Java based command line application that takes in search parameters in a user friendly manner and then prepares SQL queries, opens a connection to the Database, executes the query and responds with the query results. If the query responded with a result set then the result set is used to created Java objects to be displayed on screen to the user as the last step. 

# Description
The functionality of this application is meant to query the Database for film names by either the Film ID number or some search string, that is found in the either the title of the film or in the film description in the database. The user experience should abstract the need to know anything about the Database relational tables and their design.

# Technologies Used
1) Java OOP
2) Java JDBC libraries
3) Eclipse IDE
4) MySQL Database

# Lessons Learned
Besides learning how to connect to a Database, the main lessons learned here was that I could utilize multiple methods and queries to construct multiple methods and then combine the methods results. For example, when the user story required adding the movies cast as a List to the Film object, creating the listing of cast members ended up being stand alone method that I used to add to the film object. Furthermore, there is portability there since we could utilize the cast member method in the future since it is inside the DatabaseAccessOject (DAO). And this was a great exercise in creating objects that have lists as part of them as well as passing lists across objects and methods.
