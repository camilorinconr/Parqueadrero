package modelo.VO;

import java.sql.Date;

/**
 *
 * @author CAMILO
 */
public class IngresoVO {

    private String placa;
    private Integer modelo;
    private Integer tipo;
    private Integer valor;
    private String fecha;

    public IngresoVO() {
    }

    public IngresoVO(String placa, Integer modelo, Integer tipo, Integer valor, String fecha) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.valor = valor;
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getValor() {

        if (this.modelo < 2012) {
            if (this.tipo == 1) {
                valor = 2000;
            } else {
                valor = 1000;
            }
        } else {

            if (this.tipo == 1) {
                valor = 2500;
                if (this.modelo == 2020) {
                    valor = (int) (valor * 1.2);
                }
            } else {
                valor = 1200;
                if (this.modelo == 2020) {
                    valor = (int) (valor * 1.1);
                }
            }
        }

        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

}
