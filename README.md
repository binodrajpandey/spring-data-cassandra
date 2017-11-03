Before you run the project you have to do the following steps.
1. Install cassandra on any machine
2. Create keyspaces
3. create table using following commands
CREATE TABLE IF NOT EXISTS  book (
    isbn UUID,
    title varchar,
    publisher varchar,
    tags list<text>,
    primary key((isbn))
);
4. Open cassandraConfig.java file and edit name of keyspaces, contanct point, cassandra credentials.
