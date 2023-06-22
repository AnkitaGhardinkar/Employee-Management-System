package org.jspider.com.employeemangement.Service;

import org.jspider.com.employeemangement.Entity.Employee;
import org.jspider.com.employeemangement.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class empService {
    @Autowired
    private EmpRepo repo;
    public void addEmp(Employee employee)
    {
        repo.save(employee);
        return ;
    }

//    display all emp
    public List<Employee>getAllEmp(){
      return  repo.findAll();
    }

//    update employee by id
 public Employee getEmpById(int id){
        Optional<Employee> employee=repo.findById(id);
     if(employee.isPresent()){  //avoid null pointer exception
            return employee.get();
        }
        return null;

 }
// Delete Employee by id
    public void deleteEmp(int id){
        repo.deleteById(id);
    }
}
