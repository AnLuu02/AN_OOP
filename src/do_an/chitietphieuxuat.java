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
public class chitietphieuxuat extends danhsachhoadonxuat implements Serializable {

    public chitietphieuxuat() {
        super();
    }

    public chitietphieuxuat(hoadonxuat[] hdx, int soluong) {
        super(hdx, soluong);
    }

    public void nhap() throws IOException {

    }

    public void xuatchitietphieuxuat() throws IOException {
        do {
            super.doc_file("hoadonxuat.txt");
            super.HienThi();
            int dem = 0;
            System.out.println("");
            System.out.println("+-----------------------+");
            System.out.println("|          MENU         |");
            System.out.println("+-----------------------+");
            System.out.println("| 1. Chi tiết hóa đơn   |");
            System.out.println("| 0. Kết thúc           |");
            System.out.println("+-----------------------+");
            System.out.println("Nhập lựa chọn: ");
            chon = kt.KiemTraNhapChuoi();
            switch (chon) {
                case "0":
                    break;
                case "1":
                    String mahoadonxuat;
                    System.out.println("");
                    System.out.println("- Nhập mã hóa đơn xuất: ");
                    mahoadonxuat = kt.KiemTraNhapMaHoaDon();
                    System.out.println("");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-   Chi tiết  -+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                    System.out.println("+---------------------------------------------------------------+");
                    System.out.println("|\t\t\tDanh sách sản phẩm\t\t\t|");
                    System.out.println("+---------------------------------------------------------------+");
                    System.out.printf("|%-15s|%-20s|%-10s|%-15s|\n", "Mã SP", "Tên SP", "Giá", "Số lượng");
                    System.out.println("+---------------------------------------------------------------+");
                    for (int i = 0; i < super.hdx.length; i++) {
                        if (super.hdx[i].getMahoadon().equals(mahoadonxuat)) {
                            dem++;
                            for (int j = 0; j < super.hdx[i].spcm.length; j++) {
                                System.out.printf("|%-15s|%-20s|%-10s|%-15s|\n", super.hdx[i].spcm[j].getMaSP(), super.hdx[i].spcm[j].getTenSP(), super.hdx[i].spcm[j].getGia(), super.hdx[i].spcm[j].getSoluong());

                            }
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("- Mã hóa đơn: " + super.hdx[i].getMahoadon());
                            System.out.println("- Ngày xuất: " + super.hdx[i].getNgayxuat());
                            System.out.println("- Thành tiền: " + super.hdx[i].thanhtien);
                        }
                    }
                    if (dem == 0) {
                        System.out.println("- Hóa đơn không tồn tại.");
                    } else {
                    }
                    System.out.println("");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!!!");
            }
        } while (!chon.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        chitietphieuxuat hd = new chitietphieuxuat();
        hd.xuatchitietphieuxuat();
    }
}
