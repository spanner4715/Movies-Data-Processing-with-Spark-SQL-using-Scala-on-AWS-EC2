/* Finding Top 10 movies using RDD */
    # Run the spark-shell: ./bin/spark-shell

    val t10rdd01 = sc.textFile("ratings.data")
    t10rdd01.foreach(println)
    val t10rdd02 = t10rdd01.map(x => (x.split("\t")(1).toInt, (x.split("\t")(2).toFloat,1))) # Fetch index1(movieID),index2(rating), assign '1' as one customer's rating
    t10rdd02.take(5)
    val t10rdd03 = t10rdd02.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2)) #Sum up rating score and the amount 
    val t10rddavg = t10rdd03.mapValues{ case (sum, count) =>  sum / count }
    t10rddavg.take(5)
    val t10movierdd01 = sc.textFile("")
    val t10movierdd02 = t10movierdd01.map(x => (x.split(";")(0).toInt, x.split(";")(1).toString))
    t10movierdd02.take(5)
    val joinrdd = t10movierdd02.join(t10rddavg)
    joinrdd.take(5)
    val t10joinrdd02 = joinrdd.map(x => (x._2._1, x._2._2)) #Filter out movieID
    t10joinrdd02.take(5)
    val swaprdd = t10joinrdd02.map( x => (x._2, x._1) ) #Swap the order
    val sortedrdd = swaprdd.sortByKey(false)
    val top10movies = sortedrdd.take(10)
    top10movies.foreach(println)

