/* Finding Top 10 movies using SPARK SQL */
    val dfReader01 = spark.read
    val t10DF01 = dfReader01.option("header","true").csv("rating-csv.data") # Create Data frame
    t10DF01.printSchema
    val t10DF02 = t10DF01.select(t10DF01.col("mid"), t10DF01.col("rating").cast("double")) #cast: convert a value to another data type
    t10DF02.show(3)
    val t10ratingsAvg = t10DF02.groupBy(t10DF02.col("mid")).avg("rating")
    val t10avgRename = t10ratingsAvg.select(t10ratingsAvg.col("mid"), t10ratingsAvg.col("avg(rating)").as("Avg_Rating"))
    t10avgRename.show(3)
    val t10AvgSorted = t10avgRename.orderBy(t10avgRename.col("Avg_Rating").desc).limit(10)
    t10AvgSorted.show
    val t10movieDF01 = dfReader01.option("header","true").csv("movies-csv.item")
    val t10movieDF02 = t10movieDF01.select(t10movieDF01.col("mid"), t10movieDF01.col("title"))
    t10movieDF02.show(5)
    val joinedDF = t10AvgSorted.join(t10movieDF02, t10AvgSorted.col("mid").equalTo(t10movieDF02.col("mid")), "inner")
    joinedDF.show
    val Top10Data = joinedDF.select(joinedDF.col("title"), joinedDF.col("Avg_Rating")).orderBy(joinedDF.col("Avg_Rating").desc)
    Top10Data.show
    val top10 = Top10Data.show(10)
