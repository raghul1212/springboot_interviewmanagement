package com.revature.interviewmanagement.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.interviewmanagement.dao.InterviewDao;
import com.revature.interviewmanagement.entity.Candidate;
import com.revature.interviewmanagement.entity.Employee;
import com.revature.interviewmanagement.entity.Interview;
import com.revature.interviewmanagement.exception.IdNotFoundException;
import com.revature.interviewmanagement.model.InterviewDto;
import com.revature.interviewmanagement.util.mapper.InterviewMapper;

@Repository
public class InterviewDaoImpl implements InterviewDao {

	private static final Logger logger=LogManager.getLogger(InterviewDaoImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String GET_ALLINTERVIEW="SELECT i FROM Interview i";
	private static final String GET_INTERVIEW_SCHEDULEDDATE="SELECT i FROM Interview i WHERE i.callScheduledDate=?1";
	private static final String GET_INTERVIEW_CANDIDATEID="SELECT i FROM Interview i WHERE i.candidate.id=?1";
	private static final String GET_INTERVIEW_CANDIDATENAME="SELECT i FROM Interview i WHERE CONCAT(i.candidate.firstName,' ', i.candidate.lastName) LIKE :name ";
	private static final String GET_INTERVIEW_CANDIDATEEMAIL="SELECT i FROM Interview i WHERE i.candidate.emailId=?1";
	private static final String GET_INTERVIEW_CANDIDATEPHONE="SELECT i FROM Interview i WHERE i.candidate.phoneNumber=?1";
	private static final String GET_INTERVIEW_CANDIDATEROLE="SELECT i FROM Interview i WHERE i.candidate.jobRole=?1";
	private static final String GET_INTERVIEW_CANDIDATEEXPERIENCE="SELECT i FROM Interview i WHERE i.candidate.experience=?1";
	private static final String GET_INTERVIEW_EMPID="SELECT i FROM Interview i WHERE i.employee.id=?1";
	private static final String GET_INTERVIEW_EMPLOYEEID="SELECT i FROM Interview i WHERE i.employee.employeeId=?1";
	private static final String GET_INTERVIEW_EMPLOYEENAME="SELECT i FROM Interview i WHERE CONCAT(i.employee.firstName,' ', i.employee.lastName) LIKE :name ";
	private static final String GET_INTERVIEW_EMPLOYEEDESIGNATIONID="SELECT i FROM Interview i WHERE i.employee.designationId=?1";
	private static final String GET_INTERVIEW_EMPLOYEEEMAIL="SELECT i FROM Interview i WHERE i.employee.emailId=?1";
	private static final String GET_INTERVIEW_EMPLOYEEPHONE="SELECT i FROM Interview i WHERE i.employee.phoneNumber=?1";
	private static final String GET_INTERVIEW_TYPE="SELECT i FROM Interview i WHERE i.interviewType=?1";
	
	
	
	@Override
	public List<Interview> getAllInterview() {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getAllInterview method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_ALLINTERVIEW).getResultList();
		return resultList;
	}

	@Override
	public Interview getInterviewById(Long id) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewById method");
		return session.get(Interview.class,id);
	}
	
	@Override
	public List<Interview> getInterviewByType(String type) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByType method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_TYPE).setParameter(1,type).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByScheduledDate(LocalDate scheduledDate) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByScheduledDate method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_SCHEDULEDDATE).setParameter(1,scheduledDate).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByCandidateId(Long canId) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByCandidateId method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_CANDIDATEID).setParameter(1,canId).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByCandidateName(String name) {//not done
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByCandidateName method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_CANDIDATENAME).setParameter("name", "%"+name+"%").getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByCandidatePhone(String phone) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByCandidatePhone method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_CANDIDATEPHONE).setParameter(1,phone).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByCandidateEmail(String email) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByCandidateEmail method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_CANDIDATEEMAIL).setParameter(1,email).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByCandidateRole(String role) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByCandidateRole method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_CANDIDATEROLE).setParameter(1,role).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByCandidateExperience(Integer exp) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByCandidateExperience method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_CANDIDATEEXPERIENCE).setParameter(1,exp).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByEmpId(Long empId) {//this empId is auto generated id(Long) in employee entity not the employeeId(String) of employee entity
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByEmpId method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_EMPID).setParameter(1,empId).getResultList();
		return resultList;
	}
	
	@Override
	public List<Interview> getInterviewByEmployeeId(Long employeeId) {//this empId is auto generated id(Long) in employee entity not the employeeId(String) of employee entity
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByEmployeeId method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_EMPLOYEEID).setParameter(1,employeeId).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByDesignationId(Long destId) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByDesignationId method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_EMPLOYEEDESIGNATIONID).setParameter(1,destId).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByEmployeeName(String name) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByEmployeeName method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_EMPLOYEENAME).setParameter("name","%"+name+"%").getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByEmployeePhone(String phone) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByEmployeePhone method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_EMPLOYEEPHONE).setParameter(1,phone).getResultList();
		return resultList;
	}

	@Override
	public List<Interview> getInterviewByEmployeeEmail(String email) {
		Session session=sessionFactory.getCurrentSession();
		logger.info("Entered getInterviewByEmployeeEmail method");
		@SuppressWarnings("unchecked")
		List<Interview> resultList=session.createQuery(GET_INTERVIEW_EMPLOYEEEMAIL).setParameter(1,email).getResultList();
		return resultList;
	}

	@Transactional
	@Override
	public String deleteInterview(Long id) {
		Session session=sessionFactory.getCurrentSession();
		String result=null;
		boolean check=false;
		Interview deleteObject=null;
		try {
			deleteObject=session.load(Interview.class, id);
			if(deleteObject.getCallScheduledDate()!=null) { //necessary line to continue the flow 
				check=true;
			}
		}catch(org.hibernate.ObjectNotFoundException e) {
			logger.error("unable to delete interview, message: {}",e.getMessage(),e);
			throw new IdNotFoundException("Deletion is failed...Entered Id doesn't exists");
		}
		 
		if(check) {
			session.delete(deleteObject);
			session.flush();
			logger.info("Interview deleted with id: {}",id);
			result="Interview deletion is successful for id: "+id;
		}
		
		return result;
		
	}
	
	@Transactional
	@Override
	public String updateInterview(Long id, InterviewDto interviewDto) {
		Session session=sessionFactory.getCurrentSession();
		boolean check=false;
		String result=null;
		Interview updateObj=null;
		try {
			updateObj=session.load(Interview.class,id);
			if(updateObj.getCallScheduledDate()!=null) {  //necessary line to continue the flow 
				check=true;
			}
		} 
		catch (org.hibernate.ObjectNotFoundException e1) {
			logger.error("unable to update interview, message: {}",e1.getMessage(),e1);
			throw new IdNotFoundException("Updation is failed...entered id doesn't exist");
		}
			
		if(check) {
					Interview interview=InterviewMapper.interviewEntityMapper(interviewDto);
					interview.setId(id);
					session.merge(interview);
					session.flush();
					logger.info("Interview updated with id: {}",id);
					result="updation is successful for id: "+id;
			} 
		return result;
		
	}
	
	@Transactional
	@Override
	public String addInterview(InterviewDto interviewDto,Long canId,Long empId) {
		Session session=sessionFactory.getCurrentSession();
		Long id=null;
		boolean candidateState=true;
		boolean employeeState=true;
		try {
				Candidate candidate=session.load(Candidate.class,canId);
				Employee employee=session.load(Employee.class,empId);
				
				if(!candidate.getFirstName().isEmpty())
						candidateState=false;
					
				if(!employee.getFirstName().isEmpty()) {
						employeeState=false;
					}
				
				Interview interview=InterviewMapper.interviewEntityMapper(interviewDto);
				interview.setCandidate(candidate);
				interview.setEmployee(employee);
				id=(Long)session.save(interview);
				logger.info("Interview added with id: {}",id);
			} 
		catch (HibernateException e1) {
			logger.error("unable to add interview, message: {}",e1.getMessage(),e1);
			if(candidateState) {
				throw new IdNotFoundException("Adding interview details is failed...entered candidate id doesn't exist");
			}
			else if(employeeState) {
				throw new IdNotFoundException("Adding interview details is failed...entered employee id doesn't exist");
			}
				
				
			}
		
		return (id!=null)?"Interview details inserted with id:"+id:"Couldn't create Interview...Error occured while inserting";
	
	}

}
