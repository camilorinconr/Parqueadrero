package modelo.VO;

public class FuncionesVO {

    public static Integer tipo(String tipo) {
        if (tipo.equals("Carro")) {
            return 1;
        } else {
            return 2;
        }
    }

    public static Boolean validarAuto(IngresoVO i) {
        if (i.getPlaca().length() == 6 && i.getTipo() == 1) {
            return true;
        } else return i.getPlaca().length() == 5 && i.getTipo() == 2;
    }
}
