package main;

import controller.Controller;
import model.Module;
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
				for (Module module : Controller.getInstance().getAllModule()) {
					System.out.println(" Module Code: " + module.getModule_no());
					System.out.println(" Module Name: " + module.getModule_name());
					System.out.println(" Lecturer Name: " + module.getLecturer_name());
					System.out.println(" Credit: " + module.getCredit());
					System.out.println("");
				}
				
				// Update the lecturer name
				int a = Controller.getInstance().updateLecturerName(
						new Module("CS6081", "Research Method and Practice", "Xiangkai Tang", 6));
				if(a > 0) {
					System.out.println("Update Complete");
				}
		
				// test
				for (Module module : Controller.getInstance().getAllModule()) {
					System.out.println(" Module Code: " + module.getModule_no());
					System.out.println(" Module Name: " + module.getModule_name());
					System.out.println(" Lecturer Name: " + module.getLecturer_name());
					System.out.println(" Credit: " + module.getCredit());
					System.out.println("");
				}
				System.out.println(Controller.getInstance().getNumModule().size());
			*/

				
	}

}
