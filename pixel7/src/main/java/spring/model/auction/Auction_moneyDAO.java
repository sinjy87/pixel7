package spring.model.auction;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Auction_moneyDAO {
	@Autowired
	private SqlSessionTemplate sql;

	public SqlSessionTemplate getSql() {
		return sql;
	}

	public void setSql(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public Auction_moneyDTO moneyRead(String id) {
		return sql.selectOne("auctionM.read",id);
	}
	public boolean moneyUpdate(Map map) {
		boolean flag = false;
		int cnt = sql.update("auctionM.update", map);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean moneyCreate(String id) {
		boolean flag=false;
		int cnt=sql.insert("auctionM.create",id);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}
	public int idCheck(String id){
		return sql.selectOne("auctionM.idCheck",id);
				
	}
}
