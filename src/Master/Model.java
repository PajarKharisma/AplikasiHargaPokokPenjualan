package Master;

public class Model {
    protected String tableName;

    public Model() {
    }

    public Model(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
