package jdbc_h2;

public interface H2JDBC <Model> {

    abstract void createTable();

    abstract void insertRecord(Model model);

    abstract void updateRecord(Model model);

    abstract void deleteRecord();

    abstract void selectRecord();

}
