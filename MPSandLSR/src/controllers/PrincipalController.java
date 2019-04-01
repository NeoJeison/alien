package controllers;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.MasterPlanSchedule;
import model.OldLotSizingMethods;


public class PrincipalController  implements Initializable{



//		public static final String[] LOT_SIZING_METHODS = {"Lot for Lot", "Economic Order Quantity", "Periods Of Suply", 
//			"Period Order Quantity", "Least Unit Cost", "Least Total Cost"};

		@FXML 
		private ArrayList<TextField> textFRequest;
	
	    @FXML
	    private BorderPane borderLayout;

	    @FXML
	    private TabPane tabPane;

	    @FXML
	    private Tab tabLotSizing;

	    @FXML
	    private BorderPane borderTabSizing;

	    @FXML
	    private Pane centralPanel;

	    @FXML
	    private Label lbCostArticle;

	    @FXML
	    private Label lbCostPrepare;

	    @FXML
	    private Label lbCostMaintenance;

	    @FXML
	    private Label lbNetRequirements;

	    @FXML
	    private Button butAddRequirement;

	    @FXML
	    private Button butModifyData;

	    @FXML
	    private Button butRemoveRequeriment;

	    @FXML
	    private TextField textFCostArticle;

	    @FXML
	    private TextField textFCostMaintenance;

	    @FXML
	    private TextField textFCostPrepare;

	    @FXML
	    private ScrollPane scrollCentralPanel;

	    @FXML
	    private GridPane gpOrdersInTime;

	    @FXML
	    private Pane leftPanel;

	    @FXML
	    private Label lbTechniques;

	    @FXML
	    private Button butLXL;

	    @FXML
	    private Button butPOS;

	    @FXML
	    private Button butPOQ;

	    @FXML
	    private Button butLTC;

	    @FXML
	    private Button butEOQ;

	    @FXML
	    private Button butLUC;

	    @FXML
	    private Tab TabMps;

	    @FXML
	    private BorderPane borderTabMps;

	    @FXML
	    private ScrollPane spCentralPanel;

	    @FXML
	    private GridPane gpSpCentralPanel;

	    @FXML
	    private Label labGrossRequirements;

	    @FXML
	    private Label labScheduledReceptions;

	    @FXML
	    private Label lavAvalibeSchudeleInventory;

	    @FXML
	    private Label labNetRequeriments;

	    @FXML
	    private Label labScheduledOrders;

	    @FXML
	    private Label labReleaseOrders;

	    @FXML
	    private Pane underPanel;

	    @FXML
	    private GridPane gpUnderPanel;

	    @FXML
	    private Button butUpdateData;

	    @FXML
	    private Button butAddTimes;

	    @FXML
	    private Button butDeleteTimes;

	    @FXML
	    private Pane PaneTabMpsPrincipalnfo;

	    @FXML
	    private GridPane gpPanePrincipalInfo;

	    @FXML
	    private Label labTecnica;

	    @FXML
	    private Label labLeadTime;

	    @FXML
	    private Label labAvailableInventory;

	    @FXML
	    private Label labSecurityInventory;

	    @FXML
	    private Label labCode;

	    @FXML
	    private Label labMaintenanceCost;

	    @FXML
	    private Label labItemCost;

	    @FXML
	    private Label labPreparationCost;

	    @FXML
	    private Label labItemName;

	    @FXML
	    private ChoiceBox<String> cbLotTec;

	    @FXML
	    private TextField tfLeadTime;

	    @FXML
	    private TextField tfAvalibleInvetary;

	    @FXML
	    private TextField tfSecurityInventory;

	    @FXML
	    private TextField tfCode;

	    @FXML
	    private TextField tfMaintenanceCost;

	    @FXML
	    private TextField tfItemCost;

	    @FXML
	    private TextField tfOrderCost;

	    @FXML
	    private TextField tfItemName;
	    
	    @FXML
	    private TextField TPOS;
	    
	    private OldLotSizingMethods lotSizingRules;
	    
	    @FXML 
	    private ArrayList<TextField> textFBruteRequirements;
	    @FXML 
	    private ArrayList<TextField> textFScheduledReceptions;
	    @FXML
	    private ArrayList<TextField> textFScheduledAvailableStock;
	    @FXML 
	    private ArrayList<TextField> textFNetRequirements;
	    @FXML 
	    private ArrayList<TextField> textFPlanOrders;
	    @FXML 
	    private ArrayList<TextField> textFReleasedPlanOrders;

	    @FXML
	    void PressedEOQ(ActionEvent event) {

	    	inicializarSistema();
	    	lotSizingRules.sistemaCantidadDeOrdenEconomica();
	    	Alert dialogAlert = new Alert(AlertType.INFORMATION);
	    	dialogAlert.setTitle("Planificación de pedidos por cantidad de orden económica");
	    	dialogAlert.setHeaderText(null);
	    	dialogAlert.setContentText(lotSizingRules.toString());
	    	dialogAlert.initStyle(StageStyle.UTILITY);
	    	dialogAlert.showAndWait();
	    }

	    @FXML
	    void PressedLTC(ActionEvent event) {

	    	inicializarSistema();
	    	lotSizingRules.sistemaPorCostoTotalMinimo();
	    	Alert dialogAlert = new Alert(AlertType.INFORMATION);
	    	dialogAlert.setTitle("Planificación de pedidos por costo total mínimo");
	    	dialogAlert.setHeaderText(null);
	    	dialogAlert.setContentText(lotSizingRules.toString());
	    	dialogAlert.initStyle(StageStyle.UTILITY);
	    	dialogAlert.showAndWait();
	    }

	    @FXML
	    void PressedLUC(ActionEvent event) {

	    	inicializarSistema();
	    	lotSizingRules.sistemaPorMenorCostoUnitario();
	    	Alert dialogAlert = new Alert(AlertType.INFORMATION);
	    	dialogAlert.setTitle("Planificación de pedidos por menor costo unitario");
	    	dialogAlert.setHeaderText(null);
	    	dialogAlert.setContentText(lotSizingRules.toString());
	    	dialogAlert.initStyle(StageStyle.UTILITY);
	    	dialogAlert.showAndWait();
	    }

	    @FXML
	    void PressendAddRequirement(ActionEvent event) {


	    	Label newTime = new Label("T = "+(textFRequest.size()+1));
	    	TextField txtAux = new TextField();
	    	txtAux.setPrefSize(96.0, 30.0);
	    	gpOrdersInTime.add(newTime, textFRequest.size(), 0, 1, 1);
	    	gpOrdersInTime.add(txtAux, textFRequest.size(), 1, 1, 1);
	    	gpOrdersInTime.resize(textFRequest.size()*96, gpOrdersInTime.getHeight());
	    	textFRequest.add(txtAux);
	    	
	    }

	    void inicializarSistema() {
	    	double costoArticulo = Double.parseDouble(textFCostArticle.getText());
			double costoPreparacion = Double.parseDouble(textFCostPrepare.getText());
			double costoMantenimiento = Double.parseDouble(textFCostMaintenance.getText());
			lotSizingRules = new OldLotSizingMethods(costoArticulo, costoPreparacion, costoMantenimiento, OldLotSizingMethods.UNKNOWN);
			for(int i = 0; i < textFRequest.size(); i++) {
				lotSizingRules.agregarPedido(Integer.parseInt(textFRequest.get(i).getText()));
			}
	    }
	    @FXML
	    void PressendLXL(ActionEvent event) {

	    	inicializarSistema();
	    	lotSizingRules.sistemaLotePorLote();
	    	Alert dialogAlert = new Alert(AlertType.INFORMATION);
	    	dialogAlert.setTitle("Planificación de pedidos por lote por lote");
	    	dialogAlert.setHeaderText(null);
	    	dialogAlert.setContentText(lotSizingRules.toString());
	    	dialogAlert.initStyle(StageStyle.UTILITY);
	    	dialogAlert.showAndWait();
	    }

	 

	    @FXML
	    void PressendPOQ(ActionEvent event) {

	    	inicializarSistema();
	    	lotSizingRules.sistemaCantidadDeOrdenDePeriodo();
	    	Alert dialogAlert = new Alert(AlertType.INFORMATION);
	    	dialogAlert.setTitle("Planificación de pedidos por cantidad de orden periodo");
	    	dialogAlert.setHeaderText(null);
	    	dialogAlert.setContentText(lotSizingRules.toString());
	    	dialogAlert.initStyle(StageStyle.UTILITY);
	    	dialogAlert.showAndWait();
	    }

	    @FXML
	    void PressendPOS(ActionEvent event) {

	    	System.out.println("hola");
	    	inicializarSistema();
	    
	    	TextInputDialog entrada = new TextInputDialog();
	    	entrada.setTitle ("...");
	    	
	    	entrada.setHeaderText ("Cantidad de periodos");
	    	entrada.setContentText ("Ingrese la cantidad de periodos:");
	    	entrada.showAndWait();
	    	System.out.println(entrada.getResult());
	    	lotSizingRules.sistemaPeriodoDeSuministro(Integer.parseInt(entrada.getResult()));
	    	entrada.close();
	    	
	    	Alert dialogAlert = new Alert(AlertType.INFORMATION);
	    	dialogAlert.setTitle("Planificación de pedidos por periodos de suministro");
	    	dialogAlert.setHeaderText(null);
	    	dialogAlert.setContentText(lotSizingRules.toString());
	    	dialogAlert.initStyle(StageStyle.UTILITY);
	    	dialogAlert.showAndWait();
	    }

	    @FXML
	    void PressendRemoveRequeriment(ActionEvent event) {

	    	if(!textFRequest.isEmpty()) {
	    		textFRequest.remove(textFRequest.get(textFRequest.size()-1));
	    	}
	    }

	    @FXML
	    void pressendButAddTime(ActionEvent event) {

	    	Label newTime = new Label("T = "+(textFBruteRequirements.size()+1));
			textFBruteRequirements.add(createTextField(false));
			textFScheduledReceptions.add(createTextField(false));
			textFScheduledAvailableStock.add(createTextField(true));
			textFNetRequirements.add(createTextField(true));
			textFPlanOrders.add(createTextField(true));
			textFReleasedPlanOrders.add(createTextField(true));
			gpSpCentralPanel.setMaxWidth(gpSpCentralPanel.getMaxWidth() + 96);
			gpSpCentralPanel.setPrefSize(gpSpCentralPanel.getMaxWidth(), 417);
			gpSpCentralPanel.add(newTime, textFBruteRequirements.size() + 1, 0, 1, 1);
			gpSpCentralPanel.add(textFBruteRequirements.get(textFBruteRequirements.size()-1), textFBruteRequirements.size() + 1, 1, 1, 1);
			gpSpCentralPanel.add(textFScheduledReceptions.get(textFScheduledReceptions.size()-1), textFScheduledReceptions.size() + 1, 2, 1, 1);
			gpSpCentralPanel.add(textFScheduledAvailableStock.get(textFScheduledAvailableStock.size()-1), textFScheduledAvailableStock.size() + 1, 3, 1, 1);
			gpSpCentralPanel.add(textFNetRequirements.get(textFNetRequirements.size()-1), textFNetRequirements.size() + 1, 4, 1, 1);
			gpSpCentralPanel.add(textFPlanOrders.get(textFPlanOrders.size()-1), textFPlanOrders.size() + 1, 5, 1, 1);
			gpSpCentralPanel.add(textFReleasedPlanOrders.get(textFReleasedPlanOrders.size()-1), textFReleasedPlanOrders.size() + 1, 6, 1, 1);
			gpSpCentralPanel.resize(textFBruteRequirements.size()*96 , gpSpCentralPanel.getHeight());
	    }

	    private TextField createTextField(boolean locked) {
			TextField txtAux = new TextField();
			txtAux.setPrefSize(96.0, 30.0);
			if(locked) {
				txtAux.setEditable(false);
				
			}
			return txtAux;
		}
	    
	    @FXML
	    void pressendButDeleteTime(ActionEvent event) {

	    }

	    @FXML
	    void pressendButUpdateData(ActionEvent event) {
			MasterPlanSchedule mps = new MasterPlanSchedule(cbLotTec.getValue(), Integer.parseInt(tfLeadTime.getText()), Integer.parseInt(tfAvalibleInvetary.getText()), Integer.parseInt(tfSecurityInventory.getText()), tfCode.getText(), tfItemName.getText(), Double.parseDouble(tfItemCost.getText()), Double.parseDouble(tfOrderCost.getText()), Double.parseDouble(tfMaintenanceCost.getText()), "", 0);
			for(int i = 0; i < textFBruteRequirements.size(); i++) {
				mps.addBruteRequirement(Integer.parseInt(textFBruteRequirements.get(i).getText()));
				mps.addScheduleReception(Integer.parseInt(textFScheduledReceptions.get(i).getText()));
			}
			if(cbLotTec.getValue().equals("Periods Of Suply")) {
				mps.setTPeriodOFSupply(Integer.parseInt(TPOS.getText()));
			}
			mps.createMPS();
			for(int i = 0; i < textFBruteRequirements.size(); i++) {
				textFScheduledAvailableStock.get(i).setText("" + mps.getScheduledAvailableStock().get(i));
				textFNetRequirements.get(i).setText("" + mps.getNetRequirements().get(i));
				textFPlanOrders.get(i).setText("" + mps.getPlanOrders().get(i));
			}
		}
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
	    	textFRequest = new ArrayList<TextField>();
			
	    	textFBruteRequirements = new ArrayList<TextField>();
			textFScheduledReceptions = new ArrayList<TextField>();
			textFScheduledAvailableStock = new ArrayList<TextField>();
			textFNetRequirements = new ArrayList<TextField>();
			textFPlanOrders = new ArrayList<TextField>();
			textFReleasedPlanOrders = new ArrayList<TextField>();
			//cbLotTec = new ChoiceBox<String>();
			cbLotTec.setItems(FXCollections.observableArrayList("Lot for Lot", "Economic Order Quantity", "Periods Of Suply", 
					"Period Order Quantity", "Least Unit Cost", "Least Total Cost"));
		
			
		
		}

	}


