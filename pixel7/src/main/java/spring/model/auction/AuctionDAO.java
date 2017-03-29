package spring.model.auction;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionDAO {
	@Autowired
	private SqlSession sql;

	public void setSql(SqlSession SqlSession) {
		this.sql = SqlSession;
	}

	public List<AuctionDTO> tlist() {
		return sql.selectList("auction.auction_TL");
	}

	public List<AuctionDTO> testTime() {
		return sql.selectList("auction.testTime");
	}

	public boolean testUpdate(Map map) {
		boolean flag = false;
		int cnt = sql.update("auction.testUpdate", map);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public String closeTimeRead(int auction_num) {
		return sql.selectOne("auction.closeTimeRead", auction_num);
	}

	public boolean closeTime(Map map) {
		boolean flag = false;
		int cnt = sql.update("auction.close", map);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean create(AuctionDTO dto) {
		boolean flag = false;
		int cnt = sql.insert("auction.create", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public List<AuctionDTO> list() {
		return sql.selectList("auction.list");

	}

	public AuctionDTO read(int auction_num) {
		return sql.selectOne("auction.read", auction_num);
	}

	public boolean update(AuctionDTO dto) {
		boolean flag = false;
		int cnt = sql.update("auction.update", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean moneyCharge(AuctionDTO dto) {
		boolean flag = false;
		int cnt = sql.update("moneyCharge", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public AuctionDTO timeRead(AuctionDTO dto) {
		return sql.selectOne("auction.timeRead", dto);
	}

	public boolean time(int auction_num) {
		boolean flag = false;
		int cnt = sql.update("auction.timeUpdate", auction_num);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean delete(int auction_num) {
		boolean flag=false;
		int cnt=sql.delete("auction.delete",auction_num);
		return flag;
	}
	public AuctionDTO tR(int auction_num){
		return sql.selectOne("auction.auction_TR",auction_num);
				}
}
