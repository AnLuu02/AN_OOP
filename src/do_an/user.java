/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class user extends dangnhap {

    public user() {
        super();
    }

    public user(String taikhoan, String matkhau) {
        super(taikhoan, matkhau);
    }

    @Override
    public void nhap() {
        super.nhap();
        if ("user".equals(taikhoan) && "user".equals(matkhau)) {
            do {
                try {
                    System.out.println("");
                    System.out.println("+-----------  Welcom to User!  ----------+");
                    System.out.println("+========================================+");
                    System.out.println("|               MENU User                |");
                    System.out.println("+========================================+");
                    System.out.println("| 1. Quản lí phiếu nhập                  |");
                    System.out.println("| 2. Chi tiết phiếu nhập                 |");
                    System.out.println("| 3. Quản lí phiếu xuất                  |");
                    System.out.println("| 4. Chi tiết phiếu xuất                 |");
                    System.out.println("| 0. Exit                                |");
                    System.out.println("+========================================+");
                    System.out.println("- Bạn hãy nhập lựa chon: ");
                    chon = sc.nextLine();
                    switch (chon) {
                        case "1":
                            danhsachhoadonnhap dspn = new danhsachhoadonnhap();
                            dspn.menu();
                            break;
                        case "2":
                            chitietphieunhap ctpn = new chitietphieunhap();
                            ctpn.xuatchitietphieunhap();
                            break;
                        case "3":
                            danhsachhoadonxuat dsx = new danhsachhoadonxuat();
                            dsx.menu();
                            break;
                        case "4":
                            chitietphieuxuat ctpx = new chitietphieuxuat();
                            ctpx.xuatchitietphieuxuat();
                            break;
                        case "0":
                            System.out.println("--------- Hẹn gặp lại! ---------");
                            System.out.println("");
                            break;
                        default:
                            System.out.println("- Sai! Mời nhập lại (hãy nhập trong khoảng từ 0->8): ");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }

            } while (!chon.equals("0"));
        } else {
            System.out.println("- Sai thông tin đăng nhập!!!!!");
        }
    }
}