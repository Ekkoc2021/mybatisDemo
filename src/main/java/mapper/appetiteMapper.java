package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.appetite;
import pojo.food;

import java.util.List;

public interface appetiteMapper {
    void insertAppetite(@Param("appetite")appetite a);
    void deleteAppetite(@Param("appetite") appetite a);
    List<appetite> selectAppetite(@Param("appetite") appetite a);
}
