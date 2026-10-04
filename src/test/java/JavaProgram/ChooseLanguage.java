package JavaProgram;

public class ChooseLanguage {

    public static void main(String[] args) {

        int selection = 1;
        String result = "";

        if (selection == 1) {
            result = "Hello, thank you for your call";
        } else if (selection == 2) {
            result = "Hola, gracias por llamar";
        } else if (selection == 3) {
            result = "Merhaba, aradığınız için teşekkürler";
        } else if (selection == 4) {
            result = "Привет, спасибо за ваш звонок";
        } else if (selection == 5) {
            result = "Merci de nous avoir appelés";
        } else {
            result = "Invalid selection. Please choose 1 to 5.";
        }

        System.out.println(result);
    }
}