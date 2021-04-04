import java.time.LocalDate;                                                                                                       
import java.time.Period;                                                                                                          
import java.util.Arrays;                                                                                                          
import java.util.Scanner;                                                                                                         
import java.util.stream.Collectors;                                                                                               
import java.util.List;                                                                                                            
                                                                                                                                  
public class Info{                                                                                                                
    private String name;                                                                                                          
    private String surname;                                                                                                       
    private String patronymic;                                                                                                    
    private LocalDate bDate;                                                                                                      
                                                                                                                                  
    public String getName(){                                                                                                      
        return name;                                                                                                              
    }                                                                                                                             
    public void setName(){                                                                                                        
        this.name = name;                                                                                                         
    }                                                                                                                             
    public String getSurname(){                                                                                                   
        return surname;                                                                                                           
    }                                                                                                                             
    public void setSurname(){                                                                                                     
        this.surname = surname;                                                                                                   
    }                                                                                                                             
    public String getPatronymic(){                                                                                                
        return patronymic;                                                                                                        
    }                                                                                                                             
    public void setPatronymic(){                                                                                                  
        this.patronymic = patronymic;                                                                                             
    }                                                                                                                             
    public LocalDate getbDate(){                                                                                                  
        return bDate;                                                                                                             
    }                                                                                                                             
    public void setbDate(LocalDate bDate){                                                                                        
        this.bDate = bDate;                                                                                                       
    }                                                                                                                             
                                                                                                                                  
    public void gender(){                                                                                                         
        String sex;                                                                                                               
        if(patronymic.charAt(patronymic.length() - 1) == 'а') {                                                                   
            sex = "Женский";                                                                                                      
        } else{ sex = "Мужской";}                                                                                                 
        System.out.println("Пол: " + sex);                                                                                        
    }                                                                                                                             
                                                                                                                                  
    public int countAge(){                                                                                                        
        return Period.between(bDate,LocalDate.now()).getYears();                                                                  
    }                                                                                                                             
                                                                                                                                  
    public void getInfo(){                                                                                                        
        Scanner in = new Scanner(System.in);                                                                                      
        System.out.println("Введите ФИО и дату рождения");                                                                        
        surname = in.next();                                                                                                      
        name = in.next();                                                                                                         
        patronymic = in.next();                                                                                                   
        String birthDate = in.next();                                                                                             
        String[] date = birthDate.split("\\.");                                                                                   
        List<Integer> list = Arrays.stream(date).map(Integer::parseInt).collect(Collectors.toList());                             
        try {                                                                                                                     
              bDate = LocalDate.of(list.get(2), list.get(1), list.get(0));                                                        
            } catch (Exception e) {                                                                                               
              System.out.println("Date is incorrect");                                                                            
        }                                                                                                                         
        System.out.println(surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ". \n" + countAge()+ " лет");            
    }                                                                                                                             
}                                                                                                                                 
                                                                                                                                  
