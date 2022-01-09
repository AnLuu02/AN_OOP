/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class hoadonxuat extends danhsachsanpham implements Serializable {

    protected String ngayxuat;
    protected khachhang kh;
    protected nhanvienbanhang nvbh;
    protected String mahoadon;
    protected sanpham[] spcm;
    protected int thanhtien;
    protected int soluong;

    public hoadonxuat() {
    }

    public hoadonxuat(String ngayxuat, khachhang kh, nhanvienbanhang nvbh, String mahoadon, sanpham[] sp, int thanhtien, int soluong, sanpham[] spcm) {
        super(sp);
        this.ngayxuat = ngayxuat;
        this.kh = kh;
        this.nvbh = nvbh;
        this.mahoadon = mahoadon;
        this.spcm = spcm;
        this.thanhtien = thanhtien;
        this.soluong = soluong;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        System.out.println("- Mã hóa đơn: ");
        mahoadon = kt.KiemTraNhapMaHoaDon();
        this.mahoadon = mahoadon;
    }

    public sanpham[] getSpcm() {
        return spcm;
    }

    public void setSpcm(sanpham[] spcm) {
        this.spcm = spcm;
    }

    public int getThanhtien(int giasp, int soluongsp) {
        thanhtien = giasp * soluongsp;
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(String ngayxuat) {
        System.out.println("- Ngày bán: ");
        ngayxuat = kt.KiemTraNhapChuoi();
        this.ngayxuat = ngayxuat;
    }

    public khachhang getKh() {
        return kh;
    }

    public void setKh(khachhang kh) {
        kh = new khachhang();
        kh.setmakh(kh.getmakh());
        this.kh = kh;
    }

    public nhanvienbanhang getNvbh() {
        return nvbh;
    }

    public void setNvbh(nhanvienbanhang nvbh) {
        nvbh = new nhanvienbanhang();
        nvbh.setmanv(nvbh.getmanv());
        this.nvbh = nvbh;
    }

    
    public void nhap() throws IOException {
        setMahoadon(getMahoadon());
        setKh(getKh());
        setNvbh(getNvbh());
        setNgayxuat(getNgayxuat());
        int dem = 0;
        super.doc_file("sanpham.txt");
        super.HienThi();
        System.out.println("- Bạn cần mua bao nhiêu sản phẩm?");
        soluong = kt.KiemTraNhapSoNguyen();
        spcm = new sanpham[soluong];
        if (super.sp.length == 0) {
            System.out.println("- Hết hàng");
        } else {
            for (int i = 0; i < soluong; i++) {
                spcm[i] = new sanpham() {
                    @Override
                    public void HienThi() {}
                };
                spcm[i].setTenSP(spcm[i].getTenSP());
                spcm[i].setSoluong(spcm[i].getSoluong());
                for (int j = 0; j < super.sp.length; j++) {
                    if (super.sp[j].getTenSP().equals(spcm[i].getTenSP())) {
                        super.sp[j].soluong -= spcm[i].getSoluong();
                        spcm[i].maSP = super.sp[j].maSP;
                        spcm[i].gia = super.sp[j].gia;
                        dem++;
                    }
                }
                thanhtien += getThanhtien(spcm[i].getGia(), spcm[i].getSoluong());
                if (dem == 0) {
                    System.out.println("- Hiện cửa hàng đã hết " + spcm[i].getTenSP());
                } else {
                }
                file.ghi_file(super.sp, "sanpham.txt");
            }
        }

    }

    @Override
    public void HienThi() {
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", getMahoadon(), getKh().makh, getNvbh().manv, getNgayxuat(), thanhtien);
    }
}
