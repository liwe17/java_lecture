Stream流
    Collection提供了新的stream()方法,流不存储值,通过管道的方式获取值,本质是函数式,对流操作会产生一个结果,但不会修改底层的数据源,
集合可以作为流的底层数据源,延迟查找,很多流操作(过滤,映射,排序等)都可以延迟实现.
1.流由3部分组成
    1>源
    2>零个或多个中间操作
    3>终止操作
2.流操作的分类
    1>惰性求值
    2>及早求值

 集合关注的是数据与数据存储本身
 流关注的是对数据的计算

 流和迭代器类似的一点是:流无法重复消费和使用

 中间操作都会返回一个stream对象
 终止操作责不会返回Stream类型,可能不返回值,也可能返回其他类型的单个值.+