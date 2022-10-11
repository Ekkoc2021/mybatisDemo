package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.food;
import pojo.user;

import java.util.List;

public interface foodListMapper {
    List<food> selectFood(@Param("food") food food);
    void insertFood(@Param("food") food food);
    void updateFood(@Param("food") food food);
    void deleteFoodById(@Param("id") String id);
}
