module se.linda.gamecenter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires jdk.incubator.vector;
    requires java.desktop;

    opens se.linda.gamecenter to javafx.fxml;
    exports se.linda.gamecenter;
    exports se.linda.gamecenter.Games;
    opens se.linda.gamecenter.Games to javafx.fxml;
    exports se.linda.gamecenter.Controllers;
    opens se.linda.gamecenter.Controllers to javafx.fxml;
}