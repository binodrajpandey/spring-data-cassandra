Before you run the project you have to do the following steps.
1. Install cassandra on any machine
2. Create keyspaces
3. create table using following commands
CREATE TABLE IF NOT EXISTS  book (
    isbn UUID,
    title varchar,
    publisher varchar,
    tags list<text>,
    primary key((publisher,title),isbn)
);
where publisher and title are partition key and isbn is cluster key. We have used composite partitionkey to use multiple partition.
you can insert test data to verify:
INSERT INTO book (isbn, publisher ,title, tags) VALUES ( now(), 'binod','long journey',['tag1','tag2']) using ttl 100;

4. Open cassandraConfig.java file and edit name of keyspaces, contanct point, cassandra credentials.
5. build the project and then run it.
6. run the test for CRUD operation.
