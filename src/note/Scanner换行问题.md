**问题：**在使用Scanner.nextInt()或Scanner.next()时，会读取到”\n”之前结束，这个”\n”会被下一个扫描器接收，如Scanner.nextLine ()，导致直接跳过此步；

**解决办法：**在下一步输入之前使用Scanner.nextLine();吸收多余的”\n”
