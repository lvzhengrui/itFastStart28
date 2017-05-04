package org.lvzr.fast.java.spring.aop.aspectj;
  
import org.springframework.stereotype.Service;  
  
@Service  
public class PersonService {  
  
    public void addPerson(String personName) {  
        System.out.println("add person " + personName);  
    }  
      
    public boolean deletePerson(String personName) {  
        System.out.println("delete person " + personName) ;  
        return true;  
    }  
      
    public void editPerson(String personName) {  
        System.out.println("edit person " + personName);  
        throw new RuntimeException("edit person throw exception");  
    }  
      
}  