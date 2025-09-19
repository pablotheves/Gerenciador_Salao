module com.cadm.gerenciadorsalao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    

    opens com.cadm.gerenciadorsalao to javafx.fxml;
    exports com.cadm.gerenciadorsalao;
    
    exports model.classes;
}
