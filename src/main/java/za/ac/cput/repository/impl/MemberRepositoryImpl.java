package za.ac.cput.repository.impl;
import za.ac.cput.entity.Member;
import za.ac.cput.repository.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* Author: Lisakhanya Tshokolo
* (220239215)
*26 March 2026
*/

public class MemberRepositoryImpl implements MemberRepository {
 private static MemberRepositoryImpl repository;
 private Map<String, Member> memberMap;

 private MemberRepositoryImpl() {
     memberMap = new HashMap<String, Member>();
 }

 public static MemberRepositoryImpl getRepository() {
     if (repository == null) {
         repository = new MemberRepositoryImpl();
     }
     return repository;
 }

    @Override
    public Member create(Member member) {
     if(!memberMap.containsKey(member.getMemberId())){
         memberMap.put(member.getMemberId(), member);
     }
        return null;
    }

    @Override
    public Member read(String memberId) {
        return memberMap.get(memberId);
    }

    @Override
    public Member update(Member member) {
     if(memberMap.containsKey(member.getMemberId())){
         memberMap.put(member.getMemberId(), member);
         return member;
     }
        return null;
    }

    @Override
    public boolean delete(String memberId) {
        return memberMap.remove(memberId) != null;
    }

    @Override
    public List<Member> getAll() {
        return new ArrayList<Member>(memberMap.values());
    }
}
