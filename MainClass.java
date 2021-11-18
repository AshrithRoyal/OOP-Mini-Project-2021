import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.ref.Cleaner;
import java.util.Arrays;
import java.util.List;


public class MainClass {

    public static void main(String[] args) throws Exception {

       /*
    
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Priya\\Desktop\\test\\cars.csv"));
        String sline;
        while((sline= reader.readLine())!=null){
            CarDAO.createCar(new Car(sline));
        }
        reader.close();
    
     */
      
    
    if(args[0].equals("-insert")){

            String name = args[1];
            int price= Integer.valueOf(args[2]);
            int mil = Integer.valueOf(args[3]); 
            Car c1 = new Car(name,price,mil);

            CarDAO.insertCar(c1);

            PrintWriter file =new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Priya\\Desktop\\test\\cars.csv",true)));

            
            file.print(name);
            file.print(",");
            file.print(price);
            file.print(",");
            file.print(mil);
            file.println(" ");
            file.close();

    }

    else if(args[0].equals("-delete")){

            String car_name= args[1];
            CarDAO.deleteCar(car_name);

    }

    else if(args[0].equals("-deleteAll")){

        CarDAO.deleteAllCar();

    }

    else if(args[0].equals("-update")){
            String name = args[1];
            int price= Integer.valueOf(args[2]);
            int mil = Integer.valueOf(args[3]); 
           
            Car c = new Car(name,price,mil);

           
            CarDAO.updateCar(c);
        
    }


    else if(args[0].equals("-printAll")){
        List<Car> list = CarDAO.getAllCars();
        list.forEach(System.out::println);
    }

    else if(args[0].equals("-print")){
        if((args[1])!=null){
        List<Car> list2 = CarDAO.getCarByName(args[1]);
        list2.forEach(System.out::println);
        }
        else if(args[1]==null){
            System.out.println("Command NOT FOUND");
        }
    }

    else if(args[0].equals("-search")){
        if(args[1].equals("-price")){
            if(args[2].equals("-gt")){

                int temp= Integer.valueOf(args[3]);
                List<Car> list=  CarDAO.search_price_gt(temp);
                list.forEach(System.out::println);
            }
            else if(args[2].equals("-less")){
                
                int temp= Integer.valueOf(args[3]);
                List<Car> list=  CarDAO.search_price_less(temp);
                list.forEach(System.out::println);
            }
            else{
                System.out.println("Command NOT FOUND");
            }
        }

        else if(args[1].equals("-mileage")){
            if(args[2].equals("-gt")){
                int temp= Integer.valueOf(args[3]);
                List<Car> list=  CarDAO.search_mileage_gt(temp);
                list.forEach(System.out::println);
            }
            else if(args[2].equals("-less")){
                int temp= Integer.valueOf(args[3]);
                List<Car> list=  CarDAO.search_mileage_less(temp);
                list.forEach(System.out::println);
            }
            else{
                System.out.println("Command NOT FOUND");
            }
        }

        else if(args[1].equals(null)){
            System.out.println("Command NOT FOUND");
        }
        else{
            System.out.println("Command NOT FOUND");
        }
    }



    else if(args[0].equals("-h")){
        System.out.println("--------------------Commands for Mini Project---------------------");
        System.out.println(" Insert                 : -insert car_name car_price car_mileage");
        System.out.println(" Delete(All)            : -delete  ");
        System.out.println(" Delete(by car_name)    : -delete car_name ");
        System.out.println(" Update(by car_name)    : -update car_name car_price car_mileage ");
        System.out.println(" Print ALL cars         : -printAll");
        System.out.println(" Print by Car Name      : -print car_name");
        System.out.println(" Search(by price)       : -search -price -gt car_price");
        System.out.println(" Search(by price)       : -search -price -less car_price");
        System.out.println(" Search(by mileage)     : -search -mileage -gt car_price");
        System.out.println(" Search(by mileage)     : -search -mileage -less car_price");
        System.out.println(" For Help               : -h ");
    
    }

    else{
        System.out.println("--------------------Commands for Mini Project---------------------");
        System.out.println(" Insert                 : -insert car_name car_price car_mileage");
        System.out.println(" Delete(All)            : -delete  ");
        System.out.println(" Delete(by car_name)    : -delete car_name ");
        System.out.println(" Update(by car_name)    : -update car_name car_price car_mileage ");
        System.out.println(" Print ALL cars         : -printAll");
        System.out.println(" Print by Car Name      : -print car_name");
        System.out.println(" Search(by price)       : -search -price -gt car_price");
        System.out.println(" Search(by price)       : -search -price -less car_price");
        System.out.println(" Search(by mileage)     : -search -mileage -gt car_price");
        System.out.println(" Search(by mileage)     : -search -mileage -less car_price");
        System.out.println(" For Help               : -h ");
    }



    }
}