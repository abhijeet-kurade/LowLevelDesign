package ARG;

public class KustoStrategy implements IStrategy{
    String kustoQuery;

    String starTime;
    String endTime;

    public KustoStrategy(String kustoQuery, String starTime, String endTime) {
        this.kustoQuery = kustoQuery;
        this.starTime = starTime;
        this.endTime = endTime;
    }

    @Override
    public void execute() {

    }
}
