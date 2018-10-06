package controller;

import java.util.List;

import dao.DataAccess;
import model.Module;

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
	
	/*
	
	public List<Module> insertModule() {
		String sql = "Select e from " + Module.class.getName() + " e ";
		return (List<Module>)DataAccess.getInstance().OperationsByList(sql);
	}*/
	
	public List<Module> getAllModule() {
		String[] params = {};
		Object[] values = {};
		return (List<Module>)DataAccess.getInstance().OperationsByList("get_all_modules", Module.class, params, values);
	}
	
	public void updateLecturerName(Module module) {
		String[] params = { "module_no","lecturer_name" };
		Object[] values = { module.getModule_no() , module.getLecturer_name() };
		DataAccess.getInstance().operationsForDeleteAndUpdate("update_lecturer_name", Module.class, params, values);
		
		/*String sql = "update " + Module.class.getName() +
				" e set e.lecturer_name = '" + module.getLecturer_name() + "'" + " where e.module_no= '"+ module.getModule_no() + "' ";
		DataAccess.getInstance().operationsForDeleteAndUpdate(sql, module);*/
	}
}
