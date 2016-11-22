package cl.tuxy.webpay.dto;

/**
 * Created by josebovet on 11/21/16.
 */
public class TrxNormal extends TbkResponse {

    private int monto;
    private long orden;
    private String idSesion;

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public String toString() {
        return "TrxNormal{" +
                "monto=" + monto +
                ", orden=" + orden +
                ", idSesion='" + idSesion + '\'' +
                ", url=" + getUrl() +
                ", token=" + getToken() +
                '}';
    }
}
