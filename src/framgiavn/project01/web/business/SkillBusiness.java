package framgiavn.project01.web.business;

import framgiavn.project01.web.info.SkillInfo;

public interface SkillBusiness {
	public SkillInfo findSkillByName(String name);
	public SkillInfo findSkillById(Integer id);
}
