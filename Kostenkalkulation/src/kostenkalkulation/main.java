package kostenkalkulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	    double fixKosten = 0;
	    double varKosten = 0;
	    int personen = 0;
	    double properson = 0;
	    int programmstatus = 0;
	    int abfrage = 0;
	    String sqlQuery = "";
	    String text1 = "select * from raeume where ID = ";
	    String text2 = "select * from varkosten where ID = ";
	    Scanner tastatur = new Scanner(System.in);
	    double gesamtkosten = 0;
	    
	    while (programmstatus <3) {
	      try{
	    	  Class.forName("com.mysql.jdbc.Driver");  
	    		Connection con=DriverManager.getConnection(  
	    		"jdbc:mysql://localhost:3306/kostenkalkulation","root","");  
	    		//here sonoo is database name, root is username and password  
	    		Statement stmt=con.createStatement();  
	    		//ResultSet rs=stmt.executeQuery("select * from raeume");  
	    		//while(rs.next())  
	    		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	    		//con.close();
	        switch (programmstatus) {
	          case 0 : 
	            System.out.println("Bitte wähle die Fixkosten aus.");
	            //Auslesen der Tabelleneinträge
	    		ResultSet rs=stmt.executeQuery("select * from raeume");  
	    		while(rs.next())  
	    		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3));
	    		//Auswahl der Fixkosten
	    		abfrage = tastatur.nextInt();
	    		//Abrufen der Fixkosten aus der Datenbank
	    		sqlQuery = text1 + abfrage + ";";
	    		ResultSet rs2=stmt.executeQuery(sqlQuery);
	    		while(rs2.next()) {			
	    			fixKosten = rs2.getDouble(3);
	    		}
	            programmstatus = 1;
	            break;
	    
	          case 1 : 
	            System.out.println("Bitte wähle die variablen Kosten (pro Person) aus.");
	            //Auslesen der Tabelleneinträge
	            ResultSet rs3=stmt.executeQuery("select * from varkosten");
	            while(rs3.next())
	            	System.out.println(rs3.getInt(1)+"  "+rs3.getString(2)+"  "+rs3.getString(3)+"  "+rs3.getDouble(4));
	            //Auswahl der variablen Kosten
	            abfrage = tastatur.nextInt();
	            //Abrufen der variablen Kosten aus der Datenbank
	            sqlQuery = text2 + abfrage + ";";
	            ResultSet rs4=stmt.executeQuery(sqlQuery);
	            while(rs4.next()) {			
	    			varKosten = rs4.getDouble(4);
	    		}
	            programmstatus++;
	            break;
	          case 2 :                                                                      
	            System.out.println("Bitte gib die Anzahl der Personen ein");
	            personen = tastatur.nextInt();
	            if (personen <= 0){
	              throw new ArithmeticException();
	            }
	            properson = (fixKosten + (varKosten * personen)) / personen;
	            gesamtkosten = fixKosten + (varKosten * personen);
	            System.out.println("Die Fixkosten betragen " + fixKosten + " Euro.");
	            System.out.println("Die variablen Kosten betragen " + varKosten + " Euro.");
	            System.out.println("Es werden " + personen + " Personen erwartet.");
	            System.out.println("Sind die Angaben korrekt ? ja=1 / nein=0");
	            abfrage = tastatur.nextInt();
	            if (abfrage == 0) {
	              System.out.println("Bitte Angaben wiederholen");
	              programmstatus = 0;
	            } else {
	              System.out.println("Die Gesamtkosten betragen " + gesamtkosten + " Euro.");
	              System.out.println("Die Kosten pro Person betragen " + properson + " Euro.");
	              System.out.println("Soll eine weitere Berechnung durchgeführt werden? ja=1 / nein=0");
	              abfrage = tastatur.nextInt();
	              if (abfrage == 1) {
	                programmstatus = 0;
	              } else {
	                programmstatus++;
	              } // end of if-else
	            }
	            break;
	          default:
	        }
	      } catch (java.util.InputMismatchException b)
	      {
	        System.out.println("falsches Datenformat");
	        tastatur.next();
	      } catch (ArithmeticException e)
	      {
	        if (personen < 0) {
	          System.out.println("Für die Anzahl der Personen wird eine positive ganze Zahl erwartet.");
	        } 
	        if (personen == 0) {
	          System.out.println("Division durch 0. Die Anzahl der Personen darf nicht null betragen");
	          }
	          else {
	          }
	        	  
	          }
	        catch(Exception e){
	    	   System.out.println(e);
	       }        
	      }
	    } // end of while
	  } // end of main