package controllers;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.MasterPlanSchedule;

public class MPSView implements Initializable{
	
	public static final String[] LOT_SIZING_METHODS = {"Lot for Lot", "Economic Order Quantity", "Periods Of Suply", 
			"Period Order Quantity", "Least Unit Cost", "Least Total Cost"};
	
@FXML private BorderPane borderLayou;
@FXML private Pane centerPanel;
@FXML private GridPane gpCenterPanel;
@FXML private Label labTecnica;
@FXML private Label labLeadTime;
@FXML private Label labAvailableInventory;
@FXML private Label labSecurityInventory;
@FXML private Label labCode;
@FXML private Label labItemName;
@FXML private TextField TfLeadTime;
@FXML private TextField TfAvalibleInvetary;
@FXML private TextField TfSecurityInventory;
@FXML private TextField TfCode;
@FXML private TextField TfOrderCost;
@FXML private Label labMaintenanceCost;
@FXML private Label labPreparationCost;
@FXML private Label labItemCost;
@FXML private TextField TfMaintenanceCost;
@FXML private TextField TfItemCost;
@FXML private TextField TfItemName;
@FXML private ChoiceBox<String> CbLotTec;
@FXML private Pane centralPanel;
@FXML private ScrollPane spCentralPanel;
@FXML private GridPane gpSpCentralPanel;
@FXML private Label labGrossRequirements;
@FXML private Label labScheduledReceptions;
@FXML private Label lavAvalibeSchudeleInventory;
@FXML private Label labNetRequeriments;
@FXML private Label labScheduledOrders;
@FXML private Label labReleaseOrders;
@FXML private Label labTime;
@FXML private TextField tfGrossRequeriment;
@FXML private TextField tfScheduledReceptions;
@FXML private Pane topPanel;
@FXML private Label labMpsTittle;
@FXML private Pane underPanel;
@FXML private GridPane gpUnderPanel;
@FXML private Button butUpdateData;
@FXML private Button butAddTimes;
@FXML private Button butDeleteTimes;

@FXML private ArrayList<TextField> textFBruteRequirements;
@FXML private ArrayList<TextField> textFScheduledReceptions;
@FXML private ArrayList<TextField> textFScheduledAvailableStock;
@FXML private ArrayList<TextField> textFNetRequirements;
@FXML private ArrayList<TextField> textFPlanOrders;
@FXML private ArrayList<TextField> textFReleasedPlanOrders;

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
		MasterPlanSchedule mps = new MasterPlanSchedule(CbLotTec.getValue(), Integer.parseInt(TfLeadTime.getText()), Integer.parseInt(TfAvalibleInvetary.getText()), Integer.parseInt(TfSecurityInventory.getText()), TfCode.getText(), TfItemName.getText(), Double.parseDouble(TfItemCost.getText()), Double.parseDouble(TfOrderCost.getText()), Double.parseDouble(TfMaintenanceCost.getText()), "", 0);
		for(int i = 0; i < textFBruteRequirements.size(); i++) {
			mps.addBruteRequirement(Integer.parseInt(textFBruteRequirements.get(i).getText()));
			mps.addScheduleReception(Integer.parseInt(textFScheduledReceptions.get(i).getText()));
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
		textFBruteRequirements = new ArrayList<TextField>();
		textFScheduledReceptions = new ArrayList<TextField>();
		textFScheduledAvailableStock = new ArrayList<TextField>();
		textFNetRequirements = new ArrayList<TextField>();
		textFPlanOrders = new ArrayList<TextField>();
		
		CbLotTec.setItems(FXCollections.observableArrayList(LOT_SIZING_METHODS));
	}
	
}


