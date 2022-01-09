/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class nhacungcap implements Serializable {

    protected String manhacungcap;
    protected String tennhacungcap;
    protected String diachi;
    protected String dienthoai;
    protected String mail;
    static kiemtra kt = new kiemtra();

    public nhacungcap() {
    }

    public nhacungcap(String manhacungcap, String tennhacungcap, String diachi, String dienthoai, String mail) {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.mail = mail;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        System.out.println("Mã nhà cung cấp: ");
        manhacungcap = kt.KiemTraNhapMaNhaCungCap();
        this.manhacungcap = manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        System.out.println("Tên nhà cung cấp: ");
        tennhacungcap = kt.KiemTraNhapTenSanPham();
        this.tennhacungcap = tennhacungcap;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        System.out.println("Địa chỉ: ");
        diachi = kt.KiemTraNhapChuoi();
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        System.out.println("Điện thoại: ");
        dienthoai = kt.KiemTraNhapChuoi();
        this.dienthoai = dienthoai;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        System.out.println("Mail: ");
        mail = kt.KiemTraNhapChuoi();
        this.mail = mail;
    }

    public void nhap() {
        setManhacungcap(getManhacungcap());
        setTennhacungcap(getTennhacungcap());
        setDiachi(getDiachi());
        setDienthoai(getDienthoai());
        setMail(getMail());
    }

    public void xuatncc() {
        System.out.printf("|%-15s|%-15s|%-20s|%-15s|%-20s|\n", getManhacungcap(), getTennhacungcap(), getDiachi(), getDienthoai(), getMail());
    }

}
