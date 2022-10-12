package Test01;

import mapper.appetiteMapper;
import mapper.foodListMapper;
import mapper.userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.appetite;
import pojo.food;
import pojo.user;
import sun.awt.windows.WPrinterJob;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test01 {
    public static SqlSession getSession(){
        //读取MyBatis的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new
                SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
//    --------------------user表的CRUD
    @Test
    public void selectUserByIdTest() throws IOException {
        SqlSession sqlSession = getSession();
        userMapper userMapper = sqlSession.getMapper(mapper.userMapper.class);
        user result = userMapper.selectUserById("1111111111");
        System.out.println("结果："+result);
    }
    @Test
    public void selectAllUser() throws IOException {
        SqlSession sqlSession = getSession();
        userMapper userMapper = sqlSession.getMapper(mapper.userMapper.class);
        List<user> result = userMapper.selectAllUser();
        for (user u:result) {
            System.out.println(u);
        }
    }

    @Test
    public void insertUserTest() throws IOException {

        SqlSession sqlSession = getSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        userMapper userMapper = sqlSession.getMapper(mapper.userMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //        映射文件中的SQL标签，并执行标签中的SQL语句
        user inUser=new user();
        inUser.setId("1111111114");
        inUser.setEmail("1662128515@qq.com");
        inUser.setUsername("jack");
        inUser.setPassword("1235464");
        userMapper.insertUser(inUser);
        //sqlSession.commit();
    }

    @Test
    public void updataUserByIdTest(){
        SqlSession sqlSession=getSession();
        user updataUser=new user("1111111114",null,"1011@qq.com","1234");
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.updataUserById(updataUser);
    }

    @Test
    public void deleteUserByIdTest(){
        SqlSession sqlSession=getSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.deleteUserById("1111111114");
    }

    @Test
    public void selectUserTest(){
        SqlSession sqlSession=getSession();
        user selectUser=new user();
        selectUser.setId("1111111111");
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<user> result = mapper.selectUser(selectUser);
        for (user u:result) {
            System.out.println(u);
        }
    }
//    --------------------食物表的CRUD
    @Test
    public void selectFoodListTest(){
        SqlSession sqlSession=getSession();
        food f=new food();
        f.setCanteen("三食堂");
        f.setFloor("一楼");
        System.out.println(f);
        foodListMapper mapper = sqlSession.getMapper(foodListMapper.class);
        List<food> result = mapper.selectFood(f);
        for (food fo:result) {
            System.out.println(fo);
        }
    }
    @Test
    public void insertFoodListTest(){
        SqlSession sqlSession=getSession();
        food f=new food("11111122","西红柿炒蛋","三食堂","一楼");
        foodListMapper mapper = sqlSession.getMapper(foodListMapper.class);
        mapper.insertFood(f);
    }

    @Test
    public void updataFoodListTest(){
        SqlSession sqlSession=getSession();
        food f=new food("111111121","西红柿炒蛋","一食堂","二楼");
        foodListMapper mapper = sqlSession.getMapper(foodListMapper.class);
        mapper.updateFood(f);
    }

    @Test
    public void deleteFoodListTest(){
        SqlSession sqlSession=getSession();
        foodListMapper mapper = sqlSession.getMapper(foodListMapper.class);
        mapper.deleteFoodById("11111112");
    }
//    收藏的表CRUD----------------
    @Test
//   添加收藏
    public void insertAppetiteTest(){
        SqlSession session=getSession();
        appetiteMapper mapper = session.getMapper(appetiteMapper.class);
        mapper.insertAppetite(new appetite("0000000001","1111111111"));
    }
//    查询收藏
    @Test
    public void selectAppetiteTest(){
        SqlSession session = getSession();
        appetiteMapper mapper =  session.getMapper(appetiteMapper.class);
        appetite a1=new appetite();
//        a1.setUserId("0000000001");
        List<appetite> l=mapper.selectAppetite(a1);
        for (appetite a:l) {
            System.out.println(a);
        }
    }
//    取消收藏
    @Test
    public void deleteAppetiteTest(){
        SqlSession sqlSession=getSession();
        appetiteMapper mapper = sqlSession.getMapper(appetiteMapper.class);
        appetite a=new appetite("0000000001","1111111111");
        mapper.deleteAppetite(a);
    }
//
}

