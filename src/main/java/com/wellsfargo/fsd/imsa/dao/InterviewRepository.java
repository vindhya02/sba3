package com.wellsfargo.fsd.imsa.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.imsa.entity.Interview;


@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {


	List<Interview> findAllByinterviewname(String interviewname);
	
	List<Interview> findAllByinterviewername(String interviewername);
		
}


