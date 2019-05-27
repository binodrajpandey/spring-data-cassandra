### Before you run the project you have to do the following steps.

1. Install cassandra on any machine
2. Create keyspaces using following command:</br>
 `create keyspace binod_keyspace with replication ={'class':'SimpleStrategy','replication_factor':1} ;`</br>
3. Now,test if the keyspace is created using command: </br>
	`describe keyspaces;`</br>
	you should see the keyspace name binod_keyspace.

4. Create a table.

  ```
  use binod_keyspace;
    CREATE TABLE IF NOT EXISTS book (
    isbn UUID,
    title varchar,
    publisher varchar,
    tags list<text>, 
    primary key((publisher,title),isbn) );
   ```
   
where publisher and title are partition key and isbn is cluster key. We have used composite partitionkey to use multiple partitions.</br>
5. you can insert test data to verify: </br>
   
    
    describe tables;
    INSERT INTO book (isbn, publisher ,title, tags) VALUES ( now(), 'binod','long journey',['tag1','tag2']) using ttl 100;
    
6. Open application.yml file and edit configurations as per your requirement.
7. Run the project and run the test.
