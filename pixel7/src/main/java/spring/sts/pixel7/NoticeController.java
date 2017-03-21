package spring.sts.pixel7;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.notice.NoticeDAO;
import spring.model.notice.NoticeDTO;
import spring.utility.pixel7.Utility;
 
 
@Controller
public class NoticeController {
  @Autowired
  NoticeDAO dao;
  
 
  @RequestMapping(value = "pop", method = RequestMethod.GET)
  public ModelAndView pop(HttpServletRequest request) throws Exception{
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/pop"); // notice.jsp
    
    Calendar cal = Calendar.getInstance();
    int year = 0;
    int month = 0;
 
    if (request.getParameter("y") == null){
      year = cal.get(Calendar.YEAR); // 읽어올 값이 없는 경우 올해 년도 추출
    }else{
      year = Integer.parseInt(request.getParameter("y"));
    }
 
    if (request.getParameter("m") == null){
      month = cal.get(Calendar.MONTH); // 읽어올 값이 없는 경우 올해 년도 추출
    }else{
      month = (Integer.parseInt(request.getParameter("m")) - 1);
    }
 
    // - Calendar MONTH는 0-11까지임
    cal.set(year, month, 1); // 날짜를 현재 월의 첫 날짜로 지정
    int bgnWeek = cal.get(Calendar.DAY_OF_WEEK); // 1주일중 시작 일  
 
    System.out.println("Calendar.DAY_OF_WEEK: " + bgnWeek); // 1(일) ~ 7(토)
 
    // 다음/이전월 계산
    // - MONTH 계산시 표기월로 계산하기 때문에 +1을 한 상태에서 계산함
    int prevYear = year;              // 이전 연도
    int prevMonth = (month + 1) - 1;  // 이전달
    int nextYear = year;              // 다음 년도 
    int nextMonth = (month  + 1) + 1; // 다음달
 
    // 1월인 경우 이전년 12월로 지정
    if (prevMonth < 1) {
      prevYear--;      // 년도 줄임
      prevMonth = 12;  // 최종 달을 12월로
    }
 
    // 12월인 경우 다음년 1월로 지정
    if (nextMonth > 12) {
      nextYear++;      // 다음 년도
      nextMonth = 1;   // 첫달을 1월로 지정
    }
    
    
    mav.addObject("year", year);
    mav.addObject("month", month);
    mav.addObject("prevYear", prevYear);
    mav.addObject("prevMonth", prevMonth);
    mav.addObject("nextYear", nextYear);
    mav.addObject("nextMonth", nextMonth);
 
    StringBuffer sb = new StringBuffer();
    sb.append("<tr>");
    // 시작요일까지 이동, 1(일) ~ 7(토)
    for (int i=1; i < bgnWeek; i++){
      sb.append("<td class='calendar_td'>&nbsp;</td>");
    }
 
    // 첫날~마지막날까지 처리
    // 날짜를 하루씩 이동하여 월이 바뀔때까지 그린다
    String str="";
    ArrayList list = null;
 
    // 현재 달인 경우 계속 순환
    while (cal.get(Calendar.MONTH) == month) {
      if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
        sb.append("<td class='calendar_td' valign='top'><span style='color:blue;'>" + cal.get(Calendar.DATE) + "</span>"); // 토요일인경우
      }else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
        sb.append("<td class='calendar_td' valign='top'><span style='color:red;'>" + cal.get(Calendar.DATE) + "</span>");  // 일요일인 경우
      }else{
        sb.append("<td class='calendar_td' valign='top'>" + cal.get(Calendar.DATE)); // 월 ~ 금요일
      }
  
      // str = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE);
      str = Utility.getDate6(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
      list = (ArrayList)dao.labelList(str); // 날짜에 해당하는 레이블 컬럼 추출
   
      if (list != null){ // 날짜당 일정 추출
        for(int i=0; i<list.size(); i++){
          NoticeDTO dto = (NoticeDTO)list.get(i);
          sb.append("<img src='"+Utility.getRoot()+"/images/bu5.gif'>");
          sb.append("<a './read?notice_no="+dto.getNotice_no()+"'>"+dto.getNotice_label()+"</a><br>");
        }
    
      }
      sb.append("</td>");
  
      // 한달의 마지막 날이 아니면서 토요일인 경우 다음줄로 생성
      // System.out.println(cal.getActualMaximum ( Calendar.DAY_OF_MONTH ));
      if ((cal.getActualMaximum ( Calendar.DAY_OF_MONTH ) != cal.get(Calendar.DATE))) {
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){ // 토요일인 경우
          sb.append("</tr><tr>");
        }
      }
 
      // 날짜 증가시키기
      cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1);
      // 끝날부터 토요일까지 빈칸으로 처리
  
    }
    
    System.out.println("cal.get(Calendar.MONTH): " + cal.get(Calendar.MONTH));
    System.out.println("cal.get(Calendar.DATE): " + cal.get(Calendar.DATE));
 
    if (cal.get(Calendar.DATE) == 1 && (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
      // 한달의 마지막 날짜 토요일이면 아무일도 안함
    }else{
      // 마지막 날짜를 출력하고 나머지는 빈 상자로 채움
      for (int i=cal.get(Calendar.DAY_OF_WEEK); i<=7; i++){
        sb.append("<td class='calendar_td'>&nbsp;</td>");
      }
    }
 
    sb.append("</tr>");    
    
    mav.addObject("calendar", sb);
    
    return mav;
  }
  
  
  @RequestMapping("/cal/read")
  public String read(int notice_no, String col, String word, Model model,HttpServletRequest request  ) throws Exception{
	  dao.upViewcnt(notice_no);
	  model.addAttribute("dto", dao.read(notice_no));

	  return "/notice/read";
  }
  
  
  
  @RequestMapping(value="/cal/login", method=RequestMethod.GET)
   public String login(){
	   return "/notice/login";
   }
  
  @RequestMapping(value="/cal/login",method=RequestMethod.POST)
  public String login(String id,String grade,HttpSession session){
	  session.setAttribute("id", id);
	  session.setAttribute("grade", grade);
	  return "redirect:../";
  }
  /**
   * 등록 폼
   * @return
   **/
  @RequestMapping(value="/cal/create", method=RequestMethod.GET)
  public String create(){

    return "/notice/create";
  }
  
  /**
   * 등록 처리
   * @param dto 자동 생성된 값 객체
   * @return
 * @throws Exception 
   */
  @RequestMapping(value="/cal/create", method=RequestMethod.POST)
  public String create(NoticeDTO dto,HttpSession session, Model model) throws Exception{

	  dto.setId((String)session.getAttribute("id"));
    if (dao.create(dto)) {
    	 model.addAttribute("msg1", "일정을 등록 했습니다.");
    	 model.addAttribute("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create'\">");
    	 model.addAttribute("link2", "<input type='button' value='목록' onclick=\"location.href='./list'\">");
   
    }else{
    	 model.addAttribute("msg1", "일정 등록에 실패 했습니다.");
    	 model.addAttribute("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
    	 model.addAttribute("link2", "<input type='button' value='목록' onclick=\"location.href='"
    	 		+ "'\">");
    }
    return "/notice/msgView";

  }

  
  @RequestMapping(value="/cal/list")
  public String list(Model model,HttpServletRequest request) throws Exception {
		
	  String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		if(col.equals("total")){
			word = "";
		}
		
		int nowPage = 1;
		int recordPerPage = 5;
		if(request.getParameter("nowPage")!=null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int sno = ((nowPage-1)*recordPerPage)+1;
		int eno = nowPage * recordPerPage;
		
	  Map map = new HashMap();
	    map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);

		int total = dao.total(col,word);
		List<NoticeDTO> list = dao.list(map);
		
		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		
       
        request.setAttribute("list", list);
    	request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("paging", paging);
        
    return "/cal/list";
  }
 
  /**
   * 수정 폼
   * @return
   */
  @RequestMapping(value="/cal/update", method = RequestMethod.GET)
  public ModelAndView updateForm(int notice_no) throws Exception{
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/update"); // updateForm.jsp
    
    mav.addObject("dto", dao.read(notice_no));
    
    return mav;
  }
  
  /**
   * 수정 처리
   * @param dto
   * @return
   */
  @RequestMapping(value = "/cal/update",
                             method = RequestMethod.POST)
  public ModelAndView updateProc(NoticeDTO dto) throws Exception{
    ModelAndView mav = new ModelAndView();
    mav.setViewName("notice/msgView"); // msgView.jsp
    
    if (dao.update(dto)){
      mav.addObject("msg1", "일정을 수정했습니다.");
      mav.addObject("link1", "<input type='button' value='목록' onclick=\"location.href='./list'\">");
    }else{
      mav.addObject("msg1", "일정 수정에 실패되었습니다.");
      mav.addObject("msg2", "재시도해주세요.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back();'>");
    }
   
    mav.addObject("root", Utility.getRoot());
    
    return mav;
  }
  
  @RequestMapping(value="/cal/delete", 
                             method=RequestMethod.POST)
  public ModelAndView delete(int notice_no) throws Exception{
    ModelAndView mav = new ModelAndView();
    mav.setViewName("notice/msgView");
    
    if (dao.delete(notice_no)) {
      mav.addObject("msg1", "일정을 삭제했습니다.");
      mav.addObject("link1", "<input type='button' value='목록' onclick=\"location.href='./list.do'\">");
    }else{
      mav.addObject("msg1", "일정 삭제에 실패되었습니다.");
      mav.addObject("msg2", "재시도해주세요.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back();'>");
    }
    
    return mav;
  }
  
  /**
   * home 달력 출력
   * @param request
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/cal/notice_home", method = RequestMethod.GET)
  public ModelAndView calendar_home(HttpServletRequest request) throws Exception{
    ModelAndView mav = new ModelAndView();
    mav.setViewName("notice/notice_home"); // calendar_home.jsp
    
    Calendar cal = Calendar.getInstance();
    int year = 0;
    int month = 0;
 
    if (request.getParameter("y") == null){
      year = cal.get(Calendar.YEAR); // 읽어올 값이 없는 경우 올해 년도 추출
    }else{
      year = Integer.parseInt(request.getParameter("y"));
    }
 
    if (request.getParameter("m") == null){
      month = cal.get(Calendar.MONTH); // 읽어올 값이 없는 경우 올해 년도 추출
    }else{
      month = (Integer.parseInt(request.getParameter("m")) - 1);
    }
 
    // - Calendar MONTH는 0-11까지임
    cal.set(year, month, 1); // 날짜를 현재 월의 첫 날짜로 지정
    int bgnWeek = cal.get(Calendar.DAY_OF_WEEK); // 1주일중 시작 일  
 
    System.out.println("Calendar.DAY_OF_WEEK: " + bgnWeek); // 1(일) ~ 7(토)
 
    // 다음/이전월 계산
    // - MONTH 계산시 표기월로 계산하기 때문에 +1을 한 상태에서 계산함
    int prevYear = year;              // 이전 연도
    int prevMonth = (month + 1) - 1;  // 이전달
    int nextYear = year;              // 다음 년도 
    int nextMonth = (month  + 1) + 1; // 다음달
 
    // 1월인 경우 이전년 12월로 지정
    if (prevMonth < 1) {
      prevYear--;      // 년도 줄임
      prevMonth = 12;  // 최종 달을 12월로
    }
 
    // 12월인 경우 다음년 1월로 지정
    if (nextMonth > 12) {
      nextYear++;      // 다음 년도
      nextMonth = 1;   // 첫달을 1월로 지정
    }
    
    mav.addObject("year", year);
    mav.addObject("month", month);
    mav.addObject("prevYear", prevYear);
    mav.addObject("prevMonth", prevMonth);
    mav.addObject("nextYear", nextYear);
    mav.addObject("nextMonth", nextMonth);
 
    StringBuffer sb = new StringBuffer();
    sb.append("<tr>");
    // 시작요일까지 이동, 1(일) ~ 7(토)
    for (int i=1; i < bgnWeek; i++){
      sb.append("<td class='calendar_td'>&nbsp;</td>");
    }
 
    // 첫날~마지막날까지 처리
    // 날짜를 하루씩 이동하여 월이 바뀔때까지 그린다
    String str="";
    ArrayList list = null;
 
    // 현재 달인 경우 계속 순환
    while (cal.get(Calendar.MONTH) == month) {
      if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
        sb.append("<td class='calendar_td' valign='top'><span style='color:blue;'>" + cal.get(Calendar.DATE) + "</span>"); // 토요일인경우
      }else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
        sb.append("<td class='calendar_td' valign='top'><span style='color:red;'>" + cal.get(Calendar.DATE) + "</span>");  // 일요일인 경우
      }else{
        sb.append("<td class='calendar_td' valign='top'>" + cal.get(Calendar.DATE)); // 월 ~ 금요일
      }
  
      // str = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE);
      str = Utility.getDate6(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
      list = (ArrayList)dao.labelList(str); // 날짜에 해당하는 레이블 컬럼 추출
   
      if (list != null){ // 날짜당 일정 추출
        for(int i=0; i<list.size(); i++){
          NoticeDTO dto = (NoticeDTO)list.get(i);
          sb.append("<img src='"+Utility.getRoot()+"/images/bu5.gif'>");
          sb.append("<a href='./cal/read?notice_no="+dto.getNotice_no()+"'>"+dto.getNotice_label()+"</a><br>");
        }
    
      }
      sb.append("</td>");
      // 한달의 마지막 날이 아니면서 토요일인 경우 다음줄로 생성
      // System.out.println(cal.getActualMaximum ( Calendar.DAY_OF_MONTH ));
      if ((cal.getActualMaximum ( Calendar.DAY_OF_MONTH ) != cal.get(Calendar.DATE))) {
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){ // 토요일인 경우
          sb.append("</tr><tr>");
        }
      }
 
      // 날짜 증가시키기
      cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1);
      // 끝날부터 토요일까지 빈칸으로 처리
  
    }
    
    System.out.println("cal.get(Calendar.MONTH): " + cal.get(Calendar.MONTH));
    System.out.println("cal.get(Calendar.DATE): " + cal.get(Calendar.DATE));
 
    if (cal.get(Calendar.DATE) == 1 && (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
      // 한달의 마지막 날짜 토요일이면 아무일도 안함
    }else{
      // 마지막 날짜를 출력하고 나머지는 빈 상자로 채움
      for (int i=cal.get(Calendar.DAY_OF_WEEK); i<=7; i++){
        sb.append("<td class='calendar_td'>&nbsp;</td>");
      }
    }
 
    sb.append("</tr>");     
    mav.addObject("calendar", sb);
    
    return mav;
  }
  
  /**
   * 달력 출력
   * @param request
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/cal/notice", method = RequestMethod.GET)
  public ModelAndView calendar(HttpServletRequest request) throws Exception{
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/notice"); // notice.jsp
    
    Calendar cal = Calendar.getInstance();
    int year = 0;
    int month = 0;
 
    if (request.getParameter("y") == null){
      year = cal.get(Calendar.YEAR); // 읽어올 값이 없는 경우 올해 년도 추출
    }else{
      year = Integer.parseInt(request.getParameter("y"));
    }
 
    if (request.getParameter("m") == null){
      month = cal.get(Calendar.MONTH); // 읽어올 값이 없는 경우 올해 년도 추출
    }else{
      month = (Integer.parseInt(request.getParameter("m")) - 1);
    }
 
    // - Calendar MONTH는 0-11까지임
    cal.set(year, month, 1); // 날짜를 현재 월의 첫 날짜로 지정
    int bgnWeek = cal.get(Calendar.DAY_OF_WEEK); // 1주일중 시작 일  
 
    System.out.println("Calendar.DAY_OF_WEEK: " + bgnWeek); // 1(일) ~ 7(토)
 
    // 다음/이전월 계산
    // - MONTH 계산시 표기월로 계산하기 때문에 +1을 한 상태에서 계산함
    int prevYear = year;              // 이전 연도
    int prevMonth = (month + 1) - 1;  // 이전달
    int nextYear = year;              // 다음 년도 
    int nextMonth = (month  + 1) + 1; // 다음달
 
    // 1월인 경우 이전년 12월로 지정
    if (prevMonth < 1) {
      prevYear--;      // 년도 줄임
      prevMonth = 12;  // 최종 달을 12월로
    }
 
    // 12월인 경우 다음년 1월로 지정
    if (nextMonth > 12) {
      nextYear++;      // 다음 년도
      nextMonth = 1;   // 첫달을 1월로 지정
    }
    
    mav.addObject("year", year);
    mav.addObject("month", month);
    mav.addObject("prevYear", prevYear);
    mav.addObject("prevMonth", prevMonth);
    mav.addObject("nextYear", nextYear);
    mav.addObject("nextMonth", nextMonth);
 
    StringBuffer sb = new StringBuffer();
    sb.append("<tr>");
    // 시작요일까지 이동, 1(일) ~ 7(토)
    for (int i=1; i < bgnWeek; i++){
      sb.append("<td class='calendar_td'>&nbsp;</td>");
    }
 
    // 첫날~마지막날까지 처리
    // 날짜를 하루씩 이동하여 월이 바뀔때까지 그린다
    String str="";
    ArrayList list = null;
 
    // 현재 달인 경우 계속 순환
    while (cal.get(Calendar.MONTH) == month) {
      if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
        sb.append("<td class='calendar_td' valign='top'><span style='color:blue;'>" + cal.get(Calendar.DATE) + "</span>"); // 토요일인경우
      }else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
        sb.append("<td class='calendar_td' valign='top'><span style='color:red;'>" + cal.get(Calendar.DATE) + "</span>");  // 일요일인 경우
      }else{
        sb.append("<td class='calendar_td' valign='top'>" + cal.get(Calendar.DATE)); // 월 ~ 금요일
      }
  
      // str = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE);
      str = Utility.getDate6(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
      list = (ArrayList)dao.labelList(str); // 날짜에 해당하는 레이블 컬럼 추출
   
      if (list != null){ // 날짜당 일정 추출
        for(int i=0; i<list.size(); i++){
          NoticeDTO dto = (NoticeDTO)list.get(i);
          sb.append("<img src='"+Utility.getRoot()+"/images/bu5.gif'>");
          sb.append("<a href='./read?notice_no="+dto.getNotice_no()+"'>"+dto.getNotice_label()+"</a><br>");
        }
    
      }
      sb.append("</td>");
  
      // 한달의 마지막 날이 아니면서 토요일인 경우 다음줄로 생성
      // System.out.println(cal.getActualMaximum ( Calendar.DAY_OF_MONTH ));
      if ((cal.getActualMaximum ( Calendar.DAY_OF_MONTH ) != cal.get(Calendar.DATE))) {
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){ // 토요일인 경우
          sb.append("</tr><tr>");
        }
      }
 
      // 날짜 증가시키기
      cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1);
      // 끝날부터 토요일까지 빈칸으로 처리
  
    }
    
    System.out.println("cal.get(Calendar.MONTH): " + cal.get(Calendar.MONTH));
    System.out.println("cal.get(Calendar.DATE): " + cal.get(Calendar.DATE));
 
    if (cal.get(Calendar.DATE) == 1 && (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
      // 한달의 마지막 날짜 토요일이면 아무일도 안함
    }else{
      // 마지막 날짜를 출력하고 나머지는 빈 상자로 채움
      for (int i=cal.get(Calendar.DAY_OF_WEEK); i<=7; i++){
        sb.append("<td class='calendar_td'>&nbsp;</td>");
      }
    }
 
    sb.append("</tr>");    
    
    mav.addObject("calendar", sb);
    
    return mav;
  }
}