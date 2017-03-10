package spring.model.pixel7;
 
import java.util.List;
import java.util.Map;
 
public interface DAOSTDInter {
public boolean create(Object dto)throws Exception;
public List list(Map map)throws Exception;
public Object read(Object img_num)throws Exception;
public boolean update(Object dto)throws Exception;
public boolean delete(Object img_num)throws Exception;
public int total(Map map)throws Exception;
 
}