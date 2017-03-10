package spring.utility.pixel7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import spring.model.IReplyDAO;
//import spring.model.bbs.ReplyDAO;

public class Utility {
	private static final String root ="/blog";
	 
	  public static synchronized String getRoot(){
	    return root;
	  }
	  
//	     public static int rcount(int no,IReplyDAO rdao){
//	          return rdao.rcount(no);
//	     }
	  
	 
	  /**
	   * 2010-12-14 형식의 날짜를 리턴합니다.
	   * @return 2008-01-30 형식의 문자열 리턴
	   */
	  public static String getDate6(int year, int month, int day){
	      SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	      
	      new Date();
	      String date = sd.format(new Date(year-1900, month, day));
	 
	      // System.out.println(date);        
	      return date;
	  }
	
	public static String getCodeValue(String code){
		String value = null;
		Hashtable codes = new Hashtable();
		codes.put("A01", "회사원");
		codes.put("A02", "전산관련직");
		codes.put("A03", "연구전문직");
		codes.put("A04", "각종학교학생");
		codes.put("A05", "일반자영업");
		codes.put("A06", "공무원");
		codes.put("A07", "의료인");
		codes.put("A08", "법조인");
		codes.put("A09", "종교/언론/예술인");
		codes.put("A10", "기타");
		
		value = (String)codes.get(code);
		
		return value;
	}
	/**
     * ?삤?뒛,?뼱?젣,洹몄젣 ?궇吏? 媛??졇?삤湲?
     * @return List- ?궇吏쒕뱾 ???옣
     */
    public static List<String> getDay(){
        List<String> list = new ArrayList<String>();
        
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        for(int j = 0; j < 3; j++){
            list.add(sd.format(cal.getTime()));
            cal.add(Calendar.DATE, -1);
        }
        
        return list;
    }
    /**
     * ?벑濡앸궇吏쒖? ?삤?뒛,?뼱?젣,洹몄젣?궇吏쒖? 鍮꾧탳
     * @param wdate - ?벑濡앸궇吏?
     * @return - true:?삤?뒛,?뼱?젣,洹몄젣以? ?벑濡앸궇吏쒖? 媛숈쓬
     *           false:?삤?뒛,?뼱?젣,洹몄젣 ?궇吏쒓? ?벑濡앸궇吏쒖? ?떎 ?떎由?
     */
    public static boolean compareDay(String wdate){
        boolean flag = false;
        List<String> list = getDay();
        if(wdate.equals(list.get(0)) 
           || wdate.equals(list.get(1))
           || wdate.equals(list.get(2))){
            flag = true;
        }
          
        return flag;
    }

	public static String checkNull(String str){
		if(str==null){
			str="";
		}
		
		return str;
	}
	/** 
	   * SPAN?깭洹몃?? ?씠?슜?븳 諛뺤뒪 紐⑤뜽?쓽 吏??썝, 1 ?럹?씠吏?遺??꽣 ?떆?옉 
	   * ?쁽?옱 ?럹?씠吏?: 11 / 22   [?씠?쟾] 11 12 13 14 15 16 17 18 19 20 [?떎?쓬] 
	   *  
	   * @param totalRecord ?쟾泥? ?젅肄붾뱶?닔 
	   * @param nowPage     ?쁽?옱 ?럹?씠吏? 
	   * @param recordPerPage ?럹?씠吏??떦 ?젅肄붾뱶 ?닔  
	   * @param col 寃??깋 而щ읆  
	   * @param word 寃??깋?뼱
	   * @return ?럹?씠吏? ?깮?꽦 臾몄옄?뿴
	   */ 
	  public static String paging1(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
	    int pagePerBlock = 10; // 釉붾윮?떦 ?럹?씠吏? ?닔 
	    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ?쟾泥? ?럹?씠吏?  
	    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?쟾泥? 洹몃９ 
	    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?쁽?옱 洹몃９ 
	    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?듅?젙 洹몃９?쓽 ?럹?씠吏? 紐⑸줉 ?떆?옉  
	    int endPage = (nowGrp * pagePerBlock);             // ?듅?젙 洹몃９?쓽 ?럹?씠吏? 紐⑸줉 醫낅즺   
	     
	    StringBuffer str = new StringBuffer(); 
	     
	    str.append("<DIV id='container'>"); 
//	    str.append("?쁽?옱 ?럹?씠吏?: " + nowPage + " / " + totalPage + "  "); 
	 
	    int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛? ?씠?쟾 ?럹?씠吏?濡? ?씠?룞 
	    if (nowGrp >= 2){ 
	      str.append("<ul class='pager'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?씠?쟾</A></li></ul>"); 
	    } 
	 
	    for(int i=startPage; i<=endPage; i++){ 
	      if (i > totalPage){ 
	        break; 
	      } 
	  
	      if (nowPage == i){ 
	        str.append("<ul class='pagination'><li>"+i+"</li></ul>"); 
	      }else{ 
	        str.append("<ul class='pagination'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A></li></ul>");   
	      } 
	    } 
	     
	    _nowPage = (nowGrp * pagePerBlock)+1; // 10媛? ?떎?쓬 ?럹?씠吏?濡? ?씠?룞 
	    if (nowGrp < totalGrp){ 
	      str.append("<ul class='pager'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?떎?쓬</A></li></ul>"); 
	    } 
	    str.append("</DIV>"); 
	     
	    return str.toString(); 
	  } 

	  public static String paging3(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
		    int pagePerBlock = 10; // 釉붾윮?떦 ?럹?씠吏? ?닔 
		    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ?쟾泥? ?럹?씠吏?  
		    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?쟾泥? 洹몃９ 
		    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?쁽?옱 洹몃９ 
		    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?듅?젙 洹몃９?쓽 ?럹?씠吏? 紐⑸줉 ?떆?옉  
		    int endPage = (nowGrp * pagePerBlock);             // ?듅?젙 洹몃９?쓽 ?럹?씠吏? 紐⑸줉 醫낅즺   
		     
		    StringBuffer str = new StringBuffer(); 
		     
		    str.append("<style type='text/css'>"); 
		    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
		    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
		    str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}"); 
		    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
		    str.append("  .span_box_1{"); 
		    str.append("    text-align: center;");    
		    str.append("    font-size: 1em;"); 
		    str.append("    border: 1px;"); 
		    str.append("    border-style: solid;"); 
		    str.append("    border-color: #cccccc;"); 
		    str.append("    padding:1px 6px 1px 6px; /*?쐞, ?삤瑜몄そ, ?븘?옒, ?쇊履?*/"); 
		    str.append("    margin:1px 2px 1px 2px; /*?쐞, ?삤瑜몄そ, ?븘?옒, ?쇊履?*/"); 
		    str.append("  }"); 
		    str.append("  .span_box_2{"); 
		    str.append("    text-align: center;");    
		    str.append("    background-color: #339999;"); 
		    str.append("    color: #FFFFFF;"); 
		    str.append("    font-size: 1em;"); 
		    str.append("    border: 1px;"); 
		    str.append("    border-style: solid;"); 
		    str.append("    border-color: #cccccc;"); 
		    str.append("    padding:1px 6px 1px 6px; /*?쐞, ?삤瑜몄そ, ?븘?옒, ?쇊履?*/"); 
		    str.append("    margin:1px 2px 1px 2px; /*?쐞, ?삤瑜몄そ, ?븘?옒, ?쇊履?*/"); 
		    str.append("  }"); 
		    str.append("</style>"); 
		    str.append("<DIV id='paging'>"); 
//		    str.append("?쁽?옱 ?럹?씠吏?: " + nowPage + " / " + totalPage + "  "); 
		 
		    int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛? ?씠?쟾 ?럹?씠吏?濡? ?씠?룞 
		    if (nowGrp >= 2){ 
		      str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?씠?쟾</A></span>"); 
		    } 
		 
		    for(int i=startPage; i<=endPage; i++){ 
		      if (i > totalPage){ 
		        break; 
		      } 
		  
		      if (nowPage == i){ 
		        str.append("<span class='span_box_2'>"+i+"</span>"); 
		      }else{ 
		        str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A></span>");   
		      } 
		    } 
		     
		    _nowPage = (nowGrp * pagePerBlock)+1; // 10媛? ?떎?쓬 ?럹?씠吏?濡? ?씠?룞 
		    if (nowGrp < totalGrp){ 
		      str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?떎?쓬</A></span>"); 
		    } 
		    str.append("</DIV>"); 
		     
		    return str.toString(); 
		  } 	 
	
	/** 
	   * ?닽?옄 ?삎?깭?쓽 ?럹?씠吏?, 1 ?럹?씠吏?遺??꽣 ?떆?옉 
	   * ?쁽?옱 ?럹?씠吏?: 11 / 22   [?씠?쟾] 11 12 13 14 15 16 17 18 19 20 [?떎?쓬] 
	   *  
	   * @param totalRecord ?쟾泥? ?젅肄붾뱶?닔 
	   * @param nowPage     ?쁽?옱 ?럹?씠吏? 
	   * @param recordPerPage ?럹?씠吏??떦 異쒕젰?븷 ?젅肄붾뱶 ?닔
	   * @param col 寃??깋 而щ읆  
	   * @param word 寃??깋?뼱
	   * @return ?럹?씠吏? ?깮?꽦 臾몄옄?뿴
	   */ 
	  public static String paging(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
	    int pagePerBlock = 10; // 釉붾윮?떦 ?럹?씠吏? ?닔 
	    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage));// ?쟾泥? ?럹?씠吏?  
	    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?쟾泥? 洹몃９ 
	    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?쁽?옱 洹몃９ 
	    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?듅?젙 洹몃９?쓽 ?럹?씠吏? 紐⑸줉 ?떆?옉  
	    int endPage = (nowGrp * pagePerBlock);             // ?듅?젙 洹몃９?쓽 ?럹?씠吏? 紐⑸줉 醫낅즺   
	     
	    StringBuffer str = new StringBuffer(); 
	     
	    str.append("<style type='text/css'>"); 
	    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
	    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
	    str.append("  #paging A:hover{text-decoration:underline; background-color: #ffffff; color:black; font-size: 1em;}"); 
	    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
	    str.append("</style>"); 
	    str.append("<DIV id='paging'>"); 
	    str.append("현재 페이지 " + nowPage + " / " + totalPage + "  "); 
	 
	    int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛? ?씠?쟾 ?럹?씠吏?濡? ?씠?룞 
	    if (nowGrp >= 2){ 
	      str.append("[<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?씠?쟾</A>]"); 
	    } 
	 
	    for(int i=startPage; i<=endPage; i++){ 
	      if (i > totalPage){ 
	        break; 
	      } 
	  
	      if (nowPage == i){ // ?쁽?옱 ?럹?씠吏??씠硫? 媛뺤“ ?슚怨? 
	        str.append("<span style='font-size: 1.2em; font-weight: bold;'>"+i+"</span> ");   
	      }else{ 
	        str.append("<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A> "); 
	      } 
	       
	    } 
	     
	    _nowPage = (nowGrp * pagePerBlock)+1; // 10媛? ?떎?쓬 ?럹?씠吏?濡? ?씠?룞 
	    if (nowGrp < totalGrp){ 
	      str.append("[<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?떎?쓬</A>]"); 
	    } 
	    str.append("</DIV>"); 
	     
	    return str.toString(); 
	  }
	public static String saveFile(MultipartFile fileMF, String basePath) {
		 // input form's parameter name 
        String fileName = ""; 
        // original file name 
        String originalFileName = fileMF.getOriginalFilename(); 
        // file content type 
        String contentType = fileMF.getContentType(); 
        // file size 
        long fileSize = fileMF.getSize(); 
         
        System.out.println("fileSize: " + fileSize); 
        System.out.println("originalFileName: " + originalFileName); 
         
        InputStream inputStream = null; 
        OutputStream outputStream = null; 
 
        try { 
            if( fileSize > 0 ) { // 파일이 존재한다면 
                // 인풋 스트림을 얻는다. 
                inputStream = fileMF.getInputStream(); 
 
                File oldfile = new File(basePath, originalFileName); 
             
                if ( oldfile.exists()){ 
                    for(int k=0; true; k++){ 
                        //파일명 중복을 피하기 위한 일련 번호를 생성하여 
                        //파일명으로 조합 
                        oldfile = new File(basePath,"("+k+")"+originalFileName); 
                     
                        //조합된 파일명이 존재하지 않는다면, 일련번호가 
                        //붙은 파일명 다시 생성 
                        if(!oldfile.exists()){ //존재하지 않는 경우 
                            fileName = "("+k+")"+originalFileName; 
                            break; 
                        } 
                    } 
                }else{ 
                    fileName = originalFileName; 
                } 
                //make server full path to save 
                String serverFullPath = basePath + "\\" + fileName; 
                 
                System.out.println("fileName: " + fileName); 
                System.out.println("serverFullPath: " + serverFullPath); 
                 
                outputStream = new FileOutputStream( serverFullPath ); 
  
                // 버퍼를 만든다. 
                int readBytes = 0; 
                byte[] buffer = new byte[8192]; 
 
                while((readBytes = inputStream.read(buffer, 0, 8192)) != -1 ) { 
                    outputStream.write( buffer, 0, readBytes ); 
                } 
                outputStream.close(); 
                inputStream.close(); 
                         
            } 
 
        } catch(Exception e) { 
            e.printStackTrace();   
        }finally{ 
             
        } 
         
        return fileName; 
	}
        public static void deleteFile(String upDir,String oldfile){
        	File file = new File(upDir,oldfile);
        	if(file.exists()){
        		file.delete();
        }
    }


/** 
 * 댓글용 페이징 메소드
 * @param totalRecord 전체 레코드수 
 * @param nowPage     댓글의 현재 페이지 
 * @param recordPerPage 댓글의 페이지당 레코드 수 
 * @param url 이동할 페이지 - read
 * @param bbsno bbs 글번호
 * @param nowPage bbs의 현재 페이지
 * @param col bbs의 검색 컬럼
 * @param word bbs의 검색어
 * @return 페이징 생성 문자열
 */ 
public static String paging(String noname, int totalRecord, int nPage, int recordPerPage,String url,int bbsno,int nowPage, String col, String word){ 
  int pagePerBlock = 10; // 블럭당 페이지 수 
  int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // 전체 페이지  
  int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// 전체 그룹 
  int nowGrp = (int)(Math.ceil((double)nPage/pagePerBlock));    // 현재 그룹 
  int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // 특정 그룹의 페이지 목록 시작  
  int endPage = (nowGrp * pagePerBlock);             // 특정 그룹의 페이지 목록 종료   
   
  StringBuffer str = new StringBuffer(); 
   
  str.append("<style type='text/css'>"); 
  str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
  str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
  str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}"); 
  str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
  str.append("  .span_box_1{"); 
  str.append("    text-align: center;");    
  str.append("    font-size: 1em;"); 
  str.append("    border: 1px;"); 
  str.append("    border-style: solid;"); 
  str.append("    border-color: #cccccc;"); 
  str.append("    padding:1px 6px 1px 6px; /*위, 오른쪽, 아래, 왼쪽*/"); 
  str.append("    margin:1px 2px 1px 2px; /*위, 오른쪽, 아래, 왼쪽*/"); 
  str.append("  }"); 
  str.append("  .span_box_2{"); 
  str.append("    text-align: center;");    
  str.append("    background-color: #668db4;"); 
  str.append("    color: #FFFFFF;"); 
  str.append("    font-size: 1em;"); 
  str.append("    border: 1px;"); 
  str.append("    border-style: solid;"); 
  str.append("    border-color: #cccccc;"); 
  str.append("    padding:1px 6px 1px 6px; /*위, 오른쪽, 아래, 왼쪽*/"); 
  str.append("    margin:1px 2px 1px 2px; /*위, 오른쪽, 아래, 왼쪽*/"); 
  str.append("  }"); 
  str.append("</style>"); 
  str.append("<DIV id='paging'>"); 
//    str.append("현재 페이지: " + nowPage + " / " + totalPage + "  "); 

  int _nowPage = (nowGrp-1) * pagePerBlock; // 10개 이전 페이지로 이동 
  if (nowGrp >= 2){ 
    str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+_nowPage+"'>이전</A></span>"); 
  } 

  for(int i=startPage; i<=endPage; i++){ 
    if (i > totalPage){ 
      break; 
    } 

    if (nPage == i){ 
      str.append("<span class='span_box_2'>"+i+"</span>"); 
    }else{ 
      str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+i+"'>"+i+"</A></span>");   
    } 
  } 
   
  _nowPage = (nowGrp * pagePerBlock)+1; // 10개 다음 페이지로 이동 
  if (nowGrp < totalGrp){ 
    str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+_nowPage+"'>다음</A></span>"); 
  } 
  str.append("</DIV>"); 
   
  return str.toString(); 
} 

}