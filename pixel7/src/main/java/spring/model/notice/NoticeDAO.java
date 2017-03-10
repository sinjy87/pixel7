package spring.model.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO implements Pixel7_NoticeDAO {

	@Autowired
    private SqlSessionTemplate mybatis;
	
	
	
	/** Junit test**/
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	
	@Override
	public boolean create(Object dto) throws Exception {
    	boolean flag = false;
		int cnt = mybatis.insert("notice.create",dto);
		if(cnt>0) flag = true;
	    
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		
		return mybatis.selectList("notice.list",map);
	}

	@Override
	public Object read(Object notice_no) throws Exception {
		
		return mybatis.selectOne("notice.read",notice_no);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("notice.update",dto);
		if(cnt>0)flag=true;
		return flag;
	}

	@Override
	public boolean delete(Object notice_no) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("notice.delete",notice_no);
		if(cnt>0) flag =true;
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		
		return mybatis.selectOne("notice.total",map);
	}
	
	public void upViewcnt(int notice_no) {
		mybatis.update("notice.upViewcnt",notice_no);

	}


	
	
}
