package DesignPattern.Structural.Adapter;

public class Program {
}

class JsonData{

}

class XmlData{

    public JsonData covertToJson(){
        return new JsonData();
    }
}

interface IMultiRestaurantApp{
    void displayMenus(XmlData xmlData);
    void displayRecommendations(XmlData xmlData);
}

class FancyUIServiceAdapter implements  IMultiRestaurantApp{

    private final FancyUIService fancyUIService;

    public FancyUIServiceAdapter() {
        this.fancyUIService = new FancyUIService();
    }

    @Override
    public void displayMenus(XmlData xmlData) {
        JsonData jsonData = xmlData.covertToJson();
        fancyUIService.displayMenus(jsonData);
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        JsonData jsonData = xmlData.covertToJson();
        fancyUIService.displayRecommendations(jsonData);
    }
}


class FancyUIService{
    public void displayMenus(JsonData jsonData){

    }

    public void displayRecommendations(JsonData jsonData){

    }
}
