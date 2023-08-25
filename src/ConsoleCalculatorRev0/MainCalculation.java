package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.Objects.CalculatorUser;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {


//    Реализовать консольный калькулятор с операциями + - * /.
//  Для хранения операций использовать коллекции, а так же файлы и предоставить возможность в коде переключаться между ними.
//  1) Добавить просмотр истории в меню калькулятора.
//    2) Добавить возможность хранить историю вычислений в коллекции
//    3) Добавить возможность регистрации пользователей. После регистрации пользователь должен быть сохранен в файле
//            4) Добавить метод для авторизации старого пользователя
//            5) Теперь после регистарации пользователя история вычислений должна хранить его персональный ID
//    и должен появиться порядковый номер вычисления(сквозная нумерация)


    public static void main(String[] args) {

        //Create object of class CalculatorUser
        CalculatorUser calculatorUser = new CalculatorUser();


        //Create object of class StartApplication
        StartApplication startApplication = new StartApplication(calculatorUser);


        //Begin and enjoy!!!
        startApplication.start();



    }


}

