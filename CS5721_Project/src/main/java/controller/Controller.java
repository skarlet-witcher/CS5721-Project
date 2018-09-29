package controller;

import java.util.List;

import dao.DataAccess;
import entities.Module;

public class Controller {
	
	private static Controller controller = null;
	private Controller() {
		
	}
	
	public static Controller getInstance() {
		if(controller == null) {
			return new Controller();
		}
		return controller;
	}
	
	
	public List<Module> getAllModule() {
		String sql = "Select e from " + Module.class.getName() + " e ";
		return (List<Module>)DataAccess.getInstance().OperationsByList(sql);
	}
}
