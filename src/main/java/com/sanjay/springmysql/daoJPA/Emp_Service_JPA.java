package com.sanjay.springmysql.daoJPA;

import com.sanjay.springmysql.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Emp_Service_JPA {
    @Autowired
    private EmpRepository empRepository;

    /*
     * A in build method used to get the all the Object
     */
    public Employees getAll() {
    	List<Emp_Info> emp_Infos=empRepository.findAll();    	
        Employees emp=new Employees();
        emp.setEmp_Info(emp_Infos);
        return emp;
    }

   /*
   * A in build method used to get the Object by primaryKey
   */
    public Optional<Emp_Info> getById(Integer id) {
        return empRepository.findById(id);
    }


    public Optional<List<Emp_Info>> getByName(String name) {
        return empRepository.findByEmpName(name);
    }

    public String createNewEmp(Emp_Info emp_info) {
        System.out.print("##########"+empRepository.save(emp_info));
        return "Record Inserted";
    }

 /*   public String deleteEmpById(Integer id) {
        empRepository.deleteById(id);
        return "xyz";
    }*/
    
}
