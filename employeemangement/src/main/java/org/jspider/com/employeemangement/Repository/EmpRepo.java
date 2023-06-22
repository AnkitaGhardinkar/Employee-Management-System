package org.jspider.com.employeemangement.Repository;

import org.jspider.com.employeemangement.Entity.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {

}
