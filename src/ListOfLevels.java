import java.util.ArrayList;

public class ListOfLevels {
	Level level1 = new Level();
	Level level2 = new Level();
	ArrayList<Level> levels = new ArrayList();

public ListOfLevels(){
			Level level1 = new Level();
			//Level 1
			level1.setGridx(9);
			level1.setGridy(7);
			level1.setSintx(3);
			level1.setSinty(2);
			level1.setHuisInArray(0,2);
			level1.setHuisInArray(1,3);
			level1.setHuisInArray(6,5);
			level1.setHuisInArray(4,1);
			level1.setHuisInArray(3,3);
			level1.setHuisInArray(6,6);
			level1.setTeBehalenPunten(6);
			level1.setScoreVoorDrieSterren(13);
			level1.setWaterInArray(1, 1);
			level1.setWaterInArray(1, 2);
			level1.setWaterInArray(2, 1);
			level1.setWaterInArray(2, 2);
			level1.setWaterInArray(0, 4);
			level1.setWaterInArray(1, 4);
			level1.setWaterInArray(2, 4);
			level1.setWaterInArray(3, 4);
			level1.setWaterInArray(4, 4);
			level1.setWaterInArray(4, 5);
			level1.setModderInArray(4, 6);
			
			levels.add(level1);
			level1 = new Level();
			//Level 2
			level1.setGridx(5);
			level1.setGridy(5);
			level1.setSintx(0);
			level1.setSinty(0);
			level1.setHuisInArray(0,2);
			level1.setHuisInArray(3,3);
			level1.setTeBehalenPunten(2);
			level1.setWaterInArray(1, 1);
			level1.setWaterInArray(1, 2);
			level1.setWaterInArray(1, 3);
			
			levels.add(level1);
			level1 = new Level();
			//Level 3
			level1.setGridx(9);
			level1.setGridy(4);
			level1.setSintx(4);
			level1.setSinty(1);
			level1.setHuisInArray(0,2);
			level1.setHuisInArray(3,3);
			level1.setHuisInArray(8,3);
			level1.setTeBehalenPunten(3);
			level1.setWaterInArray(1, 1);
			level1.setWaterInArray(3, 2);
			level1.setWaterInArray(5, 2);
			level1.setWaterInArray(6, 0);
			level1.setWaterInArray(7, 3);
			level1.setWaterInArray(5, 0); 
			level1.setGridx(9);
			level1.setGridy(7);
			level1.setSintx(4);
			level1.setSinty(1);

			levels.add(level1);
			level1 = new Level();
			//Level 4
			level1.setGridx(7);
			level1.setGridy(7);
			level1.setSintx(0);
			level1.setSinty(1);
			level1.setHuisInArray(3,3);
			level1.setTeBehalenPunten(1);
			level1.setWaterInArray(0, 4);
			level1.setWaterInArray(2, 1);
			level1.setWaterInArray(1, 2);
			level1.setWaterInArray(2, 2);
			level1.setWaterInArray(2, 3);
			level1.setWaterInArray(2, 4);
			level1.setWaterInArray(2, 5);
			level1.setWaterInArray(3, 2);
			level1.setWaterInArray(3, 4);
			level1.setWaterInArray(1, 4);
			level1.setWaterInArray(4, 2);
			level1.setWaterInArray(4, 3);
			level1.setWaterInArray(4, 4);
			level1.setWaterInArray(4, 5);
			level1.setWaterInArray(4, 6);
			level1.setWaterInArray(5, 2);
			level1.setWaterInArray(5, 3);
			
			levels.add(level1);
			level1 = new Level();
			//Level 5
			level1.setGridx(4);
			level1.setGridy(4);
			level1.setSintx(0);
			level1.setSinty(0);
			level1.setHuisInArray(1,1);
			level1.setTeBehalenPunten(1);
			level1.setScoreVoorDrieSterren(4);
			level1.setWaterInArray(0, 3);
			level1.setWaterInArray(1, 2);
			level1.setWaterInArray(2, 2);
			level1.setWaterInArray(2, 3);
			level1.setWaterInArray(3, 3);
			
			levels.add(level1);
			level1 = new Level();
			//Level 5
			level1.sintHeeftCadeaus = false;
			level1.setGridx(4);
			level1.setGridy(4);
			level1.setSintx(0);
			level1.setSinty(0);
			level1.setPakHuisInArray(3, 3);
			level1.setHuisInArray(1,2);
			level1.setTeBehalenPunten(1);
			level1.setScoreVoorDrieSterren(1);
			
			levels.add(level1);
	}
}