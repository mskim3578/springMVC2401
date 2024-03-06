package service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import member.MemberRegistRequest;
import member.Address;
import member.MemberInfo;



//@Component
@Service
public class MemberService {
	private int nextMemberId = 0;
	public Map<String, MemberInfo> memberMap = new HashMap<String, MemberInfo>();

	public MemberService() {
		memberMap.put("m1", new MemberInfo("m1", "이상화", "sanghwa@sanghwa.com", "sanghwa", false, new Address()));
		memberMap.put("m2", new MemberInfo("m2", "김연아", "yuna@yuna.com", "yuna", false, new Address()));
		nextMemberId = 3;  	}

	public List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}
	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}
	
	public void registNewMember(MemberRegistRequest  memRegReq) {
		
	}
	
	public MemberInfo getMemberInfoByEmail(String email) {
		for (MemberInfo mi : memberMap.values()) {
			if (mi.getEmail().equals(email))
				return mi;
		}
		return null;
	}
	
	
	
}