##### 为什么sb.toString().equals(reverse.toString())的结果一定为true？

```java
StringBuffer sb = new StringBuffer();
StringBuffer reverse = sb.reverse();
//return结果始终一定为true
return sb.toString().equals(reverse.toString());
```

为什么会一定为true？

reverse()方法也改变了sb本身，这个方法的返回对象也是sb本身，所以reverse对象就完完全全等于sb。

其实所有StringBuffer的方法都会改变其实例的本身，而且返回值也普遍都是其实例本身。

为了更清楚的理解，给出下面例子：

```java
StringBuffer sb = new StringBuffer("abcd");
System.out.println(sb);
StringBuffer reverse = sb.reverse();
System.out.println(sb);
System.out.println(reverse);
```

输出结果：

abcd
dcba
dcba