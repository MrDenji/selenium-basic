import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVTest {
    @Test
    public void verifyCSVRead(){
        MountainReader.readFile();
        Assert.assertEquals(MountainReader.mountainList.get(0).name, "Mont Blanc");
        Assert.assertEquals(MountainReader.mountainList.get(0).height, 4807);
    }
    @Test
    public void verifyFileRead(){
        MountainReader.readSimpleFile();
        Assert.assertEquals(MountainReader.mountainStrings.get(1).split(",")[0], "Mont Blanc");
    }

    @Test
    public void verifySortedCSVRead(){
        MountainReader.readFile();
        List<Mountain> sortedList = MountainReader.mountainList.stream()
                .sorted(Comparator.comparingInt(Mountain::getHeight))
                .toList();

        Assert.assertEquals(sortedList.get(0).name, "Dom");
    }
}
