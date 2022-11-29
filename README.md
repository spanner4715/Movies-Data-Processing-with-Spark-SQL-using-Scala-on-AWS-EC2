# Movies-Data-Processing-with-Spark-SQL-using-Scala-on-AWS-EC2
## Architecture
![image](https://user-images.githubusercontent.com/103509243/204367798-5df2ad58-ed59-43a5-a1d6-82b0fd75e64b.png)

## Approach  
(1) Create an AWS EC2 instance and launch it  

(2) Create docker images by using docker-compose file, running on EC2 machine via ssh  

(3) Load data from local machine into Spark container via EC2 machine  

(4) Perform analysis on Movie and Ratings data in Apache Spark by using Scala

## Analysis  
### (1) Top 10 movies Analysis (RDD)  
![image](https://user-images.githubusercontent.com/103509243/204380851-39de726b-3fd8-4853-87bf-f07ed642ac84.png)

### (2) Top 10 movies Analysis (Spark SQL)  
![image](https://user-images.githubusercontent.com/103509243/204414852-a7b3780c-9790-40b3-aa6e-4ed9b31e34fa.png)

### (3) Top 3 reviewers according to the amount of customerid (Spark SQL)  
![image](https://user-images.githubusercontent.com/103509243/204416923-601d13f0-d68e-4023-b210-db134b0f2e08.png)



