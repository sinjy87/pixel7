package spring.model.pixel7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Research_Mgr {

	@Autowired
	private ResearchDAO dao;
	
	@Autowired
	private ResearchItemDAO ridao;
	
	@Autowired
	private MemberResearchDAO mrdao;
	
	
	
	public void delete(int research_num) throws Exception{
		mrdao.delete(research_num);
		ridao.delete(research_num);
		dao.delete(research_num);
	}

	
}
