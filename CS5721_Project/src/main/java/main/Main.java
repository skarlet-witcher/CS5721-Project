package main;

import java.security.Provider.Service;

import controller.Controller;
import model.Module;
import service.Services;
import view.MainMenu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			new MainMenu().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		/*
		// for testing MVC
		
				// test
		for (Module module : Services.getInstance().getAllModule("get_all_modules")) {
			System.out.println(" Module Code: " + module.getModule_no());
			System.out.println(" Module Name: " + module.getModule_name());
			System.out.println(" Lecturer Name: " + module.getLecturer_name());
			System.out.println(" Credit: " + module.getCredit());
			System.out.println("");
		}
		Module module2 = new Module("CS6081", "Research Method and Practice", "Hao Lu", 6);
		// Update the lecturer name
		int a = Services.getInstance().updateLecturerName(
				"update_lecturer_name", module2.getClass(), module2.getModule_no(), module2.getLecturer_name());
		if(a > 0) {
			System.out.println("Update Complete");
		}
		
		for (Module module3 : Services.getInstance().getAllModule("get_all_modules")) {
			System.out.println(" Module Code: " + module3.getModule_no());
			System.out.println(" Module Name: " + module3.getModule_name());
			System.out.println(" Lecturer Name: " + module3.getLecturer_name());
			System.out.println(" Credit: " + module3.getCredit());
			System.out.println("");
		}
				
		
			*/

				
	}

}
