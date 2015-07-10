import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GrillotP1 extends Application {
	public static void main(String args[]) {
		GrillotP1.launch(args);
	}

	private static final Paint BACKGROUND_PAINT = Color.DARKGRAY, OFF_PAINT = Color.DIMGRAY, ON_PAINT = Color.TOMATO;

	private final int LIGHT_SIZE = 100;
	private Light[][] lights;
	private Text status;

	private final int GAME_SIZE = 5;
	private boolean[][] states;
	private int turns;
	private int minturns;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Lights Out");
		stage.setResizable(false);
		stage.initStyle(StageStyle.DECORATED);

		BorderPane layout = new BorderPane();
		layout.setStyle("-fx-background: transparent;");
		stage.setScene(new Scene(layout, BACKGROUND_PAINT));

		VBox stack = new VBox(20);
		stack.setPadding(new Insets(35, 35, 0, 35));

		lights = new Light[GAME_SIZE][GAME_SIZE];
		TilePane layer = new TilePane();
		layer.setPrefColumns(GAME_SIZE);
		layer.setPrefTileWidth(LIGHT_SIZE);
		layer.setPrefTileHeight(LIGHT_SIZE);
		layer.setHgap(5);
		layer.setVgap(5);
		layer.setPadding(new Insets(0, 5, 0, 5));
		for (int i = 0; i < GAME_SIZE; i++) {
			for (int j = 0; j < GAME_SIZE; j++) {
				lights[i][j] = new Light(i, j);
				layer.getChildren().add(lights[i][j]);
			}
		}
		layer.setStyle("-fx-effect: dropshadow(gaussian, black, 8, 0.7, 0, 0);");
		stack.getChildren().add(layer);

		layout.setCenter(stack);

		MenuBar menus = new MenuBar();
		Menu game = new Menu("Game");
		menus.getMenus().addAll(game);

		MenuItem newgame = new MenuItem("New Game");
		newgame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0){
				initialize();
			}
		});

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				exitGame();
			}
		});

		game.getItems().addAll(newgame, new SeparatorMenuItem(), exit);
		layout.setTop(menus);

		status = new Text("Loading...");
		status.setFont(new Font(24));
		status.setStyle("-fx-font-weight: bold; " + "-fx-effect: dropshadow(gaussian, black, 8, 0.7, 0, 0);");
		status.setFill(ON_PAINT);
		HBox statusbar = new HBox();
		statusbar.setPadding(new Insets(0, 15, 15, 15));
		statusbar.getChildren().add(status);
		layout.setBottom(statusbar);

		stage.show();

		initialize();
	}

	private class Light extends Rectangle {
		private int row, col;

		public Light(int row, int col) {
			this.row = row;
			this.col = col;
			this.setWidth(LIGHT_SIZE);
			this.setHeight(LIGHT_SIZE);
			this.setFill(OFF_PAINT);
			this.setStyle("-fx-effect: innershadow(gaussian, gray, 18, 0.5, 0, 0);");
			this.setArcWidth(10);
			this.setArcHeight(5);
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					int tmp = checkEmpty();
					if (tmp != 0) {
						processLightClick(Light.this.row, Light.this.col);
						turns++;
						status.setText("Turn Number " + turns);
					}
					tmp = checkEmpty();
					if (tmp == 0){
						status.setText("Game Over, in " + turns + ". Solvable in " + minturns);
					}
				}
			});
		}
	}
	
	private int checkEmpty(){
		int tmp = 0;
		for (int n = 0; n < 5; n++) {
			for (boolean b : states[n]) {
				if (b) {
					tmp++;
				}
			}
		}
		return tmp;
	}

	private void initialize() {
		newGame();
		repaintLights();
		setBoard();
	}

	public void newGame() {
		states = new boolean[GAME_SIZE][GAME_SIZE];

		turns = 1;
		status.setText("Turn Number " + turns);
	}

	public void exitGame() {
		Platform.exit();
	}

	public void repaintLights() {
		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights[0].length; j++) {
				lights[i][j].setFill(OFF_PAINT);
			}
		}
	}

	public void processLightClick(int row, int col) {
		int colstart = col;
		for (int i = -1; i < 2; i++) {
			if (row + i >= 0 && row + i <= 4) {
				if (lights[row + i][col].getFill().toString().equalsIgnoreCase("0x696969ff")) {
					lights[row + i][col].setFill(ON_PAINT);
					states[row + i][col] = true;
				} else {
					lights[row + i][col].setFill(OFF_PAINT);
					states[row + i][col] = false;
				}
			}
		}
		for (int i = -1; i < 2; i++) {
			if (col + i != colstart && col + i >= 0 && col + i <= 4) {
				if (lights[row][col + i].getFill().toString().equalsIgnoreCase("0x696969ff")) {
					lights[row][col + i].setFill(ON_PAINT);
					states[row][col + i] = true;
				} else {
					lights[row][col + i].setFill(OFF_PAINT);
					states[row][col + i] = false;
				}
			}
		}

	}
	
	public void setBoard(){
		Random rand = new Random();
		minturns = rand.nextInt(6) + 5;
		minturns = 1;
		int[] rows = new int[minturns]; 
		int[] cols = new int[minturns];
		for (int k = 0; k < minturns; k++){
			rows[k] = rand.nextInt(5);
			cols[k] = rand.nextInt(5);
		}
		for (int m = 0; m < minturns; m++){
			processLightClick(rows[m], cols[m]);
		}
	}
}
