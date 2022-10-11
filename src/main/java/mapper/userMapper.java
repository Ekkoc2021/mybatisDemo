package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.user;

import java.util.List;

public interface userMapper {
    user selectUserById(@Param("id") String id);
    void insertUser(@Param("user") user user);
    void updataUserById(@Param("user")user user);
    void deleteUserById(@Param("id")String id);
    List<user> selectAllUser();
    List<user> selectUser(@Param("user")user user);
}
