package spring.model.notice;

import java.sql.SQLException;
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
	
	

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
    	boolean flag = false;
    	
		int cnt = mybatis.insert("notice.create", dto);
		System.out.println(cnt);
		if(cnt>0) 
			flag = true;
	    
		return flag;
	}

	@Override
	public List<NoticeDTO> list(Map map) throws Exception {
		
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
	public int total(String col, String word) {
        Map map = new HashMap();
        map.put("col", col);
        map.put("word", word);
	   
		return mybatis.selectOne("notice.total",map);
	}
	
	public void upViewcnt(int notice_no) {
		mybatis.update("notice.upViewcnt",notice_no);
		System.out.println(notice_no);

	}
	  /**
	   * 레이블 목록
	   * @return ArrayList가 Object 타입으로 저장되어 리턴
	   * @throws SQLException
	   */
	  public Object labelList(Object notice_labeldate){
	    Object obj = mybatis.selectList("notice.label", notice_labeldate);
	    
	    return obj;
	  }

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}  


	
	
}
