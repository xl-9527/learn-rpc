namespace java com.rpc.thrift

struct User {
    1: string username,
    2: string password
}

service UserService {
    User queryUserByNameAndPassword(1: string username, 2: string password);

    void save(User user)
}
