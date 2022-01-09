/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class kiemtra {

    static Scanner scanner = new Scanner(System.in);

    public String KiemTraNhapChuoi() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            nhap = nhap.trim();
            if (nhap != null) {
                return nhap;
            } else {
                System.out.print("- Sai! Mời nhập lại: ");
            }
        }
    }

    public double KiemTraNhapGiaTien() {
        int nhap;
        while (true) {
            try {
                nhap = Integer.parseInt(scanner.nextLine());
                if (nhap >= 0) {
                    return nhap;
                } else {
                    System.out.print("- Giá tiền không hợp lệ ! Mời nhập lại: ");
                }
            } catch (NumberFormatException exception) {
                System.out.print("- Giá không đúng định dạng ! Mời nhập lại: ");
            }

        }
    }

    public String KiemTraNhapMaSanPham() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            nhap = nhap.toUpperCase();
            if (nhap.matches("SP" + "[0-9]{1,2}")) {
                return nhap;
            } else {
                System.out.println("- Định dạng mã sản phẩm: SP... Ví dụ: SP01");
            }
            System.out.print("- Mời nhập lại: ");

        }
    }

    public String KiemTraNhapTenSanPham() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            if (nhap.matches("[\\pL\\pMn*\\s*]+")) {
                nhap = nhap.trim();
                nhap = nhap.replaceAll("\\s+", " ");
                nhap = nhap.toLowerCase();
                String[] Chuoi = nhap.split(" ");
                nhap = "";
                for (int i = 0; i < Chuoi.length; i++) {
                    nhap += String.valueOf(Chuoi[i].charAt(0)).toUpperCase() + Chuoi[i].substring(1);
                    if (i < Chuoi.length - 1) {
                        nhap += " ";
                    }
                }
                return nhap;
            } else {
                System.out.print("- Tên không hợp lệ ! Mời nhập lại: ");
            }

        }
    }

    public int KiemTraNhapSoNguyen() {
        int nhap;
        while (true) {
            try {
                nhap = Integer.parseInt(scanner.nextLine());
                return nhap;
            } catch (NumberFormatException exception) {
                System.out.print("- Sai kiểu dữ liệu ! Mời nhập lại: ");
            }
        }
    }

    public int KiemTraNhapSoNguyenDuong() {
        int nhap;
        while (true) {
            nhap = KiemTraNhapSoNguyen();
            if (nhap > 0) {
                return nhap;
            } else {
                System.out.print("- Số nhập vào không được nhỏ hơn 0 ! Mời nhập lại: ");
            }
        }
    }

    public String KiemTraNhapMaNhanVien() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            nhap = nhap.toUpperCase();
            if (nhap.matches("NV" + "[0-9]{1,2}")) {
                return nhap;
            } else {
                System.out.println("- Định dạng mã sản phẩm: NV... Ví dụ: NV01");
            }
            System.out.print("- Mời nhập lại: ");

        }
    }

    public String KiemTraNhapMaKhachHang() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            nhap = nhap.toUpperCase();
            if (nhap.matches("KH" + "[0-9]{1,2}")) {
                return nhap;
            } else {
                System.out.println("- Định dạng mã sản phẩm: KH... Ví dụ: KH01");
            }
            System.out.print("- Mời nhập lại: ");

        }
    }

    public String KiemTraNhapMaHoaDon() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            nhap = nhap.toUpperCase();
            if (nhap.matches("HD" + "[0-9]{1,2}")) {
                return nhap;
            } else {
                System.out.println("- Định dạng mã sản phẩm: HD... Ví dụ: HD01");
            }
            System.out.print("- Mời nhập lại: ");

        }
    }

    public String KiemTraNhapMaNhaCungCap() {
        String nhap;
        while (true) {
            nhap = scanner.nextLine();
            nhap = nhap.toUpperCase();
            if (nhap.matches("NCC" + "[0-9]{1,2}")) {
                return nhap;
            } else {
                System.out.println("- Định dạng mã sản phẩm: NCC... Ví dụ: NCC01");
            }
            System.out.print("- Mời nhập lại: ");

        }
    }
}
