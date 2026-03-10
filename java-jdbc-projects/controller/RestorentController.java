package jdbc.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.Dao.RestorentDao;
import jdbc.entity.Restorent;

public class RestorentController {
	private static RestorentDao dao=new RestorentDao();
      public static void main(String[] args) {
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter a choice");
    	  System.err.println(" 1) TO INSERT THE DATA \n 2)TO FETCH ALL THE DATA \n 3)TO FETCH THE DATA BASED ON ID \n 4) TO UPDATE THE DATA \n 5) TO TO DELETE THE DATA \n 6) TO EXIT.....");
	      int choice=sc.nextInt();
	      switch(choice) {    
	      case 1:{
	    	  System.out.println("ENTER YOUR RESTORENT ID");
	    	  long id=sc.nextLong();
	    	  System.out.println("ENTER YOU RESTORENT NAME");
	    	  sc.nextLine();
	    	  String name=sc.nextLine();
	    	  System.out.println("ENTER YOU RESTORENT LOCATION");
	    	  String loc=sc.nextLine();
	    	  System.out.println("ENTER YOU RESTORENT FOOD ITEMS");
	    	  String items=sc.nextLine();
	    	  System.out.println("ENTER YOU RESTORENT RATING");
	    	  String rating=sc.nextLine();
	    	  System.out.println("ENTER YOU RESTORENTDESCRIPTION");
	    	  String des=sc.nextLine();
	    	  Restorent r=new Restorent();
	    	  r.setId(id);
	    	  r.setName(name);
	    	  r.setLoc(loc);
	    	  r.setFooditems(items);
	    	  r.setRating(rating);
	    	  r.setDes(des);
	    	  try {
				int res=dao.insert(r);
				if(res>0) {
					System.out.println("inserted Sucessfully");
				}
				else {
					System.out.println("not inserted");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  break;
	      }
	      case 2:{
	    	  try {
				ResultSet res=dao.feacthAll();
				if(res.isBeforeFirst()) {
					while(res.next()){
					 System.out.println("id: "+res.getLong(1));
					 System.out.println("name: "+res.getString(2));
					 System.out.println("location: "+res.getString(3));
					 System.out.println("footitems: "+res.getString(4));
					 System.out.println("rating: "+res.getString(5));
					 System.out.println("description: "+res.getString(6));
					}
				}
				else {
					System.out.println("no data found!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  break;
	      }
	      case 3:{
	    	  try {
	    		System.out.println("enter your id");
			    Restorent res=dao.fetchbyId(sc.nextLong());
			    if(res!=null) {
			    	 System.out.println("id: "+res.getId());
					 System.out.println("name: "+res.getName());
					 System.out.println("location: "+res.getLoc());
					 System.out.println("footitems: "+res.getFooditems());
					 System.out.println("rating: "+res.getRating());
					 System.out.println("description: "+res.getDes());	
//			    	System.out.println(res);
			    }
			    else {
			    	System.out.println("no records found!");
			    }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	  break;
	      }
	      case 4:{
	    	 System.out.println("inter your id");
	    	 long id=sc.nextLong();
	    	 try {
				Restorent res=dao.fetchbyId(id);
				if(res!=null) {
					System.out.println("enter the updated name");
					sc.nextLine();
					String data=sc.nextLine();
					int r=dao.updateData(data,id);
					if(r>0) {
						System.out.println("inserted successfully");
					}
					else {
						System.out.println("not inserted successfully");
					}
				}
				else {
					System.out.println("no record found!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	  break;
	      }
	      case 5:{
	    	  System.out.println("enter the id");
	    	  long id=sc.nextLong();
	    	  try {
				Restorent r=dao.fetchbyId(id);
				if(r!=null) {
					int res=dao.deleteData(id);
					if(res>0) {
						System.out.println("data deleted succeussfully !");
					}
					else {
						System.out.println("data not delted ");
					}
				}
				else {
					System.out.println("no records found");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  break;
	      }
	      case 6:{
	    	  System.out.println("thank you for vist.....");
	    	  break;
	      }
	      default:{
	    	  System.out.println("INVAILD CHOICE");
	      }
	      } 
      }
     
}
