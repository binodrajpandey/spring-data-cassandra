### Before you run the project you have to do the following steps.
1. Install cassandra on any machine
2. Create keyspaces using following command:

`create keyspace binod_keyspace with replication ={'class':'SimpleStrategy','replication_factor':1} ;`
3.Now,test if the keyspace is created using command:

`describe keyspaces;`

you should see the keyspace name binod_keyspace.

4. Use it with the command:

`use binod_keyspace;`

5. create table using following command:
```
CREATE TABLE IF NOT EXISTS book (
isbn UUID,
title varchar,
publisher varchar,
tags list<text>, 
primary key((publisher,title),isbn) );
```
where publisher and title are partition key and isbn is cluster key. We have used composite partitionkey to use multiple partitions.

6. Now test using command:
`describe tables;`

7.you can insert test data to verify: </br>
`INSERT INTO book (isbn, publisher ,title, tags) VALUES ( now(), 'binod','long journey',['tag1','tag2']) using ttl 100;`
8. Open cassandraConfig.java file and edit name of keyspaces, contanct point, cassandra credentials.</br>
9. build the project and then run it.
10. run the test for CRUD operation.
