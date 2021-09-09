package com.hp.dao;

import com.hp.bean.Person;
import com.hp.bean.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PersonDao {
    //全查
    ArrayList<Person> selectAll();
    //根据性别查询
    List<Person> selectPersonBySex(int sex);
    //List<Person> selectPersonBySex(int sex,String name);//不支持这种写法

    //查询总条数
    long selectCount();

    //查询总条数+多个参数    第一种方式  2个参数都是个person类中的属性，所以直接可以把 person当做参数
    //实体类做参数
    long selectCountByParam01(Person person);


    //第二种方式  多表查询 返回值要用list   但多表联查时 请求的参数一定要为map  或者  自己写的实体类，应用场景，多表联查的多参数查询
    //查  性别和生日   当查出的参数SQL  语句不确定是唯一的用list
    List<Person> selectCountByParam02(Map map);

    //1. 查询 分值最高的人是谁 ？
    List<Person> selectPersonByZi();

    //分组查询
    //2. 查询 男生和女生的平均分值各式多少
    List<PersonDTO> selectAvgScore();

    //3.查询 男生和女生的平均分值 大于  200的值 是什么
    List<PersonDTO> selectAvgScoreParam(int score);

    //第二种方式
    //2. 查询 男生和女生的平均分值各式多少
    List<Map> selectAvgScore02();

    //3.查询 男生和女生的平均分值 大于  200的值 是什么
    List<Map> selectAvgScoreParam02(int score);


    /* <!--模糊查询    有两种方式-->*/
    //查询 姓 孙的 第一种方式 不建议这样写
    List<Person> selectPersonByLike(String name);
    //第二种方式
    List<Person> selectPersonByLike02(String name);
    //第三种方式
    List<Person> selectPersonByLike03(String name);


    //增加的方法
    int insertPerson(Person person);

    //增加的方法     很重要
    int insertPerson02(Person person);

    //删除的方法
    //注意： 之后讲解动态sql，那么 我们的dao层接口中，只有 基础类型 int  String 不好的，不方便执行动态sql。  对以后扩展不方便
    //以后 自己写代码  参数一定 是 一个 实体类  或者 是个 map，或者 是 DTO
    int deletePersonById(Integer id);

    //动态SQL   重点：难点
    //动态的查询
    List<Person> dongTaiSelect(Person person);//动态SQL 如果参数不是实体类，不是集合，是个空参数，那么就没有任何意义
    //返回值 长成 List<实体类> 参数也是 同样的实体类，那么这就是一个典型的动态sql语句

    //动态的修改
    int dongTaiUpdate(Person person);

    //批量删除
    void piliangDel(Map map);   //可以map，list，实体类


}
