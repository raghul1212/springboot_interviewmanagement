package com.revature.interviewmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.interviewmanagement.dao.CandidateDao;
import com.revature.interviewmanagement.entity.Candidate;
import com.revature.interviewmanagement.model.CandidateDto;
import com.revature.interviewmanagement.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;
	
	@Override
	public List<Candidate> getAllCandidate(){
		
		return candidateDao.getAllCandidate();
	}

	@Override
	public Candidate getCandidateById(Long id) {
		
		return candidateDao.getCandidateById(id);
	}

	@Override
	public Candidate getCandidateByEmailId(String email) {
		
		return candidateDao.getCandidateByEmailId(email);
	}

	@Override
	public List<Candidate> getCandidateByRole(String role) {
		
		return candidateDao.getCandidateByRole(role) ;
	}

	@Override
	public List<Candidate> getCandidateByExperience(Integer exp) {
		
		return candidateDao.getCandidateByExperience(exp);
	}

	@Override
	public List<Candidate> getCandidateByName(String name) {
		
		return candidateDao.getCandidateByName(name) ;
	}

	@Override
	public Candidate getCandidateByPhoneNumber(String phoneNumber) {
		
		return candidateDao.getCandidateByPhoneNumber(phoneNumber);
	}

	@Override
	public String deleteCandidate(Long id) {
		
		return candidateDao.deleteCandidate(id) ;
	}

	@Override
	public String updateCandidate(Long id,CandidateDto candidateDto) {
		
		return candidateDao.updateCandidate(id,candidateDto);
	}

	@Override
	public String addCandidate(Long id,CandidateDto candidateDto) {
		
		return candidateDao.addCandidate(id,candidateDto);
	}


}
