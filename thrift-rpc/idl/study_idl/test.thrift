# include，他的作用是用作 idl 的模块化编程的
include "include_test.thrift"
# 单行注释

// 单行注释

/**
* 多行注释
**/


// 指定生成好的代码包，其中 namespace 是固定的，后面的是语言，可以是Java 也可以是其他的，后面的是包路径
namespace java com.rpc.thrift
namespace go com.rpc.thrift
namespace py com.rpc.thrift

// 数据类型
# 基本数据类型
# i8     有符号的 8 位整数 对应 Java byte
# i16    有符号的 16 位整数    对应 Java short
# i32    有符号的 32 位整数    对应 Java int
# i64    有符号的 64 位整数    对应 Java long
# double 64 位的浮点数        对应 Java 的 double
# bool   布尔类型             对应 Java 的 boolean
# string 字符串              对应  Java 的 String 可以使用单引号也可以是双引号，只能使用 UTF-8


# 集合类型
# list<T>        有序可重复数组   对应 Java 的 java.util.List
# set<T>         无需不可重复     对应 Java 的 java.util.Set
# map<K, V>      k-v           对应 Java 的 java.util.Map

# 集合举例
# 备注，只有常量才可以定义在外面，但是如果是结构体内的定义是可以不是 const 的
const map<i32, string> sex = {1: 'female', 2: 'male'}
const list<string> skus = ['1', '2', '3']
const set<i8> ages = [];

# 自定义类型 【结构体】
# struct 是不可以继承的，字段的分割可以使用,或者;
# 结构体的每一个字段都要做编号，编号的起始必须是 1
# 语法为 编号 冒号 [optional] [required] 类型 命名
# optional 代表可选的，默认给每一个成员都会加入这个关键字，可选的含义就是如果这个值没有值就不做序列化，如果加了就会做序列化操作
# required 这个也是可选的，这个代表这个字段是必须要做序列化，如果没有值也会做序列化的操作
struct User {
    1: required i32 id,
    2: optional string name = 'xl-9527',
    3: i32 age,
    4: list<string> hobby = ['codeing', '足球', '篮球'],
    5: string school
}

# 枚举类型， 枚举是不支持嵌套的，这里等于后面如果是数字，，虽然在 Thrift 中可以有 i8 ~ i64 但是这里默认是 i32
enum SEASON {
    SPRING = 1,
    SUMMERT = 2,
}

# 异常的定义，一般我们都只会定义两个异常属性
exception RuntimeException {
    1: i8 code,
    2: string errorMsg
}

# service 这里比较重要的第二个就是 service 的定义，他的定义类似于 Java 中的接口
service UserService {
    bool loginIn(1:string username, 2: string password) throws (1:RuntimeException e);
    void register(1: User user); // 这里的 User 起始对应一个 struct
    // oneway 他表示客户端不会等待服务端响应直接结束请求，类似于 Java 的异步操作，并且他只能配合 void 使用
    oneway void loginOut();
}

# 服务是继承的
service Parent {
    void pMethod();
}


service Child extends Parent{
    void cMethod()
}

struct IncludeTest {
       1:include_test.IncludeChild child
}
