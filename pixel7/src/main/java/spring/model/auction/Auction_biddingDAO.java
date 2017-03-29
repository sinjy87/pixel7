package spring.model.auction;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Auction_biddingDAO {
	@Autowired
	private SqlSessionTemplate sql;

	public void setSqlSession(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	public List<Auction_biddingDTO> bidmoneyLists(Map map){
		return sql.selectList("auctionB.bidmoneyListR",map);
	}
	
	public int bidmoneygetList(Map map){
		return sql.selectOne("auctionB.bidmoneygetList",map);
	}
	
	public List<Auction_biddingDTO> bidmoneylist(int auction_num){
		return sql.selectList("auctionB.bidmoneylist",auction_num);
	}
		public int bidmoneycheck(int auction_num){
		return sql.selectOne("auctionB.bidmoneycheck",auction_num);
	}
	public boolean create(Map map) {
			boolean flag=false;
			int cnt=sql.insert("auctionB.create",map);
			if(cnt>0){
				flag=true;
			}
		return flag;
	}

	public int checkId(int auction_num) {
		return sql.selectOne("auctionB.checkId",auction_num);
	}
	public int idCheck(Map map) {
		return sql.selectOne("auctionB.idCheck",map);
	}


	public Auction_biddingDTO read(Map map) {
		return sql.selectOne("auctionB.read", map);
	}
	public Auction_biddingDTO bidmoneys(int auction_num) {
		return sql.selectOne("auctionB.bidmoneys", auction_num);
	}

	public boolean update(Map map2) {
		boolean flag=false;
		int cnt=sql.update("auctionB.update",map2);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

	public boolean moneyUpdate(Map map) {
		boolean flag= false;
		int cnt=sql.update("auctionB.moneyUpdate",map);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

	public List list(int auction_num) {
		return sql.selectList("auctionB.list",auction_num);
	}
	public boolean delete(int auction_num) {
		boolean flag=false;
		int cnt=sql.delete("auctionB.delete",auction_num);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}
}
