/* Finding TOP 3 Users based on the numer of review given */
val dfReader02 = spark.read
val t3custDF01 = dfReader02.option("header","true").csv("rating-csv.data")
val t3custDF02 = t3custDF01.select(t3custDF01.col("cid"))
val groupedData = t3custDF02.groupBy("cid").count()
val sortedDatadesc = groupedData.orderBy(groupedData.col("count").desc)
val sortedDataasc = groupedData.orderBy(groupedData.col("count").asc)
sortedDatadesc.show(3)
sortedDataasc.show(10)

