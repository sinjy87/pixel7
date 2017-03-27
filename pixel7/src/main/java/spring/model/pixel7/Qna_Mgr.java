package spring.model.pixel7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qna_Mgr {
	
	@Autowired
	private QnaDAO dao;
	
	@Autowired
	private Qna_replyDAO qrdto;
	
	
	public void delete(int qna_num) throws Exception{
		
		qrdto.delete(qna_num);
		dao.delete(qna_num);
	}

	
	
	
}
