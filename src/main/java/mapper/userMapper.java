package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.user;

public interface userMapper {
    user selectUserById(@Param("id") String id);
}
