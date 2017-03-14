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
	   * 2010-12-14 ������ ��¥�� �����մϴ�.
	   * @return 2008-01-30 ������ ���ڿ� ����
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
		codes.put("Human", "Human");
		codes.put("A02", "���������");
		codes.put("A03", "����������");
		codes.put("A04", "�����б��л�");
		codes.put("A05", "�Ϲ��ڿ���");
		codes.put("A06", "������");
		codes.put("A07", "�Ƿ���");
		codes.put("A08", "������");
		codes.put("A09", "����/���/������");
		codes.put("A10", "��Ÿ");
		
		value = (String)codes.get(code);
		
		return value;
	}
	/**
     * ?��?��,?��?��,그제 ?���? �??��?���?
     * @return List- ?��짜들 ???��
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
     * ?��록날짜�? ?��?��,?��?��,그제?��짜�? 비교
     * @param wdate - ?��록날�?
     * @return - true:?��?��,?��?��,그제�? ?��록날짜�? 같음
     *           false:?��?��,?��?��,그제 ?��짜�? ?��록날짜�? ?�� ?���?
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
	   * SPAN?��그�?? ?��?��?�� 박스 모델?�� �??��, 1 ?��?���?�??�� ?��?�� 
	   * ?��?�� ?��?���?: 11 / 22   [?��?��] 11 12 13 14 15 16 17 18 19 20 [?��?��] 
	   *  
	   * @param totalRecord ?���? ?��코드?�� 
	   * @param nowPage     ?��?�� ?��?���? 
	   * @param recordPerPage ?��?���??�� ?��코드 ?��  
	   * @param col �??�� 컬럼  
	   * @param word �??��?��
	   * @return ?��?���? ?��?�� 문자?��
	   */ 
	  public static String paging1(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
	    int pagePerBlock = 10; // 블럭?�� ?��?���? ?�� 
	    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ?���? ?��?���?  
	    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?���? 그룹 
	    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?��?�� 그룹 
	    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?��?�� 그룹?�� ?��?���? 목록 ?��?��  
	    int endPage = (nowGrp * pagePerBlock);             // ?��?�� 그룹?�� ?��?���? 목록 종료   
	     
	    StringBuffer str = new StringBuffer(); 
	     
	    str.append("<DIV id='container'>"); 
//	    str.append("?��?�� ?��?���?: " + nowPage + " / " + totalPage + "  "); 
	 
	    int _nowPage = (nowGrp-1) * pagePerBlock; // 10�? ?��?�� ?��?���?�? ?��?�� 
	    if (nowGrp >= 2){ 
	      str.append("<ul class='pager'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?��?��</A></li></ul>"); 
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
	     
	    _nowPage = (nowGrp * pagePerBlock)+1; // 10�? ?��?�� ?��?���?�? ?��?�� 
	    if (nowGrp < totalGrp){ 
	      str.append("<ul class='pager'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?��?��</A></li></ul>"); 
	    } 
	    str.append("</DIV>"); 
	     
	    return str.toString(); 
	  } 

	  public static String paging3(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
		    int pagePerBlock = 10; // 블럭?�� ?��?���? ?�� 
		    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ?���? ?��?���?  
		    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?���? 그룹 
		    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?��?�� 그룹 
		    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?��?�� 그룹?�� ?��?���? 목록 ?��?��  
		    int endPage = (nowGrp * pagePerBlock);             // ?��?�� 그룹?�� ?��?���? 목록 종료   
		     
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
		    str.append("    padding:1px 6px 1px 6px; /*?��, ?��른쪽, ?��?��, ?���?*/"); 
		    str.append("    margin:1px 2px 1px 2px; /*?��, ?��른쪽, ?��?��, ?���?*/"); 
		    str.append("  }"); 
		    str.append("  .span_box_2{"); 
		    str.append("    text-align: center;");    
		    str.append("    background-color: #339999;"); 
		    str.append("    color: #FFFFFF;"); 
		    str.append("    font-size: 1em;"); 
		    str.append("    border: 1px;"); 
		    str.append("    border-style: solid;"); 
		    str.append("    border-color: #cccccc;"); 
		    str.append("    padding:1px 6px 1px 6px; /*?��, ?��른쪽, ?��?��, ?���?*/"); 
		    str.append("    margin:1px 2px 1px 2px; /*?��, ?��른쪽, ?��?��, ?���?*/"); 
		    str.append("  }"); 
		    str.append("</style>"); 
		    str.append("<DIV id='paging'>"); 
//		    str.append("?��?�� ?��?���?: " + nowPage + " / " + totalPage + "  "); 
		 
		    int _nowPage = (nowGrp-1) * pagePerBlock; // 10�? ?��?�� ?��?���?�? ?��?�� 
		    if (nowGrp >= 2){ 
		      str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?��?��</A></span>"); 
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
		     
		    _nowPage = (nowGrp * pagePerBlock)+1; // 10�? ?��?�� ?��?���?�? ?��?�� 
		    if (nowGrp < totalGrp){ 
		      str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?��?��</A></span>"); 
		    } 
		    str.append("</DIV>"); 
		     
		    return str.toString(); 
		  } 	 
	
	/** 
	   * ?��?�� ?��?��?�� ?��?���?, 1 ?��?���?�??�� ?��?�� 
	   * ?��?�� ?��?���?: 11 / 22   [?��?��] 11 12 13 14 15 16 17 18 19 20 [?��?��] 
	   *  
	   * @param totalRecord ?���? ?��코드?�� 
	   * @param nowPage     ?��?�� ?��?���? 
	   * @param recordPerPage ?��?���??�� 출력?�� ?��코드 ?��
	   * @param col �??�� 컬럼  
	   * @param word �??��?��
	   * @return ?��?���? ?��?�� 문자?��
	   */ 
	  public static String paging(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
	    int pagePerBlock = 10; // 블럭?�� ?��?���? ?�� 
	    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage));// ?���? ?��?���?  
	    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?���? 그룹 
	    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?��?�� 그룹 
	    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?��?�� 그룹?�� ?��?���? 목록 ?��?��  
	    int endPage = (nowGrp * pagePerBlock);             // ?��?�� 그룹?�� ?��?���? 목록 종료   
	     
	    StringBuffer str = new StringBuffer(); 
	     
	    str.append("<style type='text/css'>"); 
	    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
	    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
	    str.append("  #paging A:hover{text-decoration:underline; background-color: #ffffff; color:black; font-size: 1em;}"); 
	    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
	    str.append("</style>"); 
	    str.append("<DIV id='paging'>"); 
	    str.append("���� ������ " + nowPage + " / " + totalPage + "  "); 
	 
	    int _nowPage = (nowGrp-1) * pagePerBlock; // 10�? ?��?�� ?��?���?�? ?��?�� 
	    if (nowGrp >= 2){ 
	      str.append("[<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?��?��</A>]"); 
	    } 
	 
	    for(int i=startPage; i<=endPage; i++){ 
	      if (i > totalPage){ 
	        break; 
	      } 
	  
	      if (nowPage == i){ // ?��?�� ?��?���??���? 강조 ?���? 
	        str.append("<span style='font-size: 1.2em; font-weight: bold;'>"+i+"</span> ");   
	      }else{ 
	        str.append("<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A> "); 
	      } 
	       
	    } 
	     
	    _nowPage = (nowGrp * pagePerBlock)+1; // 10�? ?��?�� ?��?���?�? ?��?�� 
	    if (nowGrp < totalGrp){ 
	      str.append("[<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?��?��</A>]"); 
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
            if( fileSize > 0 ) { // ������ �����Ѵٸ� 
                // ��ǲ ��Ʈ���� ��´�. 
                inputStream = fileMF.getInputStream(); 
 
                File oldfile = new File(basePath, originalFileName); 
             
                if ( oldfile.exists()){ 
                    for(int k=0; true; k++){ 
                        //���ϸ� �ߺ��� ���ϱ� ���� �Ϸ� ��ȣ�� �����Ͽ� 
                        //���ϸ����� ���� 
                        oldfile = new File(basePath,"("+k+")"+originalFileName); 
                     
                        //���յ� ���ϸ��� �������� �ʴ´ٸ�, �Ϸù�ȣ�� 
                        //���� ���ϸ� �ٽ� ���� 
                        if(!oldfile.exists()){ //�������� �ʴ� ��� 
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
  
                // ���۸� �����. 
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
 * ��ۿ� ����¡ �޼ҵ�
 * @param totalRecord ��ü ���ڵ�� 
 * @param nowPage     ����� ���� ������ 
 * @param recordPerPage ����� �������� ���ڵ� �� 
 * @param url �̵��� ������ - read
 * @param bbsno bbs �۹�ȣ
 * @param nowPage bbs�� ���� ������
 * @param col bbs�� �˻� �÷�
 * @param word bbs�� �˻���
 * @return ����¡ ���� ���ڿ�
 */ 
public static String paging(String noname, int totalRecord, int nPage, int recordPerPage,String url,int bbsno,int nowPage, String col, String word){ 
  int pagePerBlock = 10; // ���� ������ �� 
  int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ��ü ������  
  int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ��ü �׷� 
  int nowGrp = (int)(Math.ceil((double)nPage/pagePerBlock));    // ���� �׷� 
  int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // Ư�� �׷��� ������ ��� ����  
  int endPage = (nowGrp * pagePerBlock);             // Ư�� �׷��� ������ ��� ����   
   
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
  str.append("    padding:1px 6px 1px 6px; /*��, ������, �Ʒ�, ����*/"); 
  str.append("    margin:1px 2px 1px 2px; /*��, ������, �Ʒ�, ����*/"); 
  str.append("  }"); 
  str.append("  .span_box_2{"); 
  str.append("    text-align: center;");    
  str.append("    background-color: #668db4;"); 
  str.append("    color: #FFFFFF;"); 
  str.append("    font-size: 1em;"); 
  str.append("    border: 1px;"); 
  str.append("    border-style: solid;"); 
  str.append("    border-color: #cccccc;"); 
  str.append("    padding:1px 6px 1px 6px; /*��, ������, �Ʒ�, ����*/"); 
  str.append("    margin:1px 2px 1px 2px; /*��, ������, �Ʒ�, ����*/"); 
  str.append("  }"); 
  str.append("</style>"); 
  str.append("<DIV id='paging'>"); 
//    str.append("���� ������: " + nowPage + " / " + totalPage + "  "); 

  int _nowPage = (nowGrp-1) * pagePerBlock; // 10�� ���� �������� �̵� 
  if (nowGrp >= 2){ 
    str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+_nowPage+"'>����</A></span>"); 
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
   
  _nowPage = (nowGrp * pagePerBlock)+1; // 10�� ���� �������� �̵� 
  if (nowGrp < totalGrp){ 
    str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+_nowPage+"'>����</A></span>"); 
  } 
  str.append("</DIV>"); 
   
  return str.toString(); 
} 

}