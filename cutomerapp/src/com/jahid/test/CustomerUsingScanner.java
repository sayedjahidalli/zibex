package com.jahid.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.jahid.domain.Customer;

public class CustomerUsingScanner {
	
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		String fileName="F:\\sreenu\\corejava\\cutomerapp\\src\\com\\jahid\\util\\customer.txt";
		Map<String, Customer> dataMap=new HashMap<>();
		Scanner scanner=new Scanner(new File(fileName));
		while(scanner.hasNext()){
			Date dob=null;
			Date today=null;
			String str=scanner.nextLine();
			Customer customer=addCustomer(str);
			dob=customer.getDateOfBirth();
			today=new Date();
			long diffMillis=Math.abs(today.getTime()-dob.getTime());
			long days=TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
			int age=(int) (days/365);
			//System.out.println(age);
			if(age<=30){
			dataMap.put(customer.getFirstName()+" "+customer.getLastName(), customer);
			}//if
		
		}//while
		System.out.println(dataMap);
		scanner.close();
	}
	private static Customer addCustomer(String scanner) throws ParseException{
		
		String[] splits=scanner.split("~");
		Customer customer=new Customer();
		customer.setId(Integer.parseInt(splits[0]));
		customer.setFirstName(splits[1]);
		customer.setLastName(splits[2]);
		customer.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse(splits[3]));
		customer.setLocation(splits[4]);
		customer.setSalary(Double.parseDouble(splits[5]));
		return customer;
	}
}
