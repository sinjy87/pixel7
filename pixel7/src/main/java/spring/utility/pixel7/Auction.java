package spring.utility.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.model.auction.Auction_biddingDAO;
import spring.model.auction.Auction_biddingDTO;

public class Auction{

	/**
	 * 
	 * 
	 * 
	 */
	
	public static List<Auction_biddingDTO> bidmoney(Auction_biddingDAO dao,int auction_num){
		Map map=new HashMap();
		map.put("auction_num", auction_num);
		map.put("mn",0);
		map.put("mx",2);
		List<Auction_biddingDTO> list=dao.bidmoneyLists(map);
		for(int i=0; i<list.size(); i++){
			System.out.println("번호"+list.get(i).getAuction_num()+"입찰금액"+list.get(i).getAuction_bidmoney());
		}
		return list;
	}
	public static int bidMoneyCheck(Auction_biddingDAO dao,int auction_num){
		int bidmoney=dao.bidmoneycheck(auction_num);
		return bidmoney;
	}
	public static String DateCut(Object auction_stime) {
        String value = (String)auction_stime;
        String[] date = value.split("-");
 		String yy=date[0];
 		String mm=date[1];
 		String dd=date[2].substring(0,2);
 		String[] time=date[2].split("[ ]");

		String StartDate=yy+"년"+mm+"월"+dd+"일";
 		return StartDate;
	}
	public static String CloseTime(Object auction_ctime){
		String value=(String)auction_ctime;
		String[] splits=value.split("[ ]");
		String day=splits[0].substring(8,10)+"일";
		String hour=splits[1].substring(0,2)+"시";
 		String minute=splits[1].substring(3,5)+"분";
 		String second=splits[1].substring(6,8)+"초"; 
		String CloseTime=day+hour+minute+second;
		return CloseTime;
	}
	public static String StartTime(Object auction_stime){
		String value=(String)auction_stime;
		String[] splits=value.split("[ ]");
		String hour=splits[1].substring(0,2);
		String minute=splits[1].substring(3,5);
		String second=splits[1].substring(6,8); 
		String StartTime=hour+minute+second;
		return value;
	}
	public static String SumTime(Object auction_stime,Object auction_ctime){
		String[] startTime=((String) auction_stime).split("[ ]");
		String st=startTime[1];
		String[] st2=st.split("[:]");
		String[] st3=st2[2].split("[.]");
		
		String[] closeTime=((String) auction_ctime).split("[ ]");
		String ct=closeTime[1];
		String[] ct2=ct.split("[:]");
		String[] ct3=ct2[2].split("[.]");
		
		int starthour=Integer.parseInt(st2[0]);
		int startminu=Integer.parseInt(st2[1]);
		int startseconde=Integer.parseInt(st3[0]);
		int closehour=Integer.parseInt(ct2[0]);
		int closeminu=Integer.parseInt(ct2[1]);
		int closesecond=Integer.parseInt(ct3[0]);
	    int sum=(closehour-starthour)*3600;
//	    int hours=sum/3600;
//	    int minute=sum%3600/60;
//	    int second=sum%3600%60;
	    String d_day="";
  	    return d_day;
	}

}
  