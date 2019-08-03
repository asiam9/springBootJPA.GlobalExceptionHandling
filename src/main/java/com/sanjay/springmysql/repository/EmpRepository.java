package com.sanjay.springmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.sanjay.springmysql.daoJPA.Emp_Info;

import java.util.List;
import java.util.Optional;

public interface EmpRepository extends JpaRepository<Emp_Info, Integer>, Repository<Emp_Info, Integer> {
    Optional<List<Emp_Info>> findByEmpName(String name);
    Optional<List<Emp_Info>> findByEmpDeg(String deg);


    // @Query(value = "SELECT * FROM emp_info e where e.empName =
	// :name",nativeQuery=true)
	// public Optional<Emp_Info> findByName(@Param("empName") String name);

}
