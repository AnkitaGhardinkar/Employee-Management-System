package org.jspider.com.employeemangement.Controller;

import jakarta.servlet.http.HttpSession;
import org.jspider.com.employeemangement.Entity.Employee;
import org.jspider.com.employeemangement.Service.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class empController {
    @Autowired
    private empService service;

    @GetMapping("/")
    public String home(Model m)
    {
       List<Employee>employees=service.getAllEmp();
       m.addAttribute("emp",employees);
       return "index";

    }

    @GetMapping("/addemp")
    public String addEmp(){
        return "add_emp";
    }

   @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee){
        service.addEmp(employee);
//        session.setAttribute("msg","Employee added successfully....");
        return "redirect:/";
   }

   @GetMapping ("/edit/{id}")
   public String edit(@PathVariable int id,Model m){
      Employee employee= service.getEmpById(id);
      m.addAttribute("emp",employee);  //get emp data
        return "edit";

   }

   @PostMapping("/update")
   public  String updateEmp(@ModelAttribute Employee employee){
        service.addEmp(employee);
//       session.setAttribute("msg","Employee Updated successfully....");
        return "redirect:/";

   }
   @GetMapping("/delete/{id}")
   public String deleteEmp(@PathVariable int id){
        service.deleteEmp(id);
//       session.setAttribute("msg","Employee Deleted successfully....");
        return "redirect:/";

   }
}
