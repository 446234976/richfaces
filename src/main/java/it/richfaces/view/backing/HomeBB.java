package it.richfaces.view.backing;

import it.richfaces.model.dto.CarDTO;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.log4j.Logger;

import org.richfaces.component.UIExtendedDataTable;

//import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
//import org.apache.myfaces.trinidad.util.Service;


@ManagedBean(name= "home")
@SessionScoped
public class HomeBB {
	
	private List<CarDTO> listTable;
	private Logger log = Logger.getLogger(HomeBB.class);
	private int rows;
	private boolean show;
	private int clientRows;
	private List<CarDTO> selectionItem = new ArrayList<CarDTO>();
	private Collection<Object> selection;
	private HtmlInputText itvalidate;
	
	public HomeBB(){
		setClientRows(10);
	}
	
	public void loadRowsInTable(AjaxBehaviorEvent event){
		log.info("Start========================>loadRowsInTable");		
		log.info("Rows: "+rows);
		setClientRows(rows);
		loadTable();
		show = false;
		log.info("End========================>loadRowsInTable");
	}
	
	private void loadTable(){
		String vendor = "FIAT";
		String model = "Grande Punto";
		int price = 10000;
		float mileage = 12;
		String vin = "AHGEWRIODFKN";
		String stock = "stock";
		
		listTable = new ArrayList<CarDTO>();
		for(int i = 0; i<1000;i++){
			CarDTO car = new CarDTO(vendor, model, price, mileage, vin, stock, (i+1));
			
			listTable.add(car);
		}
	}
	
	public void selectionRow(AjaxBehaviorEvent event){
		log.info("Start========================>selectionRow");
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getSource();
		Object originalKey = dataTable.getRowKey();
		log.info("OriginalKey: "+originalKey);
		dataTable.setRowKey(originalKey);
		CarDTO selection = null;
		//if (dataTable.isRowAvailable()) {
			selection = (CarDTO) dataTable.getRowData();
		//}
		log.info("Row selection: "+selection);
	    selectionItem.clear();
	    selectionItem.add(selection);
		log.info("End========================>selectionRow");
	}
	
	public void callJs(AjaxBehaviorEvent event){
		log.info("Start========================>callJs");
		try{
			//FacesContext context = FacesContext.getCurrentInstance();
//			ExtendedRenderKitService erks =
//		             Service.getRenderKitService(context,
//		                                         ExtendedRenderKitService.class);
//			log.info("\nContext: "+context+"\nExtendedRenderKitService: "+erks);
//			 
//		        erks.addScript(context,"setRequired('itRows');");
//			String pathFileJs = HomeBB.class.getResource("/js/utils.js") != null ?HomeBB.class.getResource("/js/utils.js").getPath() :"";
//			log.info("Resources: "+pathFileJs);
//			File js =  new File(pathFileJs);
//			log.info("File js: "+js != null ?js.getAbsolutePath() :js);
//			
//			Reader reader = new FileReader(js);
			
			ScriptEngineManager manager = new ScriptEngineManager();
	        ScriptEngine engine = manager.getEngineByName("JavaScript");
			 String script = "function hello(name) { alert('Hello, ' + name); }";
		        // evaluate script
		        engine.eval(script);

		        // javax.script.Invocable is an optional interface.
		        // Check whether your script engine implements or not!
		        // Note that the JavaScript engine implements Invocable interface.
		        Invocable inv = (Invocable) engine;

		        // invoke the global function named "hello"
		        inv.invokeFunction("hello", "Scripting!!" );
//			FacesContext fctx = FacesContext.getCurrentInstance();
//			ExtendedRenderKitService erks =
//			Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
//			String myJavaScriptCode = "alert( "+"Hello World"+");";
//			erks.addScript(fctx, myJavaScriptCode );
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("End========================>callJs");
	}
	
	public void changeIt(ValueChangeEvent event){
		log.info("Start========================>changeIt");
		itvalidate.setValue("Test");
		log.info("End========================>changeIt");
	}

	public List<CarDTO> getListTable() {
		return listTable;
	}

	public void setListTable(List<CarDTO> listTable) {
		this.listTable = listTable;
	}


	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}


	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the show
	 */
	public boolean isShow() {
		return show;
	}

	/**
	 * @param show the show to set
	 */
	public void setShow(boolean show) {
		this.show = show;
	}

	/**
	 * @return the clientRows
	 */
	public int getClientRows() {
		return clientRows;
	}

	/**
	 * @param clientRows the clientRows to set
	 */
	public void setClientRows(int clientRows) {
		this.clientRows = clientRows;
	}

	/**
	 * @return the selectionItem
	 */
	public List<CarDTO> getSelectionItem() {
		return selectionItem;
	}

	/**
	 * @param selectionItem the selectionItem to set
	 */
	public void setSelectionItem(List<CarDTO> selectionItem) {
		this.selectionItem = selectionItem;
	}

	/**
	 * @return the selection
	 */
	public Collection<Object> getSelection() {
		return selection;
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}

	/**
	 * @return the itvalidate
	 */
	public HtmlInputText getItvalidate() {
		return itvalidate;
	}

	/**
	 * @param itvalidate the itvalidate to set
	 */
	public void setItvalidate(HtmlInputText itvalidate) {
		this.itvalidate = itvalidate;
	}
	
}
