@REM 他默认在执行的目录执行
thrift --gen java test.thrift

thrift -help
@REM -o dir      Set the output directory for gen-* packages

@REM -r 表示可以在引用文件时，引用文件也生成代码（include 对应的引入
thrift -r --gen java