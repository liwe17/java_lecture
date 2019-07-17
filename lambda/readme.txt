1.Lambda:In programming languages such as Lisp,Python and Ruby lambda is an operator userd to denote anonymous functions
or closures,following the usage of lambda calculus;

2.为何需要lambda表达式:
    1>在Java中,我们无法将函数作为参数传递给一个方法,也无法声明返回一个函数的方法.
    2>在JavaScript中,函数参数是一个函数,返回值是另一个函数的情况是非常常见的;JavaScript是一门非常典型的函数式语言.

3.关于函数式接口:
    1>如果一个接口只有一个抽象方法,那么该接口是一个函数式接口.
    2>如果我们在某个接口上声明了@FunctionalInterface注解,那么编译器就会按照函数式接口的定义要求该接口.
    3>如果某个接口只有一个抽象方法,但我们并没有给该接口声明@FuncationalInterface注解,那么编译器依旧会将该接口看作函数式接口.
    4>如果该接口有Object的方法,并且除Object的方法外只有一个抽象方法,那么它仍然是一个函数式接口.

4.Lambda表达式的作用:
    1>Lambda表达式为Java添加缺失的函数式编程特性,使我们将函数当作一等公民看待.
    2>在将函数作为一等公民的的语言中(javascript),Lambda表达式的类型是函数,但在Java中,Lambda表达式是对象,他们必须依附于一类特
    别的对象类型--函数式接口(FunctionalInterface).

5.Java Lambda 基本语法
    基本语法:(arument)->(body)
    比如:
        (arg1,arg2...)->{body}
        (type1 arg1,type2 arg2...)->{body}
    实例:
        (int a,int b)->{return a+b;}
        ()->System.out.println("Hello World");
        (String s)->{System.out.println(s);}
        ()->42
        ()->{return 3.1415}