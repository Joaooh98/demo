package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    private TextField operando1;
    private TextField operando2;
    private Label resultado;

    @Override
    public void start(Stage primaryStage) {
        // Criando a interface gráfica
        GridPane root = new GridPane();

        Label label1 = new Label("Operando 1:");
        operando1 = new TextField();
        Label label2 = new Label("Operando 2:");
        operando2 = new TextField();
        Label label3 = new Label("Resultado:");
        resultado = new Label();

        Button botaoSoma = new Button("+");
        botaoSoma.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular("+");
            }
        });

        Button botaoSubtracao = new Button("-");
        botaoSubtracao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular("-");
            }
        });

        Button botaoMultiplicacao = new Button("*");
        botaoMultiplicacao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular("*");
            }
        });

        Button botaoDivisao = new Button("/");
        botaoDivisao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular("/");
            }
        });

        root.add(label1, 0, 0);
        root.add(operando1, 1, 0);
        root.add(label2, 0, 1);
        root.add(operando2, 1, 1);
        root.add(label3, 0, 2);
        root.add(resultado, 1, 2);
        root.add(botaoSoma, 0, 3);
        root.add(botaoSubtracao, 1, 3);
        root.add(botaoMultiplicacao, 0, 4);
        root.add(botaoDivisao, 1, 4);

        // Configurando a cena e exibindo a janela
        Scene scene = new Scene(root, 250, 200);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calcular(String operador) {
        double op1 = Double.parseDouble(operando1.getText());
        double op2 = Double.parseDouble(operando2.getText());
        double res = 0.0;

        switch(operador) {
            case "+":
                res = op1 + op2;
                break;
            case "-":
                res = op1 - op2;
                break;
            case "*":
                res = op1 * op2;
                break;
            case "/":
                if(op2 != 0) {
                    res = op1 / op2;
                } else {
                    resultado.setText("Erro: divisão por zero!");
                    return;
                }
                break;
        }

        resultado.setText(Double.toString(res));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
