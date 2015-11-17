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
			//Level 6
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
			level1 = new Level();
			//Level 7
			level1.setPoolSteenInArray(2, 1);
			level1.setNoordPoolInArray(1, 3);
			level1.setZuidPoolInArray(3, 3);
			level1.setGridx(4);
			level1.setGridy(4);
			level1.setSintx(0);
			level1.setSinty(0);
			//Grid.setGridsizepixels(90);
			level1.setHuisInArray(1,2);
			level1.setTeBehalenPunten(1);
			level1.setScoreVoorDrieSterren(1);
			
			levels.add(level1);
			level1 = new Level();
			//Level 7
			
			level1.setGridx(11);
			level1.setGridy(7);
			level1.setSintx(0);
			level1.setSinty(0);
			level1.setPoolSteenInArray(5, 3);
			
			level1.setNoordPoolInArray(2, 0);
			level1.setNoordPoolInArray(3, 0);
			level1.setNoordPoolInArray(2, 1);
			level1.setNoordPoolInArray(3, 1);
			level1.setNoordPoolInArray(2, 2);
			level1.setNoordPoolInArray(3, 2);
			level1.setNoordPoolInArray(2, 3);
			level1.setNoordPoolInArray(3, 3);
			level1.setNoordPoolInArray(1, 2);
			level1.setNoordPoolInArray(1, 3);
			level1.setNoordPoolInArray(0, 2);
			level1.setNoordPoolInArray(0, 3);
			
			level1.setNoordPoolInArray(8, 0);
			level1.setNoordPoolInArray(9, 0);
			level1.setNoordPoolInArray(8, 1);
			level1.setNoordPoolInArray(9, 1);
			level1.setNoordPoolInArray(8, 2);
			level1.setNoordPoolInArray(9, 2);
			level1.setNoordPoolInArray(10, 1);
			level1.setNoordPoolInArray(10, 2);
			
			level1.setZuidPoolInArray(7, 3);
			level1.setZuidPoolInArray(8, 3);
			level1.setZuidPoolInArray(7, 4);
			level1.setZuidPoolInArray(8, 4);
			level1.setZuidPoolInArray(7, 5);
			level1.setZuidPoolInArray(8, 5);
			level1.setZuidPoolInArray(7, 6);
			level1.setZuidPoolInArray(8, 6);
			level1.setZuidPoolInArray(9, 3);
			level1.setZuidPoolInArray(9, 4);
			level1.setZuidPoolInArray(10, 3);
			level1.setZuidPoolInArray(10, 4);
			
			level1.setHuisInArray(2,5);
			level1.setHuisInArray(10,0);
			//Grid.setGridsizepixels(90);
			level1.setHuisInArray(9,5);
			level1.setHuisInArray(1,1);
			
			
			level1.setTeBehalenPunten(4);
			level1.setScoreVoorDrieSterren(20);
			Tile.statusPoolsteen = 0;
			
			levels.add(level1);
	}
}