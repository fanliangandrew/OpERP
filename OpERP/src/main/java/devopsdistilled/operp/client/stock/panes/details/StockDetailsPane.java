package devopsdistilled.operp.client.stock.panes.details;

import javax.inject.Inject;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class StockDetailsPane extends
		AbstractEntityDetailsPane<StockKeeper, StockController> {

	@Inject
	private StockController stockController;

	private StockKeeper stockKeeper;
	private final JPanel pane;
	private final JTextField stockIdField;
	private final JLabel lblItem;
	private final JTextField itemField;
	private final JLabel lblWarehouse;
	private final JTextField warehouseField;
	private final JLabel lblQuantity;
	private final JTextField quantityField;
	private final JLabel lblDate;
	private final JTextField dateField;

	public StockDetailsPane() {
		pane = new JPanel(new MigLayout("debug", "[][grow]", "[][][][][][]"));
		JLabel lblStockId = new JLabel("Stock Id");
		pane.add(lblStockId, "cell 0 0");

		stockIdField = new JTextField();
		stockIdField.setEditable(false);
		stockIdField.setColumns(10);
		pane.add(stockIdField, "cell 1 0,growx");

		lblItem = new JLabel("Item ");
		pane.add(lblItem, "cell 0 1,alignx trailing");

		itemField = new JTextField();
		itemField.setEditable(false);
		pane.add(itemField, "cell 1 1,growx");
		itemField.setColumns(10);

		lblWarehouse = new JLabel("warehouse");
		pane.add(lblWarehouse, "cell 0 2,alignx trailing");

		warehouseField = new JTextField();
		warehouseField.setEditable(false);
		pane.add(warehouseField, "cell 1 2,growx");
		warehouseField.setColumns(10);

		lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 3,alignx trailing");

		quantityField = new JTextField();
		quantityField.setEditable(false);
		pane.add(quantityField, "cell 1 3,growx");
		quantityField.setColumns(10);

		lblDate = new JLabel("Date");
		pane.add(lblDate, "cell 0 4,alignx trailing");

		dateField = new JTextField();
		dateField.setEditable(false);
		pane.add(dateField, "cell 1 4,growx");
		dateField.setColumns(10);

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(StockKeeper stockKeeper) {

		this.stockKeeper = stockKeeper;

		if (stockKeeper != null) {
			stockIdField.setText(stockKeeper.getStockId().toString());
			itemField.setText(stockKeeper.getItem().getItemName());
			warehouseField.setText(stockKeeper.getWarehouse().getWarehouseName());
			quantityField.setText(stockKeeper.getQuantity().toString());
			dateField.setText(stockKeeper.getDate().toString());
			showDetailsPane(getPane());
		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "Stock is null");
		}
	}

	@Override
	public String getTitle() {
		return "Stock Details";
	}

	@Override
	public StockController getEntityController() {
		return stockController;
	}

	@Override
	protected StockKeeper getEntity() {
		return stockKeeper;
	}

}
